package com.dataStuctureAndAlgorithm.LeetCode.Stack;

import java.util.ArrayList;
import java.util.List;

/*
*   思路：遇到缺失的数字插入push pop对，否则插入pop
* */
public class StackToArray {
    private List<String> list;
    public List<String> buildArray(int[] target, int n) {
        list = new ArrayList<>();
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if(j == target.length){
                break;
            }else if(target[j] == i){
                list.add("push");
                j++;
            }else {
                list.add("push");
                list.add("pop");
            }
        }
        return list;
    }

    public static void main(String[] args) {
        StackToArray stackToArray = new StackToArray();
        System.out.println(stackToArray.buildArray(new int[]{1, 3}, 4));
    }
}
