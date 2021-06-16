package com.istargazer.commonutils.code.analysis;

import java.util.concurrent.ExecutionException;

@FunctionalInterface
public interface Method {
    /**
     * execute some code
     * @throws ExecutionException
     * @throws InterruptedException
     */
    void doIt() throws ExecutionException, InterruptedException;
}
