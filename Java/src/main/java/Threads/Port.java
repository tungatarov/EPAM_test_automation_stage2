package Threads;


public class Port {
    private final int portCapacity = 500;
    private int exportContainers = 200;
    private int importContainers = 0;

    public Port() {
    }

    public synchronized int getExportContainers(int amount) {
        if (exportContainers >= amount) {
            exportContainers -= amount;
            return amount;
        }
        amount = exportContainers;
        exportContainers = 0;
        return amount;
    }

    public synchronized void addImportContainers(int amount) {
        importContainers += amount;
    }
}
