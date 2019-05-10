import com.study.domian.Account;
import com.study.domian.UserAccount;
import org.junit.Test;

import java.util.List;

public class LazyLoadTest extends MybatisBaseTest {

    /**
     * 延时加载和
     * Mybatis缓存
     */
    @Test
    public void Test() {
        UserAccount userAccouunt = userDao.findUserAccouunt();
        System.out.println("查询执行完成");
        System.out.println(userAccouunt.getAccounts());
    }
    @Test
    public void Test2() {
        List<Account> accountByuid = accountDao.findAccountByUid(46);

        System.out.println(accountByuid);

    }
}
