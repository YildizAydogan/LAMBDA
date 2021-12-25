package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Lambda02 {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 25, 69, 24, -4, -5));

        ciftkareenbuyukEl(list);  //Optional[576]
        tumtoplam(list);         //118
        topla2(list);            //Optional[118]
        ciftcarp(list);          //Optional[-1152]
        ciftcarpexpression(list);// -1152  ,  1152  carpimdan sonuc olarak negatif ve pozitif sonuc bulduk


    }


    //Listin cift olan elemanlarinin karelerini alin ve en buyuygunu yazdiriniz
    public static void ciftkareenbuyukEl(List<Integer> list) {
        Optional<Integer> ckab = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
        // Optional<Integer> ckab = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Math::max);
        // bu methodda calisir ama specifik kodlar daha hizli calisir.Math klasi daha genistir koca klasta arayip islem yapacak
        //dolayisiyla integer klasi daha dar ve hizli calisir

        //int ckab = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
        //reduce() return edilen eleman null yada int'den buyuk olur ihtimali icin java guvenlik olarak handle ederek
        //Optional class i sart kosmus, gerekli kilmistir...
        System.out.println(ckab);  //objeyi yaz sag tikla sout yaz otomatik geldi
    }


    //Listteki tum elemanlarin toplamini yazdiriniz
    //Lambda expression...
    public static void tumtoplam(List<Integer> list) {  //Math::sum yapsaydik method reference olurdu math clasindan cagirdigim icin

        int toplam = list.stream().reduce(0, (x, y) -> x + y);
        //x her zaman ilk degerini atanan deger yani = dan alir
        //y her zaamn degerini list.stream() den alir yani akistan
        //x ilk degerden sonra degerlerini islemlerden alir
        System.out.println(toplam);
    }

    public static void topla2(List<Integer> list) {

        Optional<Integer> topla2 = list.stream().reduce(Integer::sum);  //integerda carpma yok mesela math klasinda var
        Optional<Integer> toplam3 = list.stream().reduce(Math::addExact);
        System.out.println(topla2);   //Optional[118]
        System.out.println(toplam3);  //Optional[118]

    }

    //Listteki cift elemanlarin carpimini yazdiriniz
    //Method reference...
    public static void ciftcarp(List<Integer> list) {
        Optional<Integer> carp = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact); //tek sonuc isteidim icin reduce
        System.out.println(carp);

    }

    //Listteki cift elemanlarin carpimini yazdiriniz
    //Lambda Expression...
    public static void ciftcarpexpression(List<Integer> list) {
        Integer carp2 = list.stream().filter(Lambda01::ciftBul).reduce(1, (x, y) -> (x * y)); //negatif sonuc dondurur
        Integer carp3 = list.stream().filter(Lambda01::ciftBul).reduce(-1, (x, y) -> (x * y));//pozitif sonuc dondurur
        System.out.println(carp2);
        System.out.println(carp3);


    }

    //Listteki elemanlardan en kucugunu bulunuz 4 farkli yontemle ile yazdiriniz
    // 1. yontem Method Reference  -->Integer class
    public static void min1(List<Integer> list) {
        Optional<Integer> min1 = list.stream().reduce(Integer::min);
        System.out.println(min1);


    }

    //2. yontem Method Reference --> Math class
    public static void min2(List<Integer> list) {
        Optional<Integer> min2 = list.stream().reduce(Math::min);
        System.out.println(min2);

    }

    public static int minBul(int x, int y) {  //minbul methodu olusturdum referencede kullanabilmek icin

        return x < y ? x : y; //ternary
    }


    //3. Yontem Method Reference ile...
    public static void min3(List<Integer> list) {
        Optional<Integer> min3 = list.stream().reduce(Lambda02::minBul);
        System.out.println(min3);

    }

    // Lambda Expression ile...
    public static void min4(List<Integer> list) {
        Integer min2 = list.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);

    }


}
