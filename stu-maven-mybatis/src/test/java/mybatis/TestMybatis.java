package mybatis;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.syf.study.bean.User;
import com.syf.study.mapper.UserMapper;

public class TestMybatis {
	private SqlSession session ;

	@Before
	public void before() throws IOException {
		//1.加载mybatis-config.xml文件，去装配数据的连接信息
		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
		//2.初始化sqlsessionFactory对象
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//3.获取sqlsession会话对象
		session = sessionFactory.openSession();
	}

	@After
	public void after() {
		//6关闭session
		session.close();
	}

	@Test
	public void test() {
		//4.获得mapper对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//5.获取代理mapper对象，执行业务
		List<User> users = mapper.queryAll();
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).toString());
		}
		
	}
	
}
