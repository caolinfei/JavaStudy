import com.study.dao.IPersonDao;
import com.study.domian.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PersonAnnotionTest {

    public IPersonDao dao;

    @Before
    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        dao = sqlSession.getMapper(IPersonDao.class);
    }

    @Test
    public void findAll() {
        List<Person> all = dao.findAll();
        System.out.println(all);

    }
}
