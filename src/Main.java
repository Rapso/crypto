import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Kryptogram> kryptogramy;

    public static char klucze[] = new char[202];


    public static void main(String[] args) {
        kryptogramy = new ArrayList<Kryptogram>();
        for (int i = 1; i <= 20; i++) {
            try {
                kryptogramy.add(new Kryptogram(i + ".txt"));
            } catch (Exception e) {

            }
        }
        System.out.println(kryptogramy.get(3).length());

        new test();
        try {
            test.start_test(kryptogramy);
        } catch (Exception e) {
        };
        zapisz();
    }

    private static void zapisz() {
        try {
            PrintWriter zapis = new PrintWriter("wynik.txt");
            for (int i = 0; i < kryptogramy.size(); i++) {
                // zapis.println("hej");
                zapis.print("kryptogram " + (i + 1) + ": ");
                zapis.printf("%s\n\n", kryptogramy.get(i));
            }
            zapis.close();
        } catch (Exception e) {
        }
    }
}