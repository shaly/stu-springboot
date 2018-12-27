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

	//====================================底层操作方式
	
	@Test
	public void addUser() {
		User user=new User();
		user.setAge(25);
		user.setName("12Jane2");
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		user.setCreateBy(1234567890);
		user.setUpdateBy(9876543);
		user.setUpdateTime(new Date());
		int count = session.update("com.syf.study.mapper.UserMapper.addUser",user);//新增修改删除都用update，不过新增也可以用insert
		session.commit();
		logger.info("新增受影响行数:"+count);
		logger.info("新增返回ID为:"+user.getId());
		System.out.println("新增受影响行数:"+count);
		System.out.println("新增返回ID为:"+user.getId());
	}

	@Test
	public void updateUser() {
		User user=new User();
		user.setId(1000000011);
		user.setAge(25);
		user.setName("Jane1");
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		user.setCreateBy(1234567890);
		user.setUpdateBy(9876543);
		user.setUpdateTime(new Date());
		int count = session.update("com.syf.study.mapper.UserMapper.updateUser",user);//新增修改删除都用update
		session.commit();
		logger.info("修改受影响行数:"+count);
		System.out.println("修改受影响行数:"+count);
	}
	@Test
	public void deleteUser() {
		int count = session.update("com.syf.study.mapper.UserMapper.deleteUser",1000000006);//新增修改删除都用update
		session.commit();
		logger.info("删除受影响行数:"+count);
		System.out.println("删除受影响行数:"+count);
	}
//====================================xml编程
	@Test
	public void updateTestUser() {
		TestUser user=new TestUser();
		user.setAge(25);
		user.setName("你567好");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setClasses("211班");
		user.setId(1000000001);
		int count = session.update("sdfsdf.updateTestUser",user);//新增修改删除都用update，不过新增也可以用insert
		session.commit();
		logger.info("修改影响行数:"+count);
		System.out.println("修改影响行数:"+count);
	}
	

	//====================================接口编程

	@Test
	public void query() {
		//4.获得mapper对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//5.获取代理mapper对象，执行业务
		List<User> users = mapper.queryAll();
		for (int i = 0; i < users.size(); i++) {
			logger.debug(users.get(i).toString());
		}
		
	}


	@Test
	public void curd() {
		User user=new User();
		user.setAge(26);
		user.setName("你1好");
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		user.setCreateBy(1234567890);
		user.setUpdateBy(9876543);
		user.setUpdateTime(new Date());
		UserMapper mapper = session.getMapper(UserMapper.class);
		//c
		mapper.addUser(user);
		logger.info("c:"+user.toString());
		//u
		user.setName("Jane-你好");
		mapper.updateUser(user);
		logger.info("u:"+user.toString());
		//r
		List<User> users = mapper.queryAll();
		for (int i = 0; i < users.size(); i++) {
			logger.debug("r:"+users.get(i).toString());
		}
		//d
	//	int deleteUser = mapper.deleteUser(user.getId());
		session.commit();
	//	logger.info("新增受影响行数:"+deleteUser);
	}
	
	
}
