package com.crud.service;

import com.crud.domian.Person;

import java.util.List;

public interface PersonService {

     Person getById(int id);

    List<Person> getList();

    Person getPersonByNameAndAge(String name,int age);

    void  add(Person p);

    List<Person> getListForPage();



}
