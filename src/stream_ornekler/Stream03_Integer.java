package stream_ornekler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream03_Integer {
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
    //*************************************************************************
    // ORNEK7: Bir listedeki en büyük sayıyı döndüren metotu tanımlayınız.
    //*************************************************************************
    public static int buyukBul(List<Integer> liste) {
        return liste.stream().reduce(0, (x, y) -> x > y ? x : y);

    }
    //*****************************************************************************************
    // ORNEK8: Bir listedeki en büyük sayıyı döndüren metotu tanımlayınız. (METOT REFERANSI)
    //*****************************************************************************************
    public static int buyukBul1(List<Integer> liste) {
        return liste.stream().reduce(0, Math::max);
    }

    //*****************************************************************************************
    // ORNEK9: Bir listedeki en büyük sayıyı SIRALAYARAK bulan ve döndüren metotu tanımlayınız.
    //*****************************************************************************************
    public static int buyukBul2(List<Integer> liste) {
        return liste.stream().sorted().reduce(0, (x, y) -> y);
        // stream'e cevirdikten sonra sorted ile siralama yaptigimizda en sonda ki en buyuk olacaktir
    }

    //*****************************************************************************************
    // ORNEK10: Bir listedeki en küçük sayıyı bulan ve döndüren metotu tanımlayınız.
    //*****************************************************************************************
    public static int kucukBul(List<Integer> liste) {
        return liste.stream().sorted().reduce(0, (x, y) -> x < y ? x : y);
    }

    //*****************************************************************************************
    // ORNEK11: Bir listedeki tüm elemanların  çarpımını bulan ve döndüren metotu tanımlayınız.
    //*****************************************************************************************
    public static int carpimBul(List<Integer> liste) {
        return liste.stream().sorted().reduce(1, (x, y) -> x * y);
        // carpma da 0 yerine 1 yazmak gerekir
    }

    //********************************************************************************************
    // ORNEK12: Bir listede belirtilen elemandan kaç adet bulunduğunu döndüren metotu tanımlayınız.
    //********************************************************************************************
    public static int dokuzSay(List<Integer> liste) {
        // return (int) liste.stream().count(); >> stream'de ki elemanlari sayar
        return (int) liste.stream().filter(x -> x == 9).count();
        // count long veri tipi kullanir o yuzden castin yaptik ve int'e cevirdik
    }

    //********************************************************************************************
    // ORNEK13: Bir listedeki negatif sayıları yazdıran metodu tanımlayınız.
    //********************************************************************************************
    public static void negatifSayilariYazdir (List<Integer> liste) {
        liste.stream().filter(x-> x<0).forEach(System.out::print);
    }

    //********************************************************************************************
    // ORNEK14: Bir listedeki negatif sayıları ayrı bir liste olarak döndüren metodu yazalım.
    //********************************************************************************************
    public static List<Integer> negatifList (List<Integer> liste){
       return liste.stream().filter(x-> x<0).collect(Collectors.toList());
    }

    //********************************************************************************************
    // ORNEK15: Listedeki tek elemanların karelerini sıralı olarak ve tekrarsız bir şekilde
    // listeye kaydeden metodu yazınız.
    //********************************************************************************************

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
    //********************************************************************************************
    // Listede ki tek elemanlarin karelerini ters sirali olarak ve tekrarsiz
    // bir sekilde listeye keydeden metodu yaziniz.(Kare almak için pow() metodu kullanılabilir.
    //********************************************************************************************
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
