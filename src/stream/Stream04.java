package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream04 {
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
        liste.add(-1);
        liste.add(15);
        liste.add(500);
        liste.add(-15);

        System.out.println("EN BUYUK DEGER: " + buyukBul(liste));
        System.out.println("EN BUYUK DEGER: " + buyukBul1(liste));
        System.out.println("EN BUYUK DEGER: " + buyukBul2(liste));
        System.out.println("EN KUCUK DEGER: " + kucukBul(liste));
        System.out.println("CARPIM DEGERI: " + carpimBul(liste));
        System.out.println("DOKUZ SAYISI : " + dokuzSay(liste));
        negatifSayilariYazdir(liste);
        List<Integer> negatifler = negatifList(liste); // burayi yaparsak kalici hale getrms oluruz
        System.out.println("\nNEGATIF LISTE : " + negatifList(liste));
        System.out.println("TEK SAYILARIN SIRALI KARESI LISTE : " + tekKareSiraliListe(liste));
        System.out.println("TEK SAYILARIN TERS SIRALI KARESI LISTE : " + tekKareTersSiraliListe(liste));

    }

    public static int buyukBul(List<Integer> liste) {
        return liste.stream().reduce(0, (x, y) -> x > y ? x : y);

    }

    public static int buyukBul1(List<Integer> liste) {
        return liste.stream().reduce(0, Math::max);
    }

    public static int buyukBul2(List<Integer> liste) {
        return liste.stream().sorted().reduce(0, (x, y) -> y);
        // stream'e cevirdikten sonra sorted ile siralama yaptigimizda en sonda ki en buyuk olacaktir
    }

    public static int kucukBul(List<Integer> liste) {
        return liste.stream().sorted().reduce(0, (x, y) -> x < y ? x : y);
    }

    public static int carpimBul(List<Integer> liste) {
        return liste.stream().sorted().reduce(1, (x, y) -> x * y);
        // carpma da 0 yerine 1 yazmak gerekir
    }

    // Liste icinde kac tane 9 sayisi bulunmaktadir
    // Bunu bulan bir method yazalim
    public static int dokuzSay(List<Integer> liste) {
        // return (int) liste.stream().count(); >> stream'de ki elemanlari sayar
        return (int) liste.stream().filter(x -> x == 9).count();
    }
    // Listede ki negatif sayilari yazdiran methodu yazalim
    public static void negatifSayilariYazdir (List<Integer> liste) {
        liste.stream().filter(x-> x<0).forEach(System.out::print);
    }

    // Listede ki negatif sayilari ayri bir liste olarak donduren
    // methodu yazalim
    public static List<Integer> negatifList (List<Integer> liste){
       return liste.stream().filter(x-> x<0).collect(Collectors.toList());
    }
    // Listede ki tek elemanlarin karelerini sirali olarak ve tekrarsiz
    // bir sekilde listeye keydeden metodu yaziniz
    public static List<Integer> tekKareSiraliListe (List<Integer> liste ){
        return liste.
                stream().
                distinct().// tekrarli elemanlari eler
                filter(Methodlar::tekMi).
                map(x->x*x). // guncelleme yapar
                distinct(). // kareleri ayni olani eler
                sorted(). // siralar
                collect(Collectors.toList());
    }

    // Listede ki tek elemanlarin karelerini ters sirali olarak ve tekrarsiz
    // bir sekilde listeye keydeden metodu yaziniz
    public static List<Integer> tekKareTersSiraliListe (List<Integer> liste ){
        return liste.
                stream().
                distinct().// tekrarli elemanlari eler
                filter(Methodlar::tekMi).
                map(x-> (int) Math.pow(x,2)). // guncelleme yapar. x uzeri 2 /  map(Math::pow)> ust alma / pow double kabul eder o sebepten casting yaptik
                distinct(). // kareleri ayni olani eler
                sorted(Comparator.reverseOrder()). // ters siralar
                collect(Collectors.toList());
    }
}
