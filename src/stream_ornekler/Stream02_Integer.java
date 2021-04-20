package stream_ornekler;

import java.util.ArrayList;
import java.util.List;

public class Stream02_Integer {
    public static void main(String[] args) {

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
        System.out.println("\nTOPLAM:" + tekKupToplami(liste));
    }
    //**********************************************************************
    // ORN5:Bir listeyi parametre olarak alan ve listedeki her tek sayının karesini
    // aralarında bir boşluk bırakarak konsola yazdıran metodu yazınız.
    //**********************************************************************
    public static void tekKareYazdir (List<Integer> l) {
        l.stream().filter(Methodlar::tekMi).distinct().map(x->x*x).forEach(Methodlar::yazdir);
        // map() metodu collection üzerinde bir transformation işlemi sağlayan ara işlem metodudur.
        // Eğer bir collectionın verilerininin değişik hallerini hesaplama istersek map() kullanabiliriz.
    }

    //**************************************************************************************
    // ORNEK6: Bir listedeki tek sayıların küplerinin toplamını hesaplayarak
    // döndüren bir metot tanımlayınız.
    //**************************************************************************************
    public static Integer tekKupToplami(List<Integer> l ){
        // return l.stream().filter(Methodlar::tekMi).map(x->x*x*x).reduce(0,(x,y)->(x+y));
        // return l.stream().filter(Methodlar::tekMi).map(x->x*x*x).reduce(Math::addExact); // addExact > toplama islemi yapar
        return l.stream().filter(Methodlar::tekMi).map(x->x*x*x).reduce(0,Integer::sum);
        // reduce() bir terminal işlemidir. Stream hattını kapatır ve tek bir sonuç üretir.
        // Collection'ı indirgeme işlemini lambda fonksiyonu veya metot refransı ile yapabiliriz.
    }

}
