package LLD.DesignPatterns.singleton;


// its lazy initialized + synchronized
public class Singletone {
    private static  Singletone instance;

    // Private constructor prevents instantiation
    private Singletone() {}

    public static synchronized Singletone getInstance() {
        if (instance == null) { // lazy initialized
            instance = new Singletone();
        }
        return instance;
    }
}
/*
Application : logging framework, cache instance, db, threadpools
 */