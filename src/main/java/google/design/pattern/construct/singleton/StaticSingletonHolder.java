package google.design.pattern.construct.singleton;

public class StaticSingletonHolder {
    private StaticSingletonHolder(){

    }
    public static class SingletonHolder {
        private static final StaticSingletonHolder INSTANCE = new StaticSingletonHolder();
    }
    public static StaticSingletonHolder getINSTANCE() {
        return SingletonHolder.INSTANCE;
    }




}

