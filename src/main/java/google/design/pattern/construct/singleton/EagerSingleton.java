package google.design.pattern.construct.singleton;

//饿汉单例
public class EagerSingleton{
    private EagerSingleton() {
    }
    private  static final EagerSingleton instance = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return instance;
    }

}