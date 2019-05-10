import com.study.domian.UserAccount;
import com.study.repositories.SampleObjectCallBack;
import com.study.repositories.SampleObjectCallBackImpl;
import org.junit.Test;

public class DynamicSqlTest extends MybatisBaseTest {

    @Test
    public void QueryByDynamic() {

//        UserQuery userQuery=new UserQuery();
//        userQuery.setName("mybatis1");
//        userQuery.setIds(Arrays.asList(new Integer[]{1,2,3,4}));
//        List<User> users = userDao.selectByQuery(userQuery);
//
//        System.out.println(users);

        //UserAccountRepository accountRepository=new UserAccountRepository();

        SampleObjectCallBack<UserAccount> u=new SampleObjectCallBackImpl();

    }
}
