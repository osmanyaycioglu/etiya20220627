package com.training.mockito;

import java.util.ArrayList;
import java.util.List;

public class NameHolder {

    private int index = 0;

    private List<String> nameList = new ArrayList<>();

    public void printList(){
        System.out.println(nameList);
    }

    public String getName(){
        String s = nameList.get(index);
        index++;
        return s;
    }

    public void reset(){
        index = 0;
    }

    public int size(){
        return nameList.size();
    }

    public void add(String name){
        nameList.add(name);
    }
}
