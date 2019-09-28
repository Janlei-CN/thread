package com.janlei.pool;

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