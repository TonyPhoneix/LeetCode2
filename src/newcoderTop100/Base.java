package newcoderTop100;

public class Base {

    int count;

    public void print(int n, String s) {
        for (int i = 0; i < n; i++) {
            System.out.print("    ");
        }
        System.out.print(s);
        System.out.println();
    }
}
