package com.study.dao;

import com.study.domian.Person;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPersonDao {

    @Select("select * from tb_person")
     List<Person>findAll();


}
