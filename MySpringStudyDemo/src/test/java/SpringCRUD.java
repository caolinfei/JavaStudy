/**
 * @Author: caolf
 * @Date: 2019/7/2 14:51
 */

import com.study.dao.utils.ConnectionUtils;
import com.study.domain.Account;
import com.study.proxy.CompanyService;
import com.study.proxy.ICompany;
import com.study.proxy.ServiceProxtFactory;
import com.study.proxy.StaticProxyService;
import com.study.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Spring 整合junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:bean02.xml")
public class SpringCRUD {

    @Autowired
    private IAccountService accountService = null;

    @Autowired
    private ConnectionUtils utils = null;
    @Autowired
    private ServiceProxtFactory<IAccountService> accountServiceServiceProxtFactory;

    @Test
    public void findAll() {
        Connection connection = utils.getConnection();
        List<Account> all = accountService.findAll();
        System.out.println(all);
    }

    @Test
    public void inster() {
        Account ac = new Account();
        ac.setName("ceshi");
        ac.setMoney(new BigDecimal(1034));
        Integer affected = accountService.inster(ac);
        System.out.println(affected);
    }

    @Test
    public void update() {
        Account byId = accountService.getById(4);
        byId.setName("测试123");
        byId.setMoney(new BigDecimal(3333));
        Integer update = accountService.update(byId);
        System.out.println(update);

    }

    @Test
    public void ProxyTest() {
        //静态代理 需要有一个代理类 需要实现每一个方法 然后编写如何代理
//        ICompany company=new StaticProxyService();
//        company.sale(10000);
        //动态代理
        final ICompany company = new CompanyService();
        //company 这里的company是代理的目标  没有目标类没有办法代理
        ICompany o = (ICompany) Proxy.newProxyInstance(ICompany.class.getClassLoader(), new Class[]{ICompany.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //proxy.toString();
//                if ("toString".equals(method.getName())) {
//                return "toString";
//                }

                if ("sale".equals(method.getName())) {
                    double money = (Double) args[0];
                    method.invoke(company, money * 0.8);
                }
                return null;
            }
        });
        //o.sale(1000);
        o.toString();
    }

    @Test
    public void transfer() {
        //没有事务支持
//        Account a1 = accountService.getById(1);
//        Account a2 = accountService.getById(2);
//        a1.setMoney(a1.getMoney().subtract(new BigDecimal(200)));
//        a2.setMoney(a2.getMoney().add(new BigDecimal(200)));
//        accountService.update(a1);
//        //模拟异常
//        int i=1/0;
//        accountService.update(a2);
        accountServiceServiceProxtFactory.setService(accountService);
        accountServiceServiceProxtFactory.getService().transfer(1, 2, new BigDecimal(200));
    }

    @Test
    public void aopTransfer() {
//        for (int i = 0; i < 1000; i++) {
//            accountService.transfer(1,2,new BigDecimal(200));
//        }

//        List<Account> all = accountService.findAll();
//        System.out.println(all);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {

            executorService.execute(()->{
                accountService.transfer(1,2,new BigDecimal(200));
            });
        }


    }
}
