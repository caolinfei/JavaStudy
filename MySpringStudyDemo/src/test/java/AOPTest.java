import com.study.AopTest.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: caolf
 * @Date: 2019/7/3 14:57
 */

public class AOPTest {

    @Test
    public void Test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
        UserService userService = (UserService) ac.getBean("userService");
        userService.findAll();
    }
}
