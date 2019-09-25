package com.janlei.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public Map init(){
        Map<String,Integer> map = Collections.synchronizedMap(new HashMap<String,Integer>());
        return map;
    }

    public Map put(Map<String,Integer> map, String key, Integer value){
        map.put(key, value);
        return map;
    }
    
    public void print(Map<String,Integer> map){
        for (Map.Entry<String,Integer> entry:
                map.entrySet()
             ) {
            System.out.println("key:"+entry.getKey()+"   value:"+entry.getValue());
        }
    }

    //TODO test Thread
    public void tread(Map<String,Integer> map){


    }

}
