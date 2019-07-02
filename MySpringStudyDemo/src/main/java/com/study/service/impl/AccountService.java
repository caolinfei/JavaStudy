package com.study.service.impl;

import com.study.dao.IAccountDao;
import com.study.domain.Account;
import com.study.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.Resources;
import java.sql.SQLException;
import java.util.List;

/**
 * IOC注解
 *
 * @Compoemnt 向Spring容器注入当前对象
 * @Repository
 * @Service
 * @Controller 以上三个注解的作用一致 一般是分层使用 结构更清晰
 * @Autowired 自动注入 默认按照当前声明的 IAccountDao 声明的变量名去查找 如dao1 默认查找Dao1
 * 如果名称查找不到 然后按类型去匹配
 * @Qualifier 按照名称去注入不可以单独使用 需要和Autowired一起使用 作为方法参数的时候 可以单独使用
 * @Resource 可以单独使用 知道名称
 * Scope
 * 作用：用于指定bean的作用范围
 * 属性：
 * value：指定范围的取值。常用取值：singleton prototype
 * <p>
 * * 和生命周期相关 了解
 * 他们的作用就和在bean标签中使用init-method和destroy-methode的作用是一样的
 * PreDestroy
 * 作用：用于指定销毁方法
 * PostConstruct
 * 作用：用于指定初始化方
 */
//@Service("accountService")
@Component("accountService")

public class AccountService implements IAccountService {
    //    @Autowired
    //    @Qualifier("accountDao2")
    // @Resource(name = "accountDao2")
    @Autowired
    private IAccountDao accountDao;

    @PreDestroy
    public void preDestroy() {
        System.out.println("对象释放");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("对象初始化");
    }

    public List<Account> findAll() {
        try {
            return accountDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account getById(Integer id) {
        try {
            return accountDao.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public  Integer update(Account account)
    {
        try {
            return  accountDao.update(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

    public  Integer inster(Account account)
    {
        try {
            return  accountDao.insert(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }
}
