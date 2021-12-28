package Lambda;

import java.util.*;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("Woldemort", "Alaaddin", "Mehmet", "Emre", "Nilgun", "Yildiz", "Kader", "Emine", "Islam", "Islam", "Emre"));
        alfabetiktekrarsizsira(list);
        System.out.println();
        karaktersayisiterssirali(list);
        System.out.println();
        karaktersayisisirali(list);
        System.out.println();
        karaktersayisisonharfsirali(list);
        System.out.println();
        kciftkaretekrarsizterssira(list);
        System.out.println();
        harfsayisiyedikontrol(list);
        Wilebaslayan(list);
        System.out.println();
        Xilebiten(list);
        System.out.println();
        kokorec(list);
        System.out.println();
        krkenbyk(list);
        ilkelemanatlat(list);
    }

    //List elemanlarini alfabetik buyuk harf ve  tekrarsiz yazdiriniz
    public static void alfabetiktekrarsizsira(List<String> list) {

        list.
                stream(). //  map(t->t.toUpperCase())
                map(String::toUpperCase).
                sorted().
                distinct().
                forEach(t -> System.out.print(t + " "));  //forEach(t->System.out.print(t + " ")) buda olurmus

    }

    //list elelmanlarinin character sayisini ters sirali olarak tekrarsiz yazdiriniz
    public static void karaktersayisiterssirali(List<String> list) {
        list.stream().map(t -> t.length()).sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::printEl);


    }
    //List elemanlarini character sayisina gore kckten byk egore yazdiriniz.

    public static void karaktersayisisirali(List<String> list) {
        list.stream().sorted(Comparator.comparing(t -> t.length())).forEach(t -> System.out.print(t + " "));
        //list.stream().map(t-> t.length()).sorted().forEach(Lambda01::printEl);

    }

    //list elelmanlarinin son harfine gore ters sirali yazdiriniz

    public static void karaktersayisisonharfsirali(List<String> list) {
        list.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString().
                                charAt(t.toString().length() - 1)).//elemanin length()-1)-->son inedx'inin karakterini alir
                                reversed()).//elemanin length()-1)-->son inedx'inin karakterini ters siralar z->a
                forEach(t -> System.out.print(t + " "));


    }
    //Cift sayili elemanlarin karelerini hesaplayan, tekrarli olanlari sadece bir kere buyukten kucuge dogru
    //yazdiran bir program yaziniz.

    public static void kciftkaretekrarsizterssira(List<String> list) {
        list.stream().map(t -> t.length() * t.length()).filter(Lambda01::ciftBul).distinct().sorted(Comparator.reverseOrder()).forEach(Lambda01::printEl);

    }

    //List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz
    public static void harfsayisiyedikontrol(List<String> list) {
        System.out.println(list.stream().allMatch(t -> t.length() <= 7) ? "7 den kucuk" : "7 den buyuk");

    /*      boolean kontrol= list.stream().allMatch(t->t.length()<=7);
            System.out.println(kontrol);
        if(kontrol){
             System.out.println("List elemanlari 7 harften buyuk degil");
         }else{
             System.out.println("List elemanlari 7 den buyuk");
         }    */


    }

    //List elelmanlarinin "W" ile baslamasını kontrol ediniz
    public static void Wilebaslayan(List<String> list) {

        //  list.stream().filter(t->t.startsWith("W")).forEach(t->System.out.print(t + " "));
//allMatch(t->t.startsWith("w"))
        System.out.println(list.stream().noneMatch(t -> t.startsWith("W")) ? "W ile baslayan isim mi olur" : "W ile baslayan ismin var :");

    }

    public static void Xilebiten(List<String> list) {
        System.out.println(list.stream().anyMatch(t -> t.endsWith("x")) ? "x ile bitenler ayaga kalksin" : "x ile biten kimse yok bebis");


        /*public static void wmi (List<String> list){
	System.out.println(list.stream().noneMatch(t->t.startsWith("w"))?"hicbiri W ile baslamiyor":"birileri W ile basliyor");
	System.out.println(list.stream().allMatch(t->t.startsWith("w"))?"hepsi W ile basliyor":"hicbiri W ile baslamiyor");
	System.out.println(list.stream().anyMatch(t->t.startsWith("w"))?"herhangibiri W ile basliyor":"hicbiri W ile baslamiyor");
         }*/
//anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
//allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
//noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.


    }
//Karakter sayisi en buyuk elemani yazdiriniz

    public static void kokorec(List<String> list) {
        //  list.stream().sorted(Comparator.comparing(String::length).reversed()).map(t-> t.length()).findFirst());
        System.out.println( list.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).findFirst());


    }

    // limit(1)); // Yapilan siralamadaki ilk elemani alir

    public static void krkenbyk(List<String> list) {
        Stream<String> sonIsim = list.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).limit(1);
        System.out.println(Arrays.toString(sonIsim.toArray()));
     //   System.out.println(sonIsim); bunu yazdirirsak referans deger verir


    }

public static void ilkelemanatlat(List<String> list) {
    list.stream().sorted(Comparator.comparing(t -> t.toString(). charAt(t.toString().length() - 1)).reversed()).skip(1).forEach(t -> System.out.print(t + " "));







}











}