package com.photographers.service;

import java.util.ArrayList;

public class TestArrayListRemove {

    static void arrayListRemoval(){
        ArrayList<Integer> a1 = new ArrayList(5);
        int n = 5;
        System.out.println(n);

        for(int i=0;i<n;i++){
            a1.add((i+1)*10);
//            System.out.println(a1);
        }
        System.out.println(a1);
        int[] j={0,4};
        for(int i=0;i<j.length;i++){
            int index=j[i]-i;
            a1.remove(index);
        }
        System.out.println(a1);

    }

    public static void main(String [] args) {

        arrayListRemoval();
    }

}


