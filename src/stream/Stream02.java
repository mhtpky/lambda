package stream;

import java.util.ArrayList;
import java.util.List;

public class Stream02 {
    public static void main(String[] args) {
        //Bir listeyi parametre olarak alan ve listedeki her tek sayının karesini
        //aralarında bir boşluk bırakarak konsola yazdıran metodu yazınız.

        List<Integer> liste = new ArrayList<>();
        liste.add(12);
        liste.add(9);
        liste.add(13);
        liste.add(4);
        liste.add(9);
        liste.add(2);
        liste.add(4);
        liste.add(12);
        liste.add(15);
        tekKareYazdir(liste);
    }
    public static void tekKareYazdir (List<Integer> l) {
        l.stream().filter(Methodlar::tekMi).distinct().map(x->x*x).forEach(Methodlar::yazdir);

    }
}
