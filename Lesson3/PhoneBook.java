package ru.geekbrains.java2.lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String,ArrayList<Person>> phoneBook;

    public PhoneBook(){
        this.phoneBook=new HashMap<>();
    }

    public void add (String surname, Person person){


        if (!(phoneBook.containsKey(surname))){
            ArrayList<Person> list1=new ArrayList<>();
            list1.add(person);
            phoneBook.put(surname, list1);
        } else {
            ArrayList<Person> list2=phoneBook.get(surname);
            list2.add(person);
            phoneBook.put(surname, list2);
        }
    }
    public ArrayList<String> findPhone(String surname) {
        ArrayList<Person> list = phoneBook.get(surname);
        ArrayList<String> findNumber = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            findNumber.add(list.get(i).getPhone());
        }
        return findNumber;
    }

//          this.surname=surname;
//        HashMap<String, ArrayList> hashPhone=new HashMap<>();
//        ArrayList<String> s= new ArrayList<>();
//
//        for (Person person:Person.listPerson){
//            if (person.getSurname()==surname){
//                s.add(person.getPhone());
//            }
//
//        }
//        System.out.println(surname+": "+s);
//        return s;
public ArrayList<String> findMail(String surname) {
    ArrayList<Person> list = phoneBook.get(surname);
    ArrayList<String> findAddress = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
        findAddress.add(list.get(i).getEmail());
    }
    return findAddress;
    }
}
