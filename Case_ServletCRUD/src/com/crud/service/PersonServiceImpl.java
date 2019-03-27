package com.crud.service;

import com.crud.dao.PersonDao;
import com.crud.dao.PersonDaoImpl;
import com.crud.dao.QueryResult;
import com.crud.domian.Person;
import com.crud.domian.PersonQuery;

import java.util.List;

public class PersonServiceImpl implements PersonService {

   private PersonDao dao=new PersonDaoImpl();
    @Override
    public Person getById(int id) {
      return   dao.getById(id);

    }

    @Override
    public List<Person> getList() {
       return dao.getList();
    }

    @Override
    public Person getPersonByNameAndAge(String name, int age) {
        return null;
    }

    @Override
    public void add(Person p) {

    }

    @Override
    public List<Person> getListForPage() {
        return null;
    }

    @Override
    public QueryResult<Person> queryResult(PersonQuery query) {
       return dao.queryResult(query);
    }
}
