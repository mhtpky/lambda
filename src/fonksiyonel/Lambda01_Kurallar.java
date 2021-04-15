package fonksiyonel;

import java.util.Arrays;
import java.util.List;
// Javada Lambda fonksiyonları sadece Fonksiyonel interface'ler ile kullanılabilir.
// Sadece bir adet abstract metodu olan interface'lere fonksiyonel interface denilir.
// Kullanıcı isterse kendi fonksiyonel interface'ini yazabilir. Ama Javada hali hazırda
// Consumer, Function, Supplier, Predicate gibi tanımlanmış interfaceler bulunmaktadır.
// Ayrıca bu interface'leri parametre olarak alabilen High Order Function (HOF)'lar da bulunmaktadır.
// foreEach(), map(), filter(), reduce() gibi HOF'lar fonksiyonel interfaceler ile çalıştığı için
// içerisinde Lambda fonksiyonları yazmak mümkündür.
// Javada genelde bu gibi fonksiyonlar üzerinden Lambda ifadeleri kullanılmaktadır.
public class Lambda01_Kurallar {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // forEach() bor collection'un oterasyonu icin ullanilan HOF'dur
        // Parametre olarak bir Lambda fonksiyonu alabilir

        list.forEach(x -> System.out.print(x + " "));
        // list >>
        // collection
        // forEach >> HOF
        // x-> System.out.println(x) >> Lambda fonksiyonu
        // dongu olusturmak yerine for each fonksiyonu ile ayni islemi yaptim
        // for each icine lambda fonksiyonu alabiliyor bunu da gormus olduk

        System.out.println();

        // Listenin eleanlarini 2 artirarak yazdiralim
        list.forEach(t -> System.out.print(t + 2 + " "));

        System.out.println();
        // Eger expression sayisi 1 den fazla ise {} kullanmaliyiz
        list.forEach(t -> {
            int miktar = 2; // expression 1
            System.out.print(t + miktar + " "); // expression 2
        });

        System.out.println();
        System.out.println("Veri tipi kullanilirsa EXPLICIT");
        list.forEach((Integer x) -> System.out.print(x * 2 + " "));

        System.out.println();
        System.out.println("Bir dis degisken kullanalim");
        int deger = 5;
        list.forEach(t -> System.out.print(t + deger + " "));


        // Method referansi ==> ClassAdi :: methodAdi
        System.out.println("\nMethod referans kullanimi");
        list.forEach(System.out::println); // for eachin dolastigi yrde ki tum elemanlari altalta yazdiracak

        // Method referansi ==> ClassAdi :: methodAdi
        System.out.println("\nMethod referans kullanimi");
        list.forEach(System.out::println);
    }
        public static void yazdir (int x){
            System.out.println(x+" ");
        }






}
