package ru.ifmo.collections;

import java.util.*;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private HashMap<Integer, Integer> integers = new HashMap<>();
    private ArrayList<Integer> unique = new ArrayList<>();

    public FirstUnique(int[] nums) {
        for (int i : nums) {
            if (integers.get(i) == null)
                integers.put(i, 0);
            else
                integers.put(i, -1);
        }
        for (int i : nums){
            if (integers.get(i) == 0)
                unique.add(i);
        }
    }
    //
    public int showFirstUnique() {
        if(unique == null || unique.size() == 0)
            return -1;
        else
            return unique.get(0);
    }

    public void add(int value) {
        if (integers.get(value) == null) {
            integers.put(value, 0);
            unique.add(value);
        }
        else {
            integers.put(value, -1);
            Iterator<Integer> iterator = unique.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals(value)){
                    iterator.remove();
                }
            }
        }
    }
}