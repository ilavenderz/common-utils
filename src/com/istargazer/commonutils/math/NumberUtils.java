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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(NumberUtils.splitNumber(19870)));
    }
}
