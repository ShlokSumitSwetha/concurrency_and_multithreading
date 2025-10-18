public class Main {
    public static void main(String[] args) {

        Thread.startVirtualThread(()->System.out.println(Thread.currentThread().getId()));

        for(int i= 0; i<100; i++) {
            Thread.ofVirtual().name("virutal-thread", 0).start(() -> System.out.println(Thread.currentThread().getName()));
        }
        }
}