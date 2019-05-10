import com.study.dao.IAccountDao;
import com.study.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;

public class MybatisBaseTest {

    public IUserDao userDao;
    public IAccountDao accountDao;
    public SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("SqlMapConfig.xml"));
        sqlSession = build.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
        accountDao=sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void  destroy()
    {
        sqlSession.commit();
        sqlSession.close();
    }
}
