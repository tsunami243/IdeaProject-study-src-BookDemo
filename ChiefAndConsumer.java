package BookDemo;


import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ChiefAndConsumer {
    private static Queue<Object> queue = new ConcurrentLinkedQueue<>();
    public static void main(String[] args) {
        new Thread(ChiefAndConsumer::add , "厨师1").start();
        new Thread(ChiefAndConsumer ::add , "厨师2").start();

        new Thread(ChiefAndConsumer::take , "客人1").start();
        new Thread(ChiefAndConsumer::take , "客人2").start();
        new Thread(ChiefAndConsumer::take , "客人3").start();

    }

    private static void add(){
        try {
            while (true){
                Thread.sleep(3000);
                synchronized (queue){
                    String name = Thread.currentThread().getName();
                    queue.offer(new Object());
                    System.out.println(new Date() + " " + name + "出餐了");
                    queue.notifyAll();
                }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void take(){
        try {
            synchronized (queue){
                while(queue.isEmpty()){
                    queue.wait();
                }
                String name = Thread.currentThread().getName();
                queue.poll();
                System.out.println(new Date() + " " +name + "正在享用");
            }
            Thread.sleep(4000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
