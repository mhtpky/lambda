package stream_proje01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Main_Runner {

    private static List<Ogrenci> ogrListesi = new ArrayList<>();

    public static void main(String[] args) {

        testOgrenciOlustur();
        notaGoreSirala(3,6);
        yasaGoreSirala();
        ismeGoreListele("Ahmet");
        ismeGoreListele("Ayse");
        ismeGoreListele("John");
        soyismeGoreListele("Can");
        cinsiyeteGoreListele("Kadin");
        cinsiyeteGoreListele("Erkek");
        yasaVeCinsiyeteGoreSirala(20, "erkek");
        yasaVeCinsiyeteGoreSirala(30, "kadın");
        System.out.println("SINIF ORTALAMASI:" + sinifOrtalamsiHesapla1());
        System.out.println("SINIF ORTALAMASI:" + sinifOrtalamsiHesapla2());
        sinifOrtalamsiHesapla3();
        ismeGoreOgrenciSil("Ahmet");
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

    //Öğrenci notlarını alt ve üst limitlere göre sıralayarak  yazdıran metot (Önr: 3-5. sıradakileri göster.)
    private static void notaGoreSirala(int alt,int ust) {
        System.out.println("\n============ NOTA GÖRE SIRALAMA ============");
        System.out.println("~~~~~" + alt + "-" + ust + ". SIRADAKİLER ~~~");
        ogrListesi.stream().
                sorted(Comparator.comparing(Ogrenci::getDiplomaNotu).reversed()).
                skip(alt - 1).
                limit(ust - alt + 1).
                forEach(System.out::println);
    }

    //Öğrencileri yaşlarına göre sıralayark yazdıran metot.
    private static void yasaGoreSirala(){
        System.out.println("\n============ YAŞA GÖRE SIRALAMA ============");
        ogrListesi.stream().
                sorted(Comparator.comparing(Ogrenci::getYas).reversed()).
                forEach(System.out::println);
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

    //reduce metoduyla ortalama hesaplama yöntemi
    public static double sinifOrtalamsiHesapla1() {
        double toplam = ogrListesi.stream().map(Ogrenci::getDiplomaNotu).reduce(0.0, Double::sum);
        return toplam/ogrListesi.size();
    }

    // average() yöntemiyle ortalama hesaplanabilir.average() yöntemini kullanmak için stream'i
    // mapToDouble() yöntemi ile DoubleStream'e çevirmek gerekir. Ancak average() OptionalDouble
    // veri tipi döndürür. orElse() metodunun kullanımı ile Optional veri tipi kulanmamıza gerek kalmaz.
    public static double sinifOrtalamsiHesapla2() {
        return ogrListesi.stream().mapToDouble(Ogrenci::getDiplomaNotu).average().orElse(Double.NaN);
    }

    // DoubleStream için summaryStatistics() metodu ile stream içindeki
    // bir çok sayısal veriler elde edilebilir.
    public static void sinifOrtalamsiHesapla3() {
        DoubleSummaryStatistics istatistik = ogrListesi.
                stream().
                mapToDouble(Ogrenci::getDiplomaNotu).
                summaryStatistics();
        System.out.println("========= SINIF DİPLOMA NOT İSTATİSTİKLERİ ===========");
        System.out.println("SINIF ORTALAMASI:"+ istatistik.getAverage());
        System.out.println("KİŞİ SAYISI:"+ istatistik.getCount());
        System.out.println("MAKS ORTALAMA:"+ istatistik.getMax());
        System.out.println("MİN ORTALAMA:"+ istatistik.getMin());

    }

    // Bir Collection'daki veriler stream'e çevirmeksizin removeIf() metoduyla silinebilir.
    // removeIf bir lamba fonksiyonunu parametre olarak alabilir.
    // removeIf bir ArrayList metodudur ve listeyi kalıcı olarak günceler.
    public static void ismeGoreOgrenciSil(String isim){
        boolean silindiMi = ogrListesi.removeIf(t->t.getAd().contains(isim));
        System.out.println("\n=========== SİLME RAPORU =============");
        if (silindiMi == true) {
            System.out.println(isim + " isimli öğrenciler silindi");
        } else {
            System.out.println(isim + " isimli öğrenciler SİLİNEMEDİ");
        }
    }

}
