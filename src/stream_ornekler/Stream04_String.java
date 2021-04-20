package stream_ornekler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stream04_String {

    public static void main(String[] args) {
        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Alehandro");
        liste.add("Jackson");
        liste.add("Amanda");
        liste.add("Alfonso");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Christ");

        System.out.println("A ILE BASLAYAN ISIMLER");
        basHarfA(liste);

        System.out.println("\nTUM ISIMLER BUYUK HARF");
        buyukHarfeCevir(liste);

        System.out.println("\nUZUNLUGA GORE SIRALAMA");
        uzunlugaGoreSiralaKucult(liste);

        System.out.println("\nBELIRTILEN UZUNLUKTAN BUYUK OLANLAR");
        uzunlugaGoreYazdir(liste, 5); // uzunlugu 3 den buyuk olanlari sirala

        System.out.println("\nTUM ELEMANLAR BELIRTILEN DEGERDEN KUCUK " + uzunlukKucukMu(liste, 7));
        System.out.println("\nBELIRTILEN HARF ILE BASLAMAYAN " + belirtilenHarfIleBaslamayan(liste, "b"));
        System.out.println("\nBELIRTILEN HARF ILE BITEN VAR MI" + bitenElemanVarMi(liste, "r"));

        System.out.println("========");
        aIleOYazdir(liste);
        System.out.println("========");
        formataGoreYazdir(liste);
        System.out.println("\n========");
        yazdir(liste);
        System.out.println("========");
    }

    //******************************************************************
    // ORN16 :Bas harfi "A" ile baslayan isimleri yazdiran bir method yaziniz
    //******************************************************************
    public static void basHarfA(List<String> liste) {
        liste.stream().filter(h -> h.startsWith("A")).forEach(System.out::println);
        // Yazdirmak istedigimizde forEach kullaniyoruz
    }

    //******************************************************************
    // ORN17: Liste elemanlarini buyuk harfe cevirelim
    //******************************************************************
    public static void buyukHarfeCevir(List<String> liste) {
        liste.stream().map(h -> h.toUpperCase()).forEach(System.out::println);
        // Yazdirmak istedigimizde forEach kullaniyoruz
        // mutabel'dir orjinal listeyi degistirmez kopyalari uzerinde calisir.
    }

    //******************************************************************
    // ORN18: Listede ki tum elemanlari uzunluklarina gore siralayan > (sorted)
    // Kucuk harfe ceviren > (map)  metodu siralayinz
    //******************************************************************
    public static void uzunlugaGoreSiralaKucult(List<String> liste) {
        liste.stream().
                sorted(Comparator.comparing(t -> t.length())).
                map(t -> t.toLowerCase()).
                forEach(System.out::println);
        // sorted() bu sekilde naturel order'a gore siralama yapar > alfabetik/ kucukten buyuge
        // Comparator.compering yaparsak istedigimz siralamayi secebiliriz
    }

    //******************************************************************
    //ORN19:Listedeki tüm elemanların uzunlukları belirtilen uzunluktan fazla ise bunları
    //yazdıran metodu tanımlayalım..
    //******************************************************************
    public static void uzunlugaGoreYazdir(List<String> liste, int uzunluk) {
        liste.stream().filter(t -> t.length() > uzunluk).forEach(System.out::println);
    }

    //******************************************************************
    // ORN20: Listede ki TUM elemanlarin uzunluklari belirtilen uzunluktan
    // KUCUK mu diye kontrol eden methodu yaziniz
    //******************************************************************
    public static boolean uzunlukKucukMu(List<String> liste, int uzunluk) {
        return liste.stream().allMatch((t -> t.length() < uzunluk));
        // allMatch() > icinde ki lambda ifadesine gore tum diziyi dolasir.hepsinde var mi
        // stringler belirttigim uzunluktan kucuk ise true, degil ise false dondurur
    }

    //******************************************************************
    // ORN21: Listede ki TUM elemanlarin belirtilen harf ile baslayp
    // baslamadigini kontrol eden methodu yaziniz.
    //******************************************************************
    public static boolean belirtilenHarfIleBaslamayan(List<String> liste, String harf) {
        return liste.stream().noneMatch(t -> t.startsWith(harf));
        // noneMatch() > tum diziyi dolasir. HEPSINDE YOK MU diye bakar
        // belirtilen harf yok ise true, var ise false doner
    }

    //******************************************************************
    // ORN22: Listede herhangi bir eleman belirtilen bir harf diye
    // bitiyor mu diye kontrol eden methodu yaziniz
    //******************************************************************
    public static boolean bitenElemanVarMi(List<String> liste, String harf) {
        return liste.stream().anyMatch(t -> t.endsWith(harf));
        // anyMatch() >Belirtilen şartları sağlayan tek bir
        // eleman bile varsa true aksi takdirde false döndürür.
    }

    //******************************************************************
    // ORN23: A ile basayip O ile biten elemanlari yazdiran methodu tanimlayiniz
    //******************************************************************
    public static void aIleOYazdir(List<String> liste) {
        liste.stream().
                filter(x -> x.startsWith("A") && x.endsWith("o")).
                forEach(System.out::println);
        // anymatch true ya da false dondurur o sebepten
    }

    //******************************************************************
    // ORN24: Asagida ki formata gore listede ki herbir elemanin
    // uzunlugunu yazdiran metodu yaziniz
    // Ali :3       Mark:4     Amanda:6    vb
    //******************************************************************
    public static void formataGoreYazdir(List<String> liste) {

        liste.stream().
                sorted(Comparator.comparing(x -> x.length())).
                // sorted(Comparator.comparing(String::length) > seklinde de yazabiliriz
                map(t -> t + " : " + t.length() + "      ").
                forEach(System.out::print);
    }

    //****************************************************************************************************
    //  ÖRN25: Küçük Büyük harf ayırmaksızın A harfi ile başlayan
    //  isimleri yazdıran metodu tanımlayınız.
    //****************************************************************************************************
    public static void yazdir(List<String> liste) {

        liste.stream().
                map(String::toLowerCase).
                filter(t -> t.startsWith("a")).
                forEach(System.out::println);
    }
}