import com.study.domian.Role;
import com.study.domian.UserAccount;
import org.junit.Test;

import java.util.List;

public class ManyToMany extends MybatisBaseTest {

    @Test
    public void findUserRole() {
        List<UserAccount> users = userDao.findUserRole();

        for (UserAccount user : users) {
            System.out.println(user);
            //System.out.println(user.getRoles());
            for (Role role : user.getRoles()) {
                System.out.println(role);
            }
        }
    }

}
