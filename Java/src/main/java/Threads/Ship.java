package Threads;

import Threads.enums.ShipCapacity;

import java.util.concurrent.atomic.AtomicInteger;


public class Ship {
    private final static AtomicInteger counter = new AtomicInteger();
    private final int id;
    private final ShipCapacity capacity;
    private int exportContainers;
    private int importContainers;

    public Ship(ShipCapacity capacity) {
        id = counter.incrementAndGet();
        this.capacity = capacity;
        this.exportContainers = getRandomValue(7, getCapacity());
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity.getCapacity();
    }

    public boolean checkCapacity() {
        return capacity.getCapacity() >= exportContainers + importContainers;
    }

    public int getExportContainers() {
        return exportContainers;
    }

    public void setExportContainers(int exportContainers) {
        this.exportContainers = exportContainers;
    }

    public int getImportContainers() {
        return importContainers;
    }

    public void setImportContainers(int importContainers) {
        this.importContainers = importContainers;
    }

    private int getRandomValue(int from, int to) {
        return from + (int) (Math.random() * (to - from + 1));
    }
}
