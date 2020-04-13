package ru.geekbrains.java2.lesson3;

import java.util.ArrayList;

public class Person {
//    String surname;
    String phone;
    String email;
    //public static ArrayList<Person> listPerson = new ArrayList<>();

    public Person(String phone, String email) {
//        this.surname = surname;
        this.phone = phone;
        this.email = email;
     //   listPerson.add(Person.this);
    }

//    public String getSurname() {
//        return surname;
//    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    //public int getIndex() {
//        return listPerson.indexOf(Person.this);
//    }
//
//    public static int getSize() {
//        return listPerson.size();
//    }
}
