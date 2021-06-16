package com.istargazer.commonutils.thread;

public class ThreadUtils {

    /**
     * sleep 1 second
     */
    public static void delay(){delay(1000L);}

    /**
     * sleep @delay milliseconds
     * @param delay milliseconds
     */
    public static void delay(long delay) {
        try{
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
