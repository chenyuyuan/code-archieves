package spto.question02;

public class Singleton {
    private Singleton(){

    }
    public Singleton getSingleton() {
        Singleton singleton = new Singleton();
        return singleton;
    }
}
