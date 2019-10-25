package com.janlei.stack;


import org.junit.Test;

import java.util.Stack;

/**
 * stack 栈
 */
public class StackTest {

    private Stack<Integer> stack = new Stack<>();
    
    @Test
    public void run(){

        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }

}
