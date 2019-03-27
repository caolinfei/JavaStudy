package com.crud.service;

import com.crud.dao.QueryResult;
import com.crud.domian.Person;
import com.crud.domian.PersonQuery;

import java.util.List;

public interface PersonService {

     Person getById(int id);

    List<Person> getList();

    Person getPersonByNameAndAge(String name,int age);

    void  add(Person p);

    List<Person> getListForPage();

     QueryResult<Person> queryResult(PersonQuery query);



}
