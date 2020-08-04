package com.dataStuctureAndAlgorithm.LeetCode;

public class ReverseInteger {
    public int reverse(int x) {
        StringBuilder number = new StringBuilder(String.valueOf(x));
        int i;
        if (x >= 0) {
            try {
                return  Integer.parseInt(String.valueOf(number.reverse()));
            }catch (Exception e){
                return  0;
            }
        }else{
            try {
                return  Integer.parseInt("-" + number.deleteCharAt(0).reverse());
            } catch (Exception e) {
               return 0;
            }
        }

    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-2147483647));
    }
}
