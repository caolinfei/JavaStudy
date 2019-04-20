
import com.study.dao.IUserDao;
import com.study.domian.User;
import com.study.domian.UserQuery;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

public class MyBatisTest {

    private SqlSession sqlSession;
    private IUserDao iUserDao;

    @Before
    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(resourceAsStream);
        sqlSession = build.openSession();
        iUserDao = sqlSession.getMapper(IUserDao.class);
    }

    /**
     * @throws IOException
     */
    @Test
    public void Query() throws IOException {
        List<User> all = iUserDao.findAll();
        System.out.println(all);
    }

    @Test
    public void FindById() {
        User user = iUserDao.findById(1);
        System.out.println(user);

    }

    @Test
    public void insert() {

//        User u = new User();
//        u.setUsername("testMybatisss");
//        u.setPassword("123");
//        u.setBrithDate(Calendar.getInstance().getTime());
//        System.out.println(u);
//        int insert = iUserDao.insert(u);
//        System.out.println(u);

    }

    @Test
    public void update() {
//        User user = iUserDao.findById(3);
//        user.setUsername("update");
//        iUserDao.updateById(user);
    }

    @Test
    public void delete() {
        iUserDao.deleteById(1);
    }

    @Test
    public void  findByName(){

        //这里设置排序规则 可以避免大小写问题
        User user = iUserDao.findByName("Update");
        System.out.println(user);
    }
    @Test
    public void SelectCount(){
//        int i = iUserDao.selectCount();
//        System.out.println(i);

    }

    @Test
    public void  SelectByQuery(){

        UserQuery query=new UserQuery();
        User user=new User();
        user.setUserName("update");
        query.setUser(user);
        List<User> users = iUserDao.selectByQuery(query);
        System.out.println(users);

    }

    @After
    public void destory() {
        sqlSession.commit();
        sqlSession.close();
    }


}
