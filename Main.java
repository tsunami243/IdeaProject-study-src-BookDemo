package BookDemo;

public class Main {
    public static void main(String[] args) {
        ThreadLocal<String> local = new InheritableThreadLocal<>();
        Thread t = new Thread(() -> {
            local.set("lbwnb");

            new Thread(() -> {
                System.out.println(local.get());
            }).start();
        });
        t.start();
    }
}