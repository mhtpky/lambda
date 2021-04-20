package stream_ornekler;

import java.util.List;
import java.util.stream.*;

public class Stream05_Digerleri {
    public static void main(String[] args) {
        System.out.println("TOPLAM : " + topla(4));
        System.out.println("\nBELIRTILEN ARALIKTA KI SAYILAR");
        aralikYazdir(4);
        System.out.println("=======");
        tekSayilarToplami(0,10);
        System.out.println("\nFaktoriyel: " + faktoriyel(20));
        System.out.println("\nFaktoriyel1: " + faktoriyel1(20));
        System.out.println("\nFaktoriyel2: " + faktoriyel1(20));
        System.out.println("\n50 den buyuk olan notlar : " + doubleDiziCevirList());
    }

    // ORN25: 1'den belirtilen degere kadar olan tamsayilari toplayan ve sonucu donduren methodu yaziniz
    public static int topla(int deger){
        return IntStream.range(1, deger).sum(); // 1den degere kadar 1 dahil deger dahil degil
    }

    public static void aralikYazdir(int deger) {
      IntStream.rangeClosed(1,deger).forEach(System.out::println); // 1den degere kadar ikisi de dahil
    }

    //*****************************************************************************************
    // ORN26: Belirtilen degerler arasinda ki tek sayilari toplayip yazdiran bir method yaziniz
    //*****************************************************************************************
    public static void tekSayilarToplami (int alt, int ust) {
        System.out.println(IntStream.rangeClosed(alt,ust).filter(Methodlar::tekMi).sum());
        // sum terminal bir ifadedir ve tek bir deger dondurur.
    }

    //*****************************************************************************************
    // ORN27: Belirtilen sayinin faktoriyelini hesaplayan metodu tanimlayiniz
    //*****************************************************************************************
    public static Integer faktoriyel(int n) {
     // return IntStream.rangeClosed(1,n).reduce(1,(x,y)->x*y);
        return IntStream.iterate(1,t->t+1).limit(n).reduce(1,(x,y)->x*y);
        // iterate for dongusune benzer. baslangic noktsi, artis miktari, limit(bitis noktsi)
        // 1'den basla 1er artirarak 10 a kadar git
    }

    // Long araligi daha genis old icin buyuk degerlerde int e gore daha dogru sonuc verir
    public static Long faktoriyel1(int n) {
        return LongStream.rangeClosed(1,n).reduce(1,(x, y)->x*y);
    }

    public static double faktoriyel2(int n) {
        return DoubleStream.iterate(1,t->t+1).limit(n).reduce(1,(x,y)->x*y);
    }
    // DoubleStream'de rang ya da .rangeClosed yoktur cunku virgullu sayilar da binlerce deger vardir

    //*********************************************************************************************
    // ÖRNEK28: Bir double diziyi (notlar) Stream nesnesine dönüştürerek bu dizi içerisinde bulunan
    // sayıların 50 den büyük olanlarını ayrı bir listeye kaydererek yazdıran metodu tanımlayınız
    //**********************************************************************************************
    public static List<Double> doubleDiziCevirList(){
        Double [] notlar = {88.5, 52.3, 88.9, 100.0, 99.6, 42.0, 10.0};
        Stream<Double> streamNotlar = Stream.of(notlar);
        // Stream API icinde non-primitive verileri kullandigi icin
        // dizimizi de non-pri yapmamiz gerekir Double yerine double yaparsak hata verir
        return streamNotlar.filter((t->t>50.0)).collect(Collectors.toList());
    }



}
