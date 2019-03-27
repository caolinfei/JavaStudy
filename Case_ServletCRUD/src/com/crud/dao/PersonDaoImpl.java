package com.crud.dao;
import com.crud.domian.Person;
import com.crud.domian.PersonQuery;
import com.crud.utils.JDBCUntils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDaoImpl implements PersonDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUntils.getDataSource());
    @Override
    public Person getById(int id) {
        String sql="select *from tb_person where id=?";
        Person person = template.queryForObject(sql, new BeanPropertyRowMapper<Person>(Person.class), id);
        return person;
    }

    @Override
    public List<Person> getList() {

        String sql="select *from tb_person";
        List<Person> query = template.query(sql, new BeanPropertyRowMapper<Person>(Person.class));
        return query;

    }

    @Override
    public Person getPersonByNameAndAge(String name, int age) {
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getDeclaredFields();


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
    public QueryResult<Person>queryResult(PersonQuery query)
    {
        QueryResult<Person> result=new QueryResult<>();
        List<Object>par=new ArrayList<>();
        String column = getColumn(query);
        StringBuilder sql=new StringBuilder("SELECT ");
        sql.append(column+" ");
        sql.append(" FROM tb_person");
        sql.append(" where 1=1 ");


        if(query.getName()!=null&&!"".equals(query))
        {
            sql.append("AND name = ? ");
            par.add(query.getName());
        }
        List<Person> query1 = template.query(sql.toString(), new BeanPropertyRowMapper<Person>(Person.class), par.toArray());
        result.setList(query1);
        Integer integer = template.queryForObject("select count(*) from tb_person", Integer.class);
        result.setCout(integer);
        return result;
    }

    private String getColumn(PersonQuery query) {
        Field[] declaredFields = query.getaClass().getDeclaredFields();
        List<Field> fields = Arrays.asList(declaredFields);
        List<String> collect = fields.stream().map(m -> m.getName()).collect(Collectors.toList());
        String join = String.join(",", collect);
        return join; 
    }
}
