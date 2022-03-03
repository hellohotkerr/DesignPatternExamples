package google.design.pattern.structure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DynamicProxyPatten {
    public interface AbstractUserDAO{
        public Boolean findUserById(String userId);
    }
    public interface AbstractDocumentDAO{
        public Boolean deleteDocumentById(String documentId);
    }
    public class UserDAO implements  AbstractUserDAO {

        @Override
        public Boolean findUserById(String userId) {
            if (userId.equalsIgnoreCase("张无忌")) {
                System.out.println("查询成功" );
                return true;
            }else{
                System.out.println("查询失败" );
                return false;
            }
        }
    }
    public class DocumentDAO implements AbstractDocumentDAO{

        @Override
        public Boolean deleteDocumentById(String documentId) {
            if (documentId.equalsIgnoreCase("D001")) {
                System.out.println("删除成功" );
                return true;
            }else{
                System.out.println("删除失败" );
                return false;
            }
        }
    }

    public class DAOLogHandler implements InvocationHandler{
        private Calendar calendar ;
        private Object object;

        public DAOLogHandler() {
        }

        public DAOLogHandler(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            beforeInvoke();
            Object result = method.invoke(object, args);
            afterInvoke();
            return result;
        }

        private void afterInvoke() {
            System.out.println("调用方法结束");
        }

        private void beforeInvoke() {
            calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);
            String time = hour +":"+ minute + ":"+second;
            System.out.println("调用时间为： " + time);
        }
        public class Client{
            public  void main(String[] args) {
                InvocationHandler handler= null;
                AbstractUserDAO userDAO = new UserDAO();
                handler = new DAOLogHandler(userDAO);
                AbstractUserDAO proxy = null;
                proxy = (AbstractUserDAO) Proxy.newProxyInstance(AbstractUserDAO.class.getClassLoader(),
                        new Class[]{AbstractUserDAO.class}, handler);
                proxy.findUserById("张无忌");
                AbstractDocumentDAO docDAO = new DocumentDAO();
                handler = new DAOLogHandler(docDAO);
                AbstractDocumentDAO proxy_new = null;
                proxy_new = (AbstractDocumentDAO) Proxy.newProxyInstance(AbstractDocumentDAO.class.getClassLoader(),
                        new Class[]{AbstractDocumentDAO.class},handler);
                proxy_new.deleteDocumentById("D002");
            }
        }
    }
}
