package google.design.pattern.construct.singleton;

public class LazySingleton {
    private LazySingleton() {
    }
    private volatile static LazySingleton  instance = null;
    public static LazySingleton getInstance() {
        //第一重判断
        if (instance == null) {
            //锁定代码块
            synchronized (LazySingleton.class) {
                //第二重判断
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
