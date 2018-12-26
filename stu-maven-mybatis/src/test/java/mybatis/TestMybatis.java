package mybatis;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.syf.study.bean.TestUser;
import com.syf.study.bean.User;
import com.syf.study.mapper.UserMapper;

public class TestMybatis {
	
	private Logger logger=Logger.getLogger(TestMybatis.class);
	
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

//	@Test
//	public void test() {
//		//4.获得mapper对象
//		UserMapper mapper = session.getMapper(UserMapper.class);
//		//5.获取代理mapper对象，执行业务
//		List<User> users = mapper.queryAll();
//		for (int i = 0; i < users.size(); i++) {
//			logger.debug(users.get(i).toString());
//		}
//		
//	}

	@Test
	public void addUser() {
		User user=new User();
		user.setAge(25);
		user.setName("Jane");
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		user.setCreateBy(1234567890);
		user.setUpdateBy(9876543);
		user.setUpdateTime(new Date());
		int count = session.update("com.syf.study.mapper.UserMapper.addUser",user);//新增修改删除都用update
		session.commit();
		logger.info("受影响行数:"+count);
		logger.info("返回ID为:"+user.getId());
		System.out.println("受影响行数:"+count);
		System.out.println("返回ID为:"+user.getId());
	}
	

	@Test
	public void updateTestUser() {
		TestUser user=new TestUser();
		user.setAge(25);
		user.setName("Jane");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setClasses("227班");
		user.setId(1000000001);
		int count = session.update("sdfsdf.updateTestUser",user);//新增修改删除都用update
		session.commit();
		logger.info("修改影响行数:"+count);
		System.out.println("修改影响行数:"+count);
	}
	
	
	
	
}
