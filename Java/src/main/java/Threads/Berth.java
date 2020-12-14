package Threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Berth implements Runnable {
    private static final AtomicInteger counter = new AtomicInteger();
    private final int id;
    private final int berthCapacity = 20;
    private int exportContainers = 0;
    private int importContainers = 0;
    private final Port port;
    private final BlockingQueue<Ship> shipQueue;
    private Ship ship;

    public Berth(Port port, BlockingQueue<Ship> shipQueue) {
        id = counter.incrementAndGet();
        this.port = port;
        this.shipQueue = shipQueue;
    }

    private void loadContainersToShip() {
        if (exportContainers > 0) {
            int shipId = ship.getId();
            int counter = 1;
            while (ship.checkCapacity() && exportContainers > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                exportContainers--;
                System.out.printf("%d containers loaded to Ship No. %d.\n", counter++, shipId);
                ship.setImportContainers(counter);
            }
            System.out.printf("Ship No. %d has been loaded.\n", shipId);

        } else {
            System.out.printf("There are no containers for export on Berth No. %d. \n", id);
        }
    }

    private void unloadContainersFromShip() {
        int amount = ship.getExportContainers();
        int shipId = ship.getId();
        if (amount > 0) {
            for (int i = 1; i <= amount; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("%d container unloaded from Ship No. %d.\n", i, shipId);
            }
            importContainers = amount;
            System.out.printf("Ship No. %d is fully unloaded.\n", shipId);
            ship.setExportContainers(0);

        } else {
            System.out.printf("There are no containers for export on the Ship No. %d.\n", shipId);
        }
    }

    @Override
    public void run() {
        while (true) {
            if (exportContainers < berthCapacity) {
                int containers = port.getExportContainers(berthCapacity - exportContainers);
                if (containers > 0) {
                    exportContainers = containers;
                    System.out.printf("%d Export containers were removed from the " +
                            "main warehouse of the Port to Berth No. %d. \n", containers, id);
                } else {
                    System.out.printf("Berth No. %d: There are no containers for export " +
                            "on the main warehouse of the Port.\n", id);
                }
            }
            if (shipQueue.isEmpty()) return;
            try {
                ship = shipQueue.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.printf("Ship No. %d arrived at Berth No. %d.\n", ship.getId(), id);
            unloadContainersFromShip();
            loadContainersToShip();
            System.out.printf("Ship No. %d departed from Berth No. %d.\n", ship.getId(), id);
            if (importContainers > 0) {
                port.addImportContainers(importContainers);
                System.out.printf("%d Import containers were removed from " +
                        "Berth No. %d to main warehouse of the Port. \n", importContainers, id);
                importContainers = 0;
            }
        }
    }
}
