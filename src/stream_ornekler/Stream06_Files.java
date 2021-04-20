package stream_ornekler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class Stream06_Files {
    public static void main(String[] args) throws IOException {
        // File islemleri yaparken Java 'ya dosyayi bulamazsam' diye hata verir.
        // Bunun onune gecebilmek icin throws IOException eklememiz gerekir.

        Stream<String> satirlar = Files.lines(Path.of("src/stream_ornekler/mars.txt"));
        // Dosyamizi stream e cevirdik. (marsimiz string oldugu icin data type string olmali)
        satirlar.forEach(System.out::println);

        System.out.println("=======================================");
        // satirlar.map(String :: toUpperCase).forEach(System.out::println);
        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated

        // Stream akan su gibi dusunmek lazm su akar gider ve giden su bir daha bulunamaz
        // Dolayisiyla 13. satirda for each koydugumuzda stream'i kullandik bitti
        // Artik ayni sekilde ona erisemeyiz icinde ki veriler Garbage Collector tarafindan silinms oldu
        // Yeniden tanimlama yapmamiz gerekiyor

        // Her defasinda bu sekilde path almak ugrastiricidir.
        // Path'imizi bir string olarak tanimlayip  kullanabiliriz.
        // Genel kullanim bu sekildedir
        String path = "src/stream_ornekler/mars.txt";
        // dogrudan stream'i alip bu sekilde kullanabiliriz

        // Files'in tum elemanlarini buyuk harfle yazdiralim
        Files.lines(Path.of(path)).
                map(t->t.toUpperCase()).
                forEach(System.out::println);

        System.out.println("=======================================");

        // Dosyadan sadece ilk satiri okuyarak Buyuk Harf olarak konsola yazdiralim
        Files.lines(Path.of(path)).
                limit(1).
                map(String::toUpperCase).
                map(t->t.toUpperCase()).
                forEach(System.out::println);

        System.out.println("=======================================");

        // Sadece 3 ve 4. satirlari almak istiyoruz
       //Files.lines(Path.of(path)).limit(4).skip(2).forEach(System.out::println);
        Files.lines(Path.of(path)).
                skip(2).
                limit(2).
                map(t->t.toUpperCase()).
                forEach(System.out::println);

        System.out.println("=======================================");

        // "Bu" kelimesi(kucuk veya buyuk) mars icinde kac adet geciyor yazdiralim
        System.out.println(Files.lines(Path.of(path)).
                map(t->t.toLowerCase()).
                filter(t-> t.contains("bu")).count());

        System.out.println("=======================================");

        // Dosyada ki tum farkli kelimeleri alt alta yazdiralim
        // Her satiri bir eleman olarak kabul ediyor. Ama biz her satir degil her kelime
        // uzerinde islem yapmak istiyoruz.
        // Kelimeleri boldugumuzde Nested gibi bir yapi olusur.
        // kelimeler satir elemanlarinin alt elemanlaridir.. Flatmap methodu

        Files.lines(Path.of(path)).
                map(t->t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).// parantez icine donusturmek istedigimiz turu yaziyoruz.
                                        // Arrays classindan stream turune cevirmek istiyorum
                                        // kelimelrden olusan tek bir liste olusturmus olduk
                                        // tum elemanlar tren gibi siralandi ve duzlesti
                distinct().
                forEach(System.out::println);

        System.out.println("=======================================");

        // Kelimeler icerisinde M veya m harfi olanlari sayalim ve sonucu konsola yazdiralim
        long mSayisi = Files.lines(Path.of(path)).
                map(t->t.toLowerCase().split("")).
                flatMap(Arrays::stream).
                filter(t->t.contains("m")).
                count();
        System.out.println("M harfinin sayisi " + mSayisi);
        System.out.println("=======================================");

        // Boşluk ve noktalama işaretleri hariç dosyada kaç adet karakter kullanıldığını
        // hesaplayarak sonucu konsola yazdıran uygulamayı yazınız.
        //  \\W "a-z" & "A-Z" & "8-9" & "_" haric tum karakterler demektir

        System.out.println(Files.lines(Path.of(path)).
                map(t->t.replace("_",""). // _ gorursek onu sil demis olduk
                        replaceAll("\\W","").split("")).
                flatMap(Arrays::stream).
                count());
    }

}
