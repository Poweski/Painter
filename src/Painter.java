import java.util.Scanner;

public class Painter {
    public static void main(String[] args) {
        System.out.println();
        int numberOfCharacters = makeARequest("Enter the number of characters: ");
        System.out.println();
        drawHourglass(numberOfCharacters);
        System.out.println();
        drawBridge(numberOfCharacters);
    }
    public static int makeARequest(String order) {
        boolean flag = true;
        int result = 0;
        while (flag) {
            System.out.print(order);
            result = tryCollectData();
            if (result > 0) {
                flag = false;
            }
        }
        return result;
    }
    public static int tryCollectData() {
        try {
            int result = Integer.parseInt(collectData());
            if (result <= 0) {
                throw new IllegalArgumentException();
            }
            return result;
        }
        catch (NumberFormatException e) {
            System.out.println("Incorrect data provided!");
            return 0;
        }
        catch (IllegalArgumentException e) {
            System.out.println("A non-positive value was entered!");
            return 0;
        }
    }
    public static String collectData() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static void drawHourglass(int n) {
        for (int i = n; i >= 1; i--) {
            drawHourglassLine(n, i);
        }
        for (int i = 2; i <= n; i++) {
            drawHourglassLine(n, i);
        }
    }
    public static void drawHourglassLine(int n, int i) {
        drawMultipleSpacing(n,i);
        drawLine(n,i);
        System.out.println();
    }
    public static void drawMultipleSpacing(int n, int i) {
        for (int j = 1; j <= n-i; j++) {
            drawSpace();
        }
    }
    public static void drawLine(int n, int i) {
        if (i == n) {
            drawSimpleLine(n);
        }
        else {
            drawComplexLine(i);
        }
    }
    public static void drawSimpleLine(int n) {
        for (int i = 0; i < 2*n-1; i++) {
            drawX();
        }
    }
    public static void drawComplexLine(int n) {
        if (n == 1) {
            drawX();
        }
        else if (n == 2) {
            drawX();
            drawSpace();
            drawX();
        }
        else {
            drawX();
            drawSpace();
            for (int i = 0; i < 2*n-5; i++) {
                drawO();
            }
            drawSpace();
            drawX();
        }
    }

    public static void drawBridge(int n) {
        if (n == 1) {
            drawDeck(2 * n - 1);
        }
        else if (n == 2) {
            drawDeck(2 * n - 1);
            drawBase(n);
        }
        else {
            drawPeak(n);
            drawDeck(2 * n - 1);
            drawBase(n);
        }
    }
    public static void drawDeck(int n) {
        for (int i = 0; i < n; i++) {
            drawX();
        }
        System.out.println();
    }
    public static void drawBase(int n) {
        drawI();
        for (int i = 0; i < 2*n-3; i++) {
            drawSpace();
        }
        drawI();
        System.out.println();
    }
    public static void drawPeak(int n) {
        drawBase(n);
        for (int i = 0; i < n-3; i++) {
            drawBridgeLine(n, i);
        }
    }
    public static void drawBridgeLine(int n, int j) {
        drawI();
        for (int i = 0; i < j; i++) {
            drawSpace();
        }
        drawLine1();
        for (int i = 0; i < 2*(n-j)-5; i++) {
            drawSpace();
        }
        drawLine2();
        for (int i = 0; i < j; i++) {
            drawSpace();
        }
        drawI();
        System.out.println();
    }
    public static void drawX() {
        System.out.print("X");
    }
    public static void drawI() {
        System.out.print("I");
    }
    public static void drawO() {
        System.out.print("O");
    }
    public static void drawLine1() {
        System.out.print("\\");
    }
    public static void drawLine2() {
        System.out.print("/");
    }
    public static void drawSpace() {
        System.out.print(" ");
    }
}
