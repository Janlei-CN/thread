package com.janlei.test;

public class Singleton implements Cloneable{
    protected RunnableDemo no;
    protected static RunnableDemo sticno;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * JVM反复加载
     */
    {
        no=new RunnableDemo();
        int i=0;
        System.out.println("dy"+no.hashCode());
        System.out.println(
                ++i
        );
    }

    /**
     * JVM只会加载一次
     */

        static{
            sticno=new RunnableDemo();
            System.out.println("static"+sticno.hashCode());
        }
    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
     */
    private static class SingleHolder{
        private static Singleton instance = new Singleton();
    }

    /**
     * 私有化构造方法
     */
    public  Singleton(){}

    public static Singleton getInstance(){
        return SingleHolder.instance;
    }


}

/**
 * dy1020371697
 * 1
 * static789451787
 * dy1950409828
 * 1
 * -----------------
 * 在实例化的编译过程中 JVM会反复加载普通块
 */
class Client{
    public static void main(String[] args) {
        String  s2="zhangsan";
        String  s1="zhangsan";

        System.out.println(s2.hashCode());
        System.out.println(s1.hashCode());

    }
}
