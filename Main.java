package BookDemo;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread bbb = Thread.ofVirtual()
                .name("bbb")
                .unstarted(() -> {
                    System.out.println("我是虚拟线程" + Thread.currentThread().getName());
                });
        bbb.start();
        bbb.join();


    }
}