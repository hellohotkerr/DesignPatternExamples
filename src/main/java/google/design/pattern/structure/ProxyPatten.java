package google.design.pattern.structure;

public class ProxyPatten {
    public abstract class Subject{
        public abstract void request();
    }
    public class RealSubject extends Subject{

        @Override
        public void request() {
            //detail...
        }
    }
    public class Proxy extends Subject{
        private RealSubject realSubject = new RealSubject();
        public void preRequest() {
            //....
        }

        @Override
        public void request() {
            preRequest();
            realSubject.request();
            postRequest();
        }
        public void postRequest() {
            //....
        }

    }
}
