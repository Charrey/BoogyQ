package toplevel;

import java.io.IOException;

/**
 * Created by poesd_000 on 20/06/2016.
 */
public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Hello world!");
            new ProcessBuilder("cmd", "/c", "pause > null").inheritIO().start().waitFor();
        } catch (IOException e) {
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
