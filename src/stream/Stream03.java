package stream;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;

public class Stream03 {
    public static void main(String[] args) {
        //Bir listeyi parametre olarak alan ve listedeki tek sayıların kuplerinin
        //toplamını hesaplayan metodu yazınız.
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
        System.out.println("TOPLAM: "+ tekKupToplami(liste));

    }
    public static Integer tekKupToplami(List<Integer> l ){
     // return l.stream().filter(Methodlar::tekMi).map(x->x*x*x).reduce(0,(x,y)->(x+y));
     // return l.stream().filter(Methodlar::tekMi).map(x->x*x*x).reduce(Math::addExact);
        return l.stream().filter(Methodlar::tekMi).map(x->x*x*x).reduce(0,Integer::sum);


    }
}
