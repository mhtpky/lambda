package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Stream05_String {

    public static void main(String[] args) {
        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Jackson");
        liste.add("Amanda");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Christ");
        basHarfA(liste);
        System.out.println();
        buyukHarfeCevir(liste);
    }

    // Bas harfi "A" ile baslayan isimleri yazdiran bir method yaziniz
    public static void basHarfA (List<String> liste) {
        liste.stream().filter(h->h.startsWith("A")).forEach(System.out::println);
        // Yazdirmak istedigimizde forEach kullaniyoruz
    }
    // Liste elemanlarini buyuk harfe cevirelim
    public static void buyukHarfeCevir (List<String> liste) {
        liste.stream().map(h->h.toUpperCase()).forEach(System.out::println);
        // Yazdirmak istedigimizde forEach kullaniyoruz
        // mutabeldir orjinal listeyi degistirmez kopyalari uzerinde calisir.

    }

}
