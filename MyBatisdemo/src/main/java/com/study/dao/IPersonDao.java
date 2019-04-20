package com.study.dao;

import com.study.domian.Person;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPersonDao {

    /**
     *
     * 当使用注解的时候 不是非要删除.mapper.xml是因为mybatis会默认取查找和当前全限定类名一致的
     * resource文件下的同名的xml并且注册 所以会导致重复的注册
     * @return
     */

    @Select("select * from tb_person")
     List<Person>findAll();


}
