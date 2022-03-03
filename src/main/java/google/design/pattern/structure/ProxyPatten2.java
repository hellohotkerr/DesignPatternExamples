package google.design.pattern.structure;

public class ProxyPatten2 {
    public class AccessValidator{
        public boolean validate(String userId){
            System.out.println("模拟在数据库中验证用户 "+userId+"是否为合法用户");
            if (userId.equalsIgnoreCase("杨过")) {
                System.out.println("登录成功");
                return true;
            }else{
                System.out.println("登录失败");
                return false;
            }
        }
    }
    public class Logger{
        public void log(String userId) {
            System.out.println("更新数据库，用户" + userId + ",次数加1");
        }
    }
    public interface Searcher{
        public String doSearch(String userId, String keyword);
    }
    public class RealSearcher implements Searcher{

        @Override
        public String doSearch(String userId, String keyword) {
            return "返回具体查询内容";
        }
    }
    public
    class ProxySearcher implements Searcher{
        private RealSearcher realSearcher = new RealSearcher();
        private AccessValidator validator = new AccessValidator();

        private Logger logger = new Logger();
        @Override
        public String doSearch(String userId, String keyword) {
            if (validate(userId)) {
                String result = realSearcher.doSearch(userId, keyword);
                log(result);
                return result;
            }
            return null;
        }

        public boolean validate(String userId) {
            return validator.validate(userId);
        }

        public void log(String userId) {
            logger.log(userId);
        }
    }
}
