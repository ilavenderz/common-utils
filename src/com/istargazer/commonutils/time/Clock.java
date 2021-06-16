package com.istargazer.commonutils.time;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Clock implements AutoCloseable, Runnable{
    private final BlockingQueue<Byte> bq = new LinkedBlockingQueue<>();
    private final long timeOut;
    private final TimeUnit timeUnit;
    private boolean run = true;
    private final Tick tick;

    public Clock(long timeOut, TimeUnit timeUnit, Tick tick) {
        this.timeOut = timeOut;
        this.timeUnit = timeUnit;
        this.tick = tick;
        tick();
    }

    private void tick() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        Clock clock = this;
        while (clock.run) {
            try {
                bq.poll(timeOut, timeUnit);
                clock.tick.tick();
            } catch (InterruptedException ignored) {

            }
        }
    }

    @Override
    public void close() throws Exception {
        this.run = false;
    }
}
