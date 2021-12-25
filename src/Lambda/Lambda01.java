package Lambda;
import kotlin.jvm.internal.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {
    // funktional programmingdir--Lambda
    //list-set-gueue bunlar collectiondur sadece collectionlarda kullanilir
    //sinirli ama reusable cok islevsel bir sistem
    //hiz, kod sadeligi, code okunabilirligi ve  hatasiz code okuma ve guvenlik acilarindan faydalidir

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 25, 36, 48, 79, 99, 103, 3, -8));
        //methodlarla calisacagim icin main  disinda olusturuyorum hepsini
       //ama o methodlari mainden cagirip yazdiririm

        printElstructured(list);   //10 25 36 48 79 99 103 3 -8  ---> forEach ile amele usulu yazdirma yaptim. lambda degildi
        System.out.println();
        System.out.println("********");

        printElfunktional(list);  //10 25 36 48 79 99 103 3 -8 --> Lambda oberator t nin kullanimi ile yazdirdim

        System.out.println();
        System.out.println("********");

        printElfunktional1(list);  //10 25 36 48 79 99 103 3 -8 --->Method reference ile yazdirdim

        System.out.println();
        System.out.println("********");

        printciftElstructured(list);  //10 36 48 -8   --->CIft elemanlari structurude methoduyla yazdik

        System.out.println();
        System.out.println("********");

        printciftElfunktional1(list);  //10 36 48 -8 hem referance kullandi hemde filter methodu kullandi

        System.out.println();
        System.out.println("********");

        printciftElfunktional2(list);  //10 36 48 -8  bu method reference ile yazildi

        System.out.println();
        System.out.println("********");

        printciftAltmisKucukEl(list);  //10 36 48 -8 cift filtre ile baktik ayni anda reference ve expression kullanamadik bunu gorduk

        System.out.println();
        System.out.println("********");

        printtekyirmibuyukEl(list); //25 36 48 79 99 103 3

        System.out.println();
        System.out.println("********");

        printciftKarelerini(list);  //bunu map() methodu ile cozduk  sonuc : 100 1296 2304 64

        System.out.println();
        System.out.println("********");

        tekkup(list);  //15626 493040 970300 1092728 28 hem filter vardi hemde map

        System.out.println();
        System.out.println("********");

        ciftKarekok(list);  //3.1622776601683795 6.0 6.928203230275509 NaN  yazdi

        System.out.println();
        System.out.println("********");

        enbuyukeleman(list);  //Optional[103]   ---> reduce metoduyla duzenleyip tek eleman cektik


        System.out.println();
        System.out.println("********");



        System.out.println();
        System.out.println("********");






    }
    //structured programming ile list elemanlarinin tamamini yazdiriniz
    public static void printElstructured(List<Integer> list) {  //
        for (Integer w : list) {
            System.out.print(w + " ");
    }
    }

        //Funktional programming ile list elemanlarinin tamamini aralarinda bosluk birakarak yazdiriniz
        public static void printElfunktional(List<Integer> list) { //iste bu lambda
           list.stream().forEach(t->System.out.print(t+" "));  //Lambda expression yaptik. Lambda ifadesi
        // stream(): datalari yukaridan asagiya akis sekline getirir
        // forEach(): datanin parametresine gore her bir elemani isler
        // t->Lambda operatorudur
        //Lambda Expression yapisi cok tavsiye edilmez daha cok METHOD  EXPRESSION kullanilir
        //stream dikeyden calistirir. Ilerilerde karsilastirma operatorleri gelecek. Ki bunlar daha fazla stream methodlari.20 den fazla
     }

     //Method reference ile list elemanlarinin tamamini aralarinda bosluk birakarak yazdiriniz
     //Method reference ---> kendi create ettigimiz veya javadan aldigimiz method ile olusturulur
     //Classname::MethodName ---> Method reference budur
    //Bir method olusturuyorum sonra istedigim zaman cagiriyorum
        public static void printEl(int t){  //refere edilecek method create edildi
            System.out.print(t+" ");

    }

    //Yukarida olusturdugum methodu refere ederek calistik
        public static void printElfunktional1(List<Integer>list){
        list.stream().forEach(Lambda01::printEl);
    }



    //structured programming ile list elemanlarinin cift olanlarini aralarinda boslukla yazdiriniz
        public static void printciftElstructured(List<Integer> list){
        for (Integer w:list) {
            if (w%2 ==0){
                System.out.print(w+" ");
    }
    }
    }


       //Funktional programming ile list elemanlarinin cift olanlarini aralarinda bosluk birakarak yazdiriniz
       public static void printciftElfunktional1(List<Integer> list){
         list.stream().filter(t->t%2==0).forEach(Lambda01::printEl);  //Lambda ile yazdirdik
       //filter() : filtreleme yapar yani bir akis icerisinde eslesen elemanlari istenen sarta gore olusan akis icerisinde donduruyor
       }

       public static boolean ciftBul(int i){  //refere edilecek tohum method create edildi

        return i%2==0;
       }

       public static void printciftElfunktional2(List<Integer> list) {
        list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl);

    }




    //Funktional programming ile list elemanlarinin cift ve 60 dan kucuk olanlarini  aralarinda bosluk birakarak yazdiriniz

       public static void printciftAltmisKucukEl(List<Integer> list) {
        list.stream().filter(t->t%2==0 & t<60).forEach(Lambda01::printEl);
         //  list.stream().filter(Lambda01::ciftBul & t->t<60).forEach(Lambda01::printEl);
        // ya lambda expression yapacaksin yada method refenence ikiside ayni anda kullanilamaz!!

    }




    //Funktional programming ile list elemanlarinin tek veya 20 dan buyuk olanlarini  aralarinda bosluk birakarak yazdiriniz

    public static void printtekyirmibuyukEl(List<Integer> list) {
        list.stream().filter(t->t%2==1 || t>20).forEach(Lambda01::printEl);

    }



    //Funktional programming ile list elemanlarinin cift olanlarinin karelerini ayni satirda aralarinda bosluk birakarak yazdiriniz
     public static void printciftKarelerini(List<Integer> list){
        list.stream().filter(Lambda01::ciftBul).map(t->t*t).forEach(Lambda01::printEl);
                                            //sana update edilmis elemanlarin karelerini dondur
         //list.stream().filter(Lambda01::ciftBul).map(Math::pow).forEach(Lambda01::printEl);--->bunu yazamadim cunku sayim double degil o yuzden kabul etmetdi

         //map() : elemanlarin update edilmesi icin ve bir isleme, uygulamaya sokulmasi icin kullanilir
         //         agirlikli olarak matematik islemleri yapilir
     }



     //Funktional programming ile list elemanlarinin tek olanlarinin kuplerinin bir fazlasini  aralarinda bosluk birakarak yazdiriniz
     public static void tekkup(List<Integer> list){

     list.
             stream().
             filter(t->t%2==1).
             map(t->t*t*t+1).
             forEach(Lambda01::printEl);
     //elemanlar degisiyorsa map kullanilir!!!

      }




      //Funktional programming ile list elemanlarinin cift olanlarinin karekoklerini aralarinda bosluk birakarak yazdiriniz

    public static void ciftKarekok(List<Integer> list){
        //  list.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(Lambda01::printEl); -->Bunu da calistirmadi double istedi ve printELin altini cizdi o yuzden asagida yeniden manuel yazdik
        list.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(t-> System.out.print(t+" "));

    }




      //Listt'in en buyuk elemanini yazdiriniz

      public static void enbuyukeleman(List<Integer> list){
          Optional<Integer> maxEl = list.stream().reduce(Math::max);  //en buyuk elemana gore iceride doner yazdirmak icin assignden oncesini yazdik
                                              //reduce coklu elemanlari tek bir elemana cevirdi
          //reduce(): azaltmak anlamina gelir. Bir cok datayi tek bir dataya(max min carpma top vs islemlerde) cevirmek icin kullanilir
          System.out.println(maxEl);
      }






}