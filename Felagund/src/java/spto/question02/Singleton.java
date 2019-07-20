package spto.question02;

// 单例模式
// ##懒汉式,线程安全##
public class Singleton {
    private final static Singleton INSTANCE = new Singleton();
    private Singleton(){

    }
    public static Singleton getInstance() {
        return INSTANCE;
    }
}

// 懒汉式, 线程不安全
class Singleton1 {
    private static Singleton1 instance = null;
    private Singleton1() {

    }
    public static Singleton1 getInstance() {
        if(instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}

// 饿汉式, 线程安全, 但多线程的环境下效率不高
class Singleton2 {
    private static Singleton2 instance = null;
    private Singleton2() {

    }
    private static synchronized Singleton2 getInstance() {
        if(instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

// 饿汉式, 线程安全
class Singleton3 {
    private static Singleton3 instance = null;
    static {
        instance = new Singleton3();
    }
    private Singleton3() {

    }
    public static Singleton3 getInstance() {
        return instance;
    }
}

// ##懒汉式,静态内部类,线程安全(Recommend)##
class Singleton4 {
    private final static class SingletonHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }
    private Singleton4() {

    }
    public static Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

// 静态内部类, 使用枚举的方式, 线程安全(Recommend)
enum Singleton5 {
    INSTANCE;
    public void whateverMethod() {

    }
}

// ##静态内部类, 使用双重校验锁, 线程安全(Recommend)##
class Singleton6 {
    private volatile static Singleton6 instance = null;
    private Singleton6() {

    }
    public static Singleton6 getInstance() {
        if(instance == null) {
            synchronized (Singleton6.class) {
                if(instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}