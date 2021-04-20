package stream_ornekler;

import java.util.ArrayList;
import java.util.List;

public class Stream01_Integer {
    public static void main(String[] args) {
        List<Integer> rakamlar = new ArrayList<>();
        rakamlar.add(5);
        rakamlar.add(7);
        rakamlar.add(7);
        rakamlar.add(9);
        rakamlar.add(-1);
        rakamlar.add(2);
        rakamlar.add(4);
        rakamlar.add(-1000);
        rakamlar.add(4);

        //***********************************************************************
        // ORNEK1: Bir listedeki tek sayıları yazdırınız.
        //***********************************************************************
        System.out.println("TEK SAYILAR");
        rakamlar.stream().filter(t -> t % 2 != 0).forEach(System.out::print);

        //***********************************************************************
        // ORNEK2: Bir listedeki çift sayıları yazdırınız.
        //***********************************************************************
        System.out.println("\n\nCIFT SAYILAR");
        rakamlar.stream().filter(t -> t % 2 == 0).forEach(x -> System.out.print(x+" "));

        //***********************************************************************
        // ORNEK3: Bir listedeki tek sayıları metot referansı ile yazdırınız.
        //***********************************************************************
        System.out.println("\n\nTEK SAYILAR");
        rakamlar.stream().filter(Methodlar::tekMi).forEach(Methodlar::yazdir);

        //***********************************************************************
        // ORNEK4: Bir listedeki çift  sayıları  yazdıran bir metot tanımlayınız.
        //***********************************************************************
        System.out.println("\n\nCIFT SAYILAR(METHOD)");
        ciftleriYazdir(rakamlar);
    }


    public static void ciftleriYazdir(List <Integer> liste){
   //   liste.stream().filter(x->x%2==0).forEach(x-> System.out.println(x+" "));
        liste.stream().filter(Methodlar::ciftMi).forEach(Methodlar::yazdir);
    }



}
