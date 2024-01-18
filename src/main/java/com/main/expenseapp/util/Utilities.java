package com.main.expenseapp.util;

import java.util.List;

public class Utilities <T>{
    public static <T> void printer(List<T> list){
        for(T elem : list){
            System.out.println(elem);
        }
    }
}
