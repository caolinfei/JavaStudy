
import com.study.dao.IUserDao;
import com.study.domian.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void Query() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        List<User> all = iUserDao.findAll()
        System.out.println(all);



    }
}
