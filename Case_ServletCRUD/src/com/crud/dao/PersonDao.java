package com.crud.dao;

import com.crud.domian.Person;
import com.crud.domian.PersonQuery;

import java.util.List;

public interface PersonDao {

    Person getById(int id);

    List<Person>getList();

    Person getPersonByNameAndAge(String name,int age);

    void  add(Person p);

    List<Person> getListForPage();

    QueryResult<Person>queryResult(PersonQuery query);
}
