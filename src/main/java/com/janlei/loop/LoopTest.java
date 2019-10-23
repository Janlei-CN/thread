package com.janlei.loop;

public class LoopTest {

    /**
     * 跳出双层循环
     */
    public void outLoop(){
        OutLoop:for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++) {
                if (i+j==100){
                    break OutLoop;
                }
                System.out.println(i+":"+j);
            }
        }
    }
}
