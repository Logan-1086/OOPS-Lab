// Thread class for handling Integer Max value
class IntegerThread extends Thread {
    private int maxValue;

    public IntegerThread(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        System.out.println("Integer Max: " + maxValue);
    }
}

// Thread class for handling Double Max value
class DoubleThread extends Thread {
    private double maxValue;

    public DoubleThread(double maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        System.out.println("Double Max: " + maxValue);
    }
}

// Thread class for handling String Max value
class StringThread extends Thread {
    private String maxValue;

    public StringThread(String maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        System.out.println("String Max: " + maxValue);
    }
}

// Main class to control thread execution
public class MaxValueThreads {
    public static void main(String[] args) {
        // Create and start threads for different data types
        IntegerThread integerThread = new IntegerThread(456);
        DoubleThread doubleThread = new DoubleThread(18.6001);
        StringThread stringThread = new StringThread("Strawberry");

        // Start the threads
        integerThread.start();
        doubleThread.start();
        stringThread.start();

        // Adding a thread for boolean max value
        Thread booleanThread = new Thread(() -> {
            System.out.println("Boolean Max: " + true);
        });
        booleanThread.start();

        // Adding a thread for byte max value
        Thread byteThread = new Thread(() -> {
            System.out.println("Byte Max: " + Byte.MAX_VALUE);
        });
        byteThread.start();
    }
}