package com.istargazer.commonutils.code;

import com.istargazer.commonutils.code.analysis.Method;

public class CodeAnalysis {

    public static void showExecuteTime(Method m) {
        long start = System.nanoTime();
        try {
            m.doIt();
        } catch (Exception e) {

        }
        long end = System.nanoTime();
        long escape = end - start;
        System.out.printf("Execute time is : %d nanoSecs. %d millSecs. %d secs.\n", escape, escape / 1000000, escape / 1000000 / 1000);
    }
}
