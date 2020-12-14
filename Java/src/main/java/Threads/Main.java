package Threads;

import Threads.enums.ShipCapacity;

import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime
                .getRuntime().availableProcessors());
        Port port = new Port();
        BlockingQueue<Ship> queue = new ArrayBlockingQueue<>(5);

        executor.submit(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    queue.put(new Ship(ShipCapacity.getRandomCapacity()));
                }
            } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
            }
        });

        for (int i = 0; i < 3; i++) {
            executor.submit(new Berth(port, queue));
        }

        executor.shutdown();
    }
}
