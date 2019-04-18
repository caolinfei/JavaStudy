import com.study.domian.User;
import com.study.domian.UserQuery;
import org.junit.Test;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DynamicSqlTest extends MybatisBaseTest {

    @Test
    public void QueryByDynamic() {

        UserQuery userQuery=new UserQuery();
        userQuery.setName("mybatis1");
        userQuery.setIds(Arrays.asList(new Integer[]{1,2,3,4}));
        List<User> users = userDao.selectByQuery(userQuery);

        System.out.println(users);
    }
}
