import java.util.Random;
import java.util.Scanner;
public class stopandwait {
    private static final Random random = new Random();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] frames = {1, 2, 3, 4, 5};
        for (int frame : frames) {
            boolean ackReceived = false;
            while (!ackReceived) {
                sendFrame(frame);
                ackReceived = receiveAcknowledgment();
                if (ackReceived) {
                    System.out.println("Acknowledgment received for frame: " + frame);
                } else {
                    System.out.println("No acknowledgment received for frame: " + frame + ". Resending...");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        scanner.close();
    }
    private static void sendFrame(int frame) {
        System.out.println("Sending frame: " + frame);
    }
    private static boolean receiveAcknowledgment() {
        return random.nextInt(10) < 9;
    }
}
