package google.design.pattern.behavior;

public class ChainOfResponsibilityPatten {
    public abstract class Handler{
        //维持对下家的引用
        protected Handler successor;

        public void setSuccessor(Handler successor) {
            this.successor = successor;
        }

        public abstract void handleRequest(String request);
    }

    public class ConcreteHandlerA extends Handler{

        @Override
        public void handleRequest(String request) {
            boolean canHandle = true;
            if (canHandle) {
                //处理请求....
            }else{
                this.successor.handleRequest(request);//转发请求
            }

        }
    }
    public class ConcreteHandlerB extends Handler{

        @Override
        public void handleRequest(String request) {
            boolean canHandle = true;
            if (canHandle) {
                //处理请求....
            }else{
                this.successor.handleRequest(request);//转发请求
            }

        }
    }
    public class ConcreteHandlerC extends Handler{

        @Override
        public void handleRequest(String request) {
            boolean canHandle = true;
            if (canHandle) {
                //处理请求....
            }else{
                this.successor.handleRequest(request);//转发请求
            }

        }
    }
    public class Client{
        public  void main(String[] args) {
            Handler handler1,handler2,handler3;
            handler1 = new ConcreteHandlerA();
            handler2 = new ConcreteHandlerB();
            handler3 = new ConcreteHandlerC();
            handler1.setSuccessor(handler2);
            handler2.setSuccessor(handler3);
            handler1.handleRequest("请求对象");

        }
    }
}
