package com.janlei;


import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable {

    //1024byte=1k
    //1m=1024k
    byte[] b = new byte[1024*1024*2];

    public static void main(String[] args) throws InterruptedException{

        ArrayList<Client> list = new ArrayList<>();

        while(true){
            list.add(new Client());

            Thread .sleep(1000);
            new Thread(()-> {

                if(list.isEmpty()){
                    System.out.println("我是张三");

                }

            }).start();
        }
    }
}
