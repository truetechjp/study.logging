package jp.truetech.experient.logging;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void lambda() throws Exception {
        log.debug("thread name: {}", Thread.currentThread().getName());
        new Thread(() -> {
            log.debug("start: '{}'", Thread.currentThread().getName());
        }, "TESTTHREAD (lambda)").start();
    }

    @Test
    public void lambda2() throws Exception {
        log.debug("thread name: {}", Thread.currentThread().getName());
        Runnable runner = () -> log.debug("start: '{}'", Thread.currentThread().getName());
        new Thread(runner, "TESTTHREAD (lambda2)").start();
    }

    @Test
    public void anonymous() throws Exception {
        log.debug("thread name: {}", Thread.currentThread().getName());
        new Thread(new Runnable() {
            public void run() {
                log.debug("start: '{}'", Thread.currentThread().getName());
            }
        }, "TESTTHREAD (anonymous)").start();
    }

    @Test
    public void implementClass() throws Exception {
        log.debug("thread name: {}", Thread.currentThread().getName());
        class Runner implements Runnable {
            public void run() {
                log.debug("start: '{}'", Thread.currentThread().getName());
            }
        }
        Runner runner = new Runner();
        new Thread(runner, "TESTTHREAD (implement)").start();
    }

    @Test
    public void implementClass2() throws Exception {
        log.debug("thread name: {}", Thread.currentThread().getName());
        class Runner implements Runnable {
            public void run() {
                log.debug("start: '{}'", Thread.currentThread().getName());
            }
        }
        Runner runner = new Runner();
        Thread thread = new Thread(runner, "TESTTHREAD (implement2)");
        thread.start();
    }
}
