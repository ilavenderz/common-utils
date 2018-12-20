package com.istargazer.commonutils.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberUtils {

    public static Byte[] splitNumber(long number){
        List<Byte> list  = new ArrayList<Byte>();
        while(number > 0){
            list.add((byte)(number % 10));
            number /= 10;
        }
        Byte[] arr = new Byte[list.size()];
        return list.toArray(arr);
    }

    public static Byte[] splitNumber(long number, int size){
        Byte[] result = new Byte[size];
        Byte[] arr = splitNumber(number);
        for(int i = 0; i < arr.length; i++){
            result[i] = arr[i];
        }
        for(int i = arr.length; i < size; i++){
            result[i] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(NumberUtils.splitNumber(19870)));
    }
}
