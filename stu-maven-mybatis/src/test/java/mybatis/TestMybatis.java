package mybatis;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.syf.study.bean.Car;
import com.syf.study.bean.TestUser;
import com.syf.study.bean.User;
import com.syf.study.mapper.CarMapper;
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

//==================================== 底层操作方式 ====================================
	
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
//==================================== xml编程 ====================================
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
	

//==================================== 接口编程 ====================================

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
	public void queryByPrimaryKey() {
		//4.获得mapper对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//5.获取代理mapper对象，执行业务
		User users = mapper.queryByPrimaryKey(1000000001);
		logger.info("*****users:"+users.toString());
		User users1 = mapper.queryByPrimaryKey(1000000001);
		logger.info("*****users1:"+users1.toString());

		logger.info("***** 开始修改 ********");
		User user=new User();
		user.setId(1000000001);
		user.setAge(25);
		user.setName("缓存测试");
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		user.setCreateBy(111222333);
		user.setUpdateBy(333222111);
		user.setUpdateTime(new Date());
		int count = session.update("com.syf.study.mapper.UserMapper.updateUser",user);//新增修改删除都用update
		session.commit();
		logger.info("修改受影响行数:"+count);
		logger.info("***** 修改完毕 ********");
		User users2 = mapper.queryByPrimaryKey(1000000001);
		logger.info("*****users2:"+users2.toString());
		User users3 = mapper.queryByPrimaryKey(1000000001);
		logger.info("*****users3:"+users3.toString());
		
	}
	
	//十分不安全！！！！！
	@Test
	public void queryContent() {
		//4.获得mapper对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//5.获取代理mapper对象，执行业务
		Map<String, String> queryMap=new HashMap<String, String>();
		queryMap.put("col", "id,name, age, birthday, createtime, updatetime, createby, updateby");
		queryMap.put("tab", "user");
		queryMap.put("where1", "name");
		queryMap.put("param1", "'%tttte%' or 1=1");
		List<User> listUser = mapper.queryContent(queryMap);
		for (User user : listUser) {
			logger.info("*** 返回结果 ***:"+user.toString());
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
		user.setName("Jane-修改");
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
	
	@Test
	public void queryAllCar() {
		//where三种where查询方式
		Car queryCar=new Car();
		queryCar.setCarType("荣威");
		queryCar.setCreateBy(1);
		CarMapper mapper = session.getMapper(CarMapper.class);
		List<Car> queryAll = mapper.queryAll1(queryCar);
		for (Car car : queryAll) {
			logger.info("11111"+car.toString());
		}
		
		queryAll =mapper.queryAll2(queryCar);
		for (Car car : queryAll) {
			logger.info("22222"+car.toString());
		}
		queryAll =mapper.queryAll3(queryCar);
		for (Car car : queryAll) {
			logger.info("33333"+car.toString());
		}
		
	}

	@Test
	public void queryChoose() {
		Car queryCar=new Car();
		queryCar.setStatus(4);
		CarMapper mapper = session.getMapper(CarMapper.class);
		List<Car> queryAllChoose = mapper.queryAllChoose(queryCar);
		for (Car car : queryAllChoose) {
			logger.info("****"+car.toString());
		}
		queryCar.setStatus(1);
		queryAllChoose = mapper.queryAllChoose(queryCar);
		for (Car car : queryAllChoose) {
			logger.info("****"+car.toString());
		}
	}
	
	@Test
	public void queryUtile() {
		Car queryCar=new Car();
		queryCar.setCarName("荣威二代001");
		CarMapper mapper = session.getMapper(CarMapper.class);
		List<Car> queryAllChoose = mapper.queryUtile(queryCar);
		for (Car car : queryAllChoose) {
			logger.info("****"+car.toString());
		}
		queryCar.setCarName("荣威二代003");
		queryAllChoose = mapper.queryUtile(queryCar);
		for (Car car : queryAllChoose) {
			logger.info("****"+car.toString());
		}
	}
	
	@Test	
	public void update() {
		Car upCar=new Car();
		upCar.setCarName("asdf");
		upCar.setId(1000000001);
		CarMapper mapper = session.getMapper(CarMapper.class);
		int update = mapper.update(upCar);
		session.commit();
		logger.info("=======================受影响行数："+update);
	}

	@Test
	public void queryForeach() {
		//where三种where查询方式
		Car queryCar=new Car();
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(3);
		queryCar.setStatusList(list);
		CarMapper mapper = session.getMapper(CarMapper.class);
		List<Car> queryAll = mapper.queryForeach(queryCar);
		for (Car car : queryAll) {
			logger.info("###############"+car.toString());
		}
		
	}
	
	@Test
	public void queryLike() {
		User user=new User();
		user.setName("Jane-");
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list=mapper.queryLike(user);
		for (User us : list) {
			logger.info("bind查询###############"+us.toString());
		}
		
	}

	@Test
	public void queryLikeIngnorBigSmall() {
		User user=new User();
		user.setName("jane-??");
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list=mapper.queryLikeIngnorBigSmall(user);
		for (User us : list) {
			logger.info("忽略大小写###############"+us.toString());
		}
		
	}


	@Test
	public void updateNow() {
		User user=new User();
		user.setId(1000000002);
		user.setName("janenow");
		UserMapper mapper = session.getMapper(UserMapper.class);
		int c=mapper.updateUser(user);
		logger.info("updateNow###############"+c);
		session.commit();
	}

	@Test
	public void queryByAge() {
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list=mapper.queryByAge(26);
		for (User us : list) {
			logger.info("参数命名###############"+us.toString());
		}
	}

	@Test
	public void queryPage() {
		User user=new User();
		user.setStartNo(0);
		user.setEndNo(100);
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list=mapper.queryPage(user);
		for (User us : list) {
			logger.info("分页###############"+us.toString());
		}
	}
}
