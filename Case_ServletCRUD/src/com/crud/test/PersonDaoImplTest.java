package com.crud.test;

import com.crud.dao.PersonDao;
import com.crud.dao.PersonDaoImpl;
import com.crud.dao.QueryResult;
import com.crud.domian.Person;
import com.crud.domian.PersonQuery;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class PersonDaoImplTest {

    @Test
    public void  test(){
        PersonDao dao=new PersonDaoImpl();
        PersonQuery query=new PersonQuery();
        query.setName("赵四");
        QueryResult<Person> result = dao.queryResult(query);
    }

}
