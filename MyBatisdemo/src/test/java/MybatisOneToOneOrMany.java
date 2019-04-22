import com.study.domian.Account;
import com.study.domian.UserAccount;
import org.junit.Test;

import java.util.List;

public class MybatisOneToOneOrMany extends MybatisBaseTest {


    @Test
    public void  findUserWithAccount(){
        List<UserAccount> userWithAccount = userDao.findUserWithAccount();
        System.out.println(userWithAccount);
    }

    /**
     *多对多查询
     *
     */
    @Test
    public void  findUserWithAccounts(){
        List<UserAccount> userWithAccount = userDao.findUserWithAccount();
        for (UserAccount userAccount : userWithAccount) {
            System.out.println(userAccount);
            for (Account account : userAccount.getAccounts()) {
                System.out.println(account);
            }
        }
    }

}
