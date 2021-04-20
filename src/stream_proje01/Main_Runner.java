package stream_proje01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main_Runner {

    private static List<Ogrenci> ogrListesi = new ArrayList<>();

    public static void main(String[] args) {

        testOgrenciOlustur();
        ismeGoreListele("Ahmet");
        ismeGoreListele("Ayse");
        ismeGoreListele("John");
        soyismeGoreListele("Can");
        cinsiyeteGoreListele("Kadin");
        cinsiyeteGoreListele("Erkek");
        yasaVeCinsiyeteGoreSirala(20, "erkek");
        yasaVeCinsiyeteGoreSirala(30, "kadın");
//        System.out.println("SINIF ORTALAMASI:" + sinifOrtalamsiHesapla1());
//        System.out.println("SINIF ORTALAMASI:" + sinifOrtalamsiHesapla2());
//        sinifOrtalamsiHesapla3();
//        ismeGoreOgrenciSil("Ahmet");
    }

    private static void testOgrenciOlustur() {
        /*Ogrenci ogr1 = new Ogrenci("Ahmet", " Can", 30, 88.4, "erkek");
        ogrListesi.add(ogr1);
        */
        ogrListesi.add(new Ogrenci("Ahmet", "Can", 30, 88.4, "erkek")); // iki turlu de yazilabilir
        ogrListesi.add(new Ogrenci("Ahmet", "Baki", 18, 90.1, "erkek"));
        ogrListesi.add(new Ogrenci("Ayse", "Can", 21, 82.3, "kadın"));
        ogrListesi.add(new Ogrenci("Mustafa", "Can", 15, 75.4, "erkek"));
        ogrListesi.add(new Ogrenci("Ayse", "Yılmaz", 40, 45, "kadın"));
        ogrListesi.add(new Ogrenci("Ali", "Veli", 80, 35.5, "erkek"));
        ogrListesi.add(new Ogrenci("Veli", "Öztürk", 20, 95.5, "erkek"));
    }

    //listeyi yazdırırken içinde veri var mı diye kontrol eden metot.
    public static void listeYazdir(List<Ogrenci> liste){
        if ((liste.isEmpty())) {
            System.out.print("Aranılan Öğrenci Bulunamadı");
        } else {
            liste.forEach(System.out::println);
        }
    }

    private static void ismeGoreListele(String isim) {
        System.out.println("\n============ "+ isim.toUpperCase() + " ADINDAKİ ÖĞRENCİLER ============");
        List<Ogrenci> liste = ogrListesi.stream().filter(t->t.getAd().equalsIgnoreCase(isim)).collect(Collectors.toList());
        listeYazdir(liste);
    }

    private static void soyismeGoreListele(String soyisim){
        System.out.println("\n\n============ "+ soyisim.toUpperCase() + " SOYADINDAKİ ÖĞRENCİLER ============");
        List<Ogrenci> liste =ogrListesi.stream().filter(t->t.getSoyad().equalsIgnoreCase(soyisim)).collect(Collectors.toList());
        listeYazdir(liste);
    }

    private static void cinsiyeteGoreListele (String cinsiyet) {
        System.out.println("\n\n============ "+ cinsiyet.toUpperCase() + " ÖĞRENCİLER ============");
        List<Ogrenci> liste = ogrListesi.stream().filter(t->t.getCinsiyet().equalsIgnoreCase(cinsiyet)).collect(Collectors.toList());
        listeYazdir(liste);
    }
    private static void yasaVeCinsiyeteGoreSirala(int yas,String cinsiyet){
        System.out.println("\n============ YAŞ CİNSİYETE GÖRE SIRALA-LİSTELE ============");
        List<Ogrenci> liste = ogrListesi.stream().
                filter(t->t.getYas() < yas).
                filter(t->t.getCinsiyet().equalsIgnoreCase(cinsiyet)).
                sorted(Comparator.comparing(Ogrenci::getYas)).
                collect(Collectors.toList());
        listeYazdir(liste);
    }

    private static void sinifOrtalamsiHesapla1 (double diplomaNotu){

    }


}
