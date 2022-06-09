package com.photographers.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LRUcache {

    private final int CACHE_SIZE;

    HashSet<Integer> hashSet;

    LinkedList<Integer> linkedList;

    public static void main(String[] args){

        LRUcache lrUcache = new LRUcache(5);

        lrUcache.storeCache(4);

    }

    public LRUcache(int capacity){

        CACHE_SIZE = capacity;

        hashSet = new HashSet<>();

        linkedList = new LinkedList<>();
    }

    public void storeCache(int i){

        if(!linkedList.contains(i)){
            if(hashSet.size()> CACHE_SIZE){
                int last = linkedList.removeLast();
                System.out.println("last" +last);
                hashSet.remove(last);
                System.out.println("Cache o/p" +hashSet);

            }
        }
    }

}
