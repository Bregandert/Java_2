package ru.geekbrains.java2.lesson3;

import java.util.*;

public class lesson3 {
    public static void main(String[] args){
        String words="ехал Грека через реку, " +
                "видит Грека -в реке рак. " +
                "сунул Грека руку в реку, " +
                "рак за руку Грека -цап! ";
        words=words.replaceAll("\\pP","");
        String[] wordsList=words.split(" ");
        System.out.println(Arrays.toString(wordsList));
        Set<String> hashSet=new HashSet<>();
        for (int i=0;i<wordsList.length;i++){
            hashSet.add(wordsList[i]);
        }
        System.out.println(hashSet);
        Map<String,Integer> hashMap=new HashMap<>();
        for (int i=0;i<wordsList.length;i++){
            Integer s4et=hashMap.get(wordsList[i]);
            hashMap.put(wordsList[i], s4et==null?1:s4et+1);
        }
        hashMap.forEach((k,v)->System.out.printf("Слово <%s> встречается %d раз(а)\n",k,v));


//        Person fio1=new Person("Ivanov", "8-903-000-00-01", "1@mail.ru");
//        Person fio2=new Person("Petrov", "8-910-000-00-02", "2@mail.ru");
//        Person fio3=new Person("Ivanov", "8-953-000-00-03", "3@mail.ru");

        PhoneBook book=new PhoneBook();
        book.add("Ivanov", new Person("8-903-000-00-01", "1@mail.ru"));
        book.add("Petrov", new Person("8-910-000-00-02", "2@mail.ru"));
        book.add("Ivanov", new Person("8-953-000-00-03", "3@mail.ru"));
        String Fio="Ivanov";
        System.out.println("Телефоны господина "+Fio+": "+book.findPhone(Fio));
        System.out.println("Почта господина "+Fio+": "+book.findMail(Fio));
    }

}
