package Lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    public static  void main(String[] args) {
        //Bu classta agirlikli return type calisacagiz


        TechPro trGunduz=new TechPro("yaz","TR gunduz",97,124);
        TechPro engGunduz=new TechPro("kis","ENG gunduz",95,131);
        TechPro trGece=new TechPro("bahar","TR gece",98,143);
        TechPro engGece=new TechPro("sonbahar","ENG gece",93,151);


        List<TechPro> list=new ArrayList<>(Arrays.asList(trGunduz,engGunduz,trGece,engGece));


        System.out.println(BatchOrt92Byk(list));  //true verdi
        System.out.println(ogrsayisi100az(list));//true verdi
        System.out.println(baharvarming(list));
        System.out.println(ogrcSayisiTersSiraliBatch(list));
        System.out.println(batchOrtTersSiraliBatch(list));
        System.out.println(ogrsirasienazikiBatch(list));
        System.out.println(ort95buyuksayitopla(list));
        System.out.println(Batchort95buyuksayitopla(list));
        System.out.println(Batchort130danbuyukortalama(list));

    }


        public static boolean BatchOrt92Byk (List<TechPro> list) {
        return list.stream().allMatch(t->t.getBatchOrt()>92);
    }


    //task 02-->ogrc sayilarinin hic birinin  110 den az olmadigini  kontrol eden pr create ediniz.
       public static boolean ogrsayisi100az(List<TechPro> list) {
        return list.stream().noneMatch(t->t.getOgrcSayisi()<110);
        //allMatch(t->t.getOgrsaysi()>=110);  ayni sonucu verir

   }


       //task 03-->batch'lerde herhangi birinde "bahar" olup olmadigini  kontrol eden pr create ediniz.
       public static boolean baharvarming (List<TechPro> list) {
        return list.stream().anyMatch(t->t.getBatch().equalsIgnoreCase("Bahaor"));

}

        public static List<TechPro> ogrcSayisiTersSiraliBatch(List<TechPro> list){
        return  list.
                stream().
                sorted(Comparator.comparing(TechPro::getOgrcSayisi).reversed()).//ogr sayisi parametresine
                collect(Collectors.toList());//collect()->akısdaki elamanları istenen sarta gore toplar
        //Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir
    }


        //task 05-->batch'leri batch ort gore  b->k siralayip ilk3 'unu yazdiriniz.
        public static List<TechPro> batchOrtTersSiraliBatch(List<TechPro> list){
        return  list.
            stream().
            sorted(Comparator.comparing(TechPro::getBatchOrt).reversed()).//ogrcSayisi parametresine gore ters siraladi
                    limit(3).//akıstadki elemanlarin ilk ucu alindi
                    collect(Collectors.toList());//collect()->akısdaki elamanları istenen sarta gore toplar
                    //Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir
}

         //task 06--> ogrc sayisi en az olan 2. batch'i  yazdiriniz.
         public static List<TechPro> ogrsirasienazikiBatch(List<TechPro> list){
            return  list.
            stream().
            sorted(Comparator.comparing(TechPro::getOgrcSayisi)).//ogrcSayisi parametresine gore  siraladi
                    limit(2).//ilk iki elelman alindi
                    skip(1).//ilk elelamn atlatildi
                    collect(Collectors.toList());//collect()->akısdaki elamanları istenen sarta gore toplar

}



          //task 07--> batch ort 95 'den buyuk olan batch'lerin ogrc sayilarini toplamini yazdiriniz
          public static int ort95buyuksayitopla(List<TechPro> list){

           return list.stream().filter(t -> t.getBatchOrt() > 95).map(t -> t.getOgrcSayisi()).reduce(0,Integer::sum);
                                                                                            //reduce(0,(t,u)->t+u);

    }

            public static int Batchort95buyuksayitopla(List<TechPro> list){

            return list.stream().filter(t -> t.getBatchOrt() > 95).mapToInt(t -> t.getOgrcSayisi()).sum();

    }



            //task 08--> ogrc sayilari 130 dan buyuk olan batch'lerin batch ort bulunuz
           public static OptionalDouble Batchort130danbuyukortalama(List<TechPro> list){
           return list.stream().filter(t->t.getOgrcSayisi()>130).mapToDouble(t->t.getBatchOrt()).average();
    }






}
