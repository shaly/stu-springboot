package mybatis;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.AbstractDocument.Content;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.jaxrs.FastJsonFeature;
import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import com.syf.study.bean.Car;
import com.syf.study.bean.MybatisClass;
import com.syf.study.bean.MybatisCourse;
import com.syf.study.bean.MybatisOrder;
import com.syf.study.bean.MybatisStudent;
import com.syf.study.bean.TestUser;
import com.syf.study.bean.User;
import com.syf.study.mapper.AnnotationUserMapper;
import com.syf.study.mapper.CarMapper;
import com.syf.study.mapper.MybatisClassMapper;
import com.syf.study.mapper.MybatisCourseMapper;
import com.syf.study.mapper.MybatisOrderMapper;
import com.syf.study.mapper.MybatisStudentMapper;
import com.syf.study.mapper.UserMapper;

public class TestMybatis {
	
	private Logger logger=Logger.getLogger(TestMybatis.class);
	
	private SqlSession session ;
	private SqlSessionFactory sessionFactory ;
	@Before
	public void before() throws IOException {
		//1.加载mybatis-config.xml文件，去装配数据的连接信息
		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
		//2.初始化sqlsessionFactory对象
		sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//3.获取sqlsession会话对象
		session = sessionFactory.openSession();
	}

	@After
	public void after() {
		//6关闭session
		session.close();
	}

//==================================== 底层操作方式 ====================================
	
	//@Test
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

	//@Test
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
	//@Test
	public void deleteUser() {
		int count = session.update("com.syf.study.mapper.UserMapper.deleteUser",1000000006);//新增修改删除都用update
		session.commit();
		logger.info("删除受影响行数:"+count);
		System.out.println("删除受影响行数:"+count);
	}
//==================================== xml编程 ====================================
	//@Test
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

	//@Test
	public void query() {
		//4.获得mapper对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//5.获取代理mapper对象，执行业务
		List<User> users = mapper.queryAll();
		for (int i = 0; i < users.size(); i++) {
			logger.debug(users.get(i).toString());
		}
		
	}

	//@Test
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
	//@Test
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
	//简单增删改查
	//@Test
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

	//where三种where查询方式
	//@Test
	public void queryAllCar() {
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
	//choose查询
	//@Test
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
	
	//工具类条件判断
	//@Test
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
	
	//@Test	
	public void update() {
		Car upCar=new Car();
		upCar.setCarName("asdf");
		upCar.setId(1000000001);
		CarMapper mapper = session.getMapper(CarMapper.class);
		int update = mapper.update(upCar);
		session.commit();
		logger.info("=======================受影响行数："+update);
	}

	//循环参数
	//@Test
	public void queryForeach() {
		//where三种where查询方式
	/*	Car queryCar=new Car();
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(3);
		queryCar.setStatusList(list);
		CarMapper mapper = session.getMapper(CarMapper.class);
		List<Car> queryAll = mapper.queryForeach(queryCar);
		for (Car car : queryAll) {
			logger.info("###############"+car.toString());
		}*/
		
	}
	//模糊查询bind绑定%%
	//@Test
	public void queryLike() {
		User user=new User();
		user.setName("Jane-");
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list=mapper.queryLike(user);
		for (User us : list) {
			logger.info("bind查询###############"+us.toString());
		}
		
	}

	//模糊查询忽略大小写
	//@Test
	public void queryLikeIngnorBigSmall() {
		User user=new User();
		user.setName("jane-??");
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list=mapper.queryLikeIngnorBigSmall(user);
		for (User us : list) {
			logger.info("忽略大小写###############"+us.toString());
		}
		
	}


	//修改数据，记录当前时间
	//@Test
	public void updateNow() {
		User user=new User();
		user.setId(1000000002);
		user.setName("janenow");
		UserMapper mapper = session.getMapper(UserMapper.class);
		int c=mapper.updateUser(user);
		logger.info("updateNow###############"+c);
		session.commit();
	}

	//定义参数名
	//@Test
	public void queryByAge() {
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list=mapper.queryByAge(26);
		for (User us : list) {
			logger.info("参数命名###############"+us.toString());
		}
	}

	//分页
	//@Test
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
	

	//存储过程
	//@Test
	public void callQueryById() {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u=mapper.callQueryById(1000000001);
		logger.info("分页###############"+u.toString());
	}
	

	//事务
	//@Test
	public void transaction() {
		//原子性（有基本单元，比如转账时存钱取钱是一个单元）、
		//隔离性(我转账和你转账互不影响)
		//一致性（要么成功要么失败。成功一起成功，失败一起失败）
		//持久性（一旦提交成功，立即生效）、
		User user=new User();
		user.setAge(25);
		user.setName("22测试测试事务");
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		user.setCreateBy(1234567890);
		user.setUpdateBy(9876543);
		user.setUpdateTime(new Date());
		int count = session.update("com.syf.study.mapper.UserMapper.addUser",user);//新增修改删除都用update，不过新增也可以用insert
		UserMapper mapper = session.getMapper(UserMapper.class);
		//事务未提交，但mapper从sqlsession缓存中查到了未提交的数据
		List<User> list = mapper.queryAll();
		for (User us : list) {
			logger.info(count+"事务###############"+us.toString());
		}
		
		
		
		//session.commit();
		
	}

	//mybatis的一级缓存机制
	//@Test
	public void querySqlSession() {
		//一级缓存：Sqlsession	默认是开启的
		//private SqlSession session ;
		
		//session不关的前提下，同样的参数查询语句之后执行一次
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		//sqlsession底层其实是一个Hashmap,参数是key,内容是value
		User q1 = mapper.queryByPrimaryKey(1000000001);
		System.out.println("q1="+q1.toString());
		User q2 = mapper.queryByPrimaryKey(1000000001);
		System.out.println("q2="+q2.toString());
		User q3 = mapper.queryByPrimaryKey(1000000002);
		System.out.println("q3="+q3.toString());
		User q4 = mapper.queryByPrimaryKey(1000000001);
		System.out.println("q4="+q4.toString());
		//清除mybatis缓存
		session.clearCache();
		User q5 = mapper.queryByPrimaryKey(1000000001);
		System.out.println("q5="+q5.toString());
	}
	
	//mybatis的二级缓存机制,(ehcache也可以用这个测试)
	//@Test
	public void queryCachEnable() {
		//二级缓存：Sqlsession	默认是关闭的，需要在配置文件中打开
		//private SqlSession session ;
		
		//一级缓存的执行结果会在二级缓存中默认备份一份,
		//第一次查询sqlsession关了也没关系，其他sqlsession会去二级缓存中去找之前备份的
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		//sqlsession底层其实是一个Hashmap,参数是key,内容是value
		User q1 = mapper.queryByPrimaryKey(1000000001);
		System.out.println("q1="+q1.toString());
		session.close();
		
		session=sessionFactory.openSession();
		mapper = session.getMapper(UserMapper.class);
		User q2 = mapper.queryByPrimaryKey(1000000001);
		System.out.println("q2="+q2.toString());
		session.close();

		
		session=sessionFactory.openSession();
		mapper = session.getMapper(UserMapper.class);
		User q3 = mapper.queryByPrimaryKey(1000000002);
		System.out.println("q3="+q3.toString());
		session.close();
		
		session=sessionFactory.openSession();
		mapper = session.getMapper(UserMapper.class);
		User q4 = mapper.queryByPrimaryKey(1000000001);
		System.out.println("q4="+q4.toString());
		session.close();
		
	}
	//一对一映射
	//@Test
	public void onebyone() {
		//二级缓存：Sqlsession	默认是关闭的，需要在配置文件中打开
		//private SqlSession session ;
		
		//一级缓存的执行结果会在二级缓存中默认备份一份,
		//第一次查询sqlsession关了也没关系，其他sqlsession会去二级缓存中去找之前备份的
		MybatisStudentMapper mapper = session.getMapper(MybatisStudentMapper.class);
		
		//sqlsession底层其实是一个Hashmap,参数是key,内容是value
		MybatisStudent q1 = mapper.queryById(100001);
		System.out.println("q1="+q1.toString());
		session.close();
	}
	

	//一对一映射,解决sql多对一，如果有一万条则根据ID查询一万次study_class
	//解决方式：进行延迟加载，用到再加载，没用到不加载
	//@Test
	public void onebyoneSql() {
		//二级缓存：Sqlsession	默认是关闭的，需要在配置文件中打开
		//private SqlSession session ;
		
		//一级缓存的执行结果会在二级缓存中默认备份一份,
		//第一次查询sqlsession关了也没关系，其他sqlsession会去二级缓存中去找之前备份的
		MybatisStudentMapper mapper = session.getMapper(MybatisStudentMapper.class);
		
		//sqlsession底层其实是一个Hashmap,参数是key,内容是value
		List<MybatisStudent> list = mapper.queryAll();
		MybatisStudent m =null;
		for (int i=0;i<list.size();i++) {
			if(i%2==0) {
				m=list.get(i);
				System.out.println(i+"******="+m.toString());
			}
		}
		session.close();
	}
	
	//一对多关系
	//@Test
	public void oneByMore() {
		MybatisClassMapper mapper = session.getMapper(MybatisClassMapper.class);
		
		//sqlsession底层其实是一个Hashmap,参数是key,内容是value
		MybatisClass cla = mapper.queryById2(100001);
		List<MybatisStudent> users = cla.getUsers();
		System.out.println("******="+cla.toString());
		MybatisStudent m =null;
		for (int i=0;i<users.size();i++) {
			m=users.get(i);
			System.out.println(i+"******="+m.toString());
		}
		session.close();
	}

	//一对多关系
	@Test
	public void oneByMoreUserOrders() {
		MybatisStudentMapper mapper = session.getMapper(MybatisStudentMapper.class);
		
		//sqlsession底层其实是一个Hashmap,参数是key,内容是value
		MybatisStudent cla = mapper.queryUserOrdersByUserId(100001);
		List<MybatisOrder> orders = cla.getMybatisOrders();
		MybatisOrder m =null;
		for (int i=0;i<orders.size();i++) {
			m=orders.get(i);
			System.out.println(i+"******="+m.toString());
		}
		String jsonString = JSON.toJSONString(cla);
		System.out.println("******="+jsonString);
		session.close();
	}

	//多对多关系
	@Test
	public void queryCourseByOrderId() {
		MybatisOrderMapper mapper = session.getMapper(MybatisOrderMapper.class);
		
		//sqlsession底层其实是一个Hashmap,参数是key,内容是value
		MybatisOrder ordAndCourse = mapper.queryOrderAndCourse(100001);
		List<MybatisCourse> courses = ordAndCourse.getCourses();
		for(MybatisCourse c:courses) {
			System.out.println("******="+c);
		}
		String jsonString = JSON.toJSONString(ordAndCourse);
		System.out.println("******="+jsonString);
		session.close();
	}
	//映射关系总结【最好少用】
	//不好维护，不好理解，影响性能
	


	//=================================================注解查询
	//查询
	@Test
	public void annotationQuery() {
		AnnotationUserMapper mapper = session.getMapper(AnnotationUserMapper.class);
		List<User> queryAll = mapper.queryAll();
		for(User q:queryAll) {
			System.out.println("******="+q);
		}
		String jsonString = JSON.toJSONString(queryAll);
		System.out.println("******="+jsonString);
		session.close();
	}
	//新增
	@Test
	public void annotationAdd() {
		User user=new User();
		user.setAge(25);
		user.setName("333测试测试事务");
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		user.setCreateBy(1234567890);
		user.setUpdateBy(9876543);
		user.setUpdateTime(new Date());
		AnnotationUserMapper mapper = session.getMapper(AnnotationUserMapper.class);
		int count = mapper.addUser(user);
		session.commit();
		System.out.println("新增返回响应结果："+count);
		System.out.println("新增返回ID："+user.getId());
	}
	//修改
	@Test
	public void annotationUp() {
		User user=new User();
		user.setId(1000000059);
		user.setAge(25);
		user.setName("666测试测试事务");
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		user.setCreateBy(8765432);
		user.setUpdateBy(9876543);
		user.setUpdateTime(new Date());
		AnnotationUserMapper mapper = session.getMapper(AnnotationUserMapper.class);
		int count = mapper.updateUser(user);
		session.commit();
		System.out.println("修改返回响应结果："+count);
	}
	//删除
	@Test
	public void annotationDel() {
		User user=new User();
		AnnotationUserMapper mapper = session.getMapper(AnnotationUserMapper.class);
		int count = mapper.deleteUser(1000000059);
		session.commit();
		System.out.println("删除返回响应结果："+count);
	}
	//查询参数指定列
	@Test
	public void annotationContent() {
		AnnotationUserMapper mapper = session.getMapper(AnnotationUserMapper.class);
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
	//========================构造方式
	//查询
	@Test
	public void queryWithProvider() {
		User user=new User();
		user.setAge(25);
		user.setName("缓存测试");
		user.setCreateBy(1);
		AnnotationUserMapper mapper = session.getMapper(AnnotationUserMapper.class);
		List<User> list = mapper.queryWithProvider(user);
		
		for (User u : list) {
			logger.info("*** 返回结果 ***:"+u.toString());
		}
		
		logger.info("**********************************");
		User queryWithProviderId = mapper.queryWithProviderId(1000000001);

		logger.info("****queryWithProviderId"+queryWithProviderId.toString());
		
		
	}
	//新增
	@Test
	public void addWithProvider() {
		User user=new User();
		user.setAge(25);
		user.setName("*addWithProvider");
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		user.setCreateBy(8765432);
		user.setUpdateBy(9876543);
		user.setUpdateTime(new Date());
		AnnotationUserMapper mapper = session.getMapper(AnnotationUserMapper.class);
		int count=mapper.addWithProvider(user);
		session.commit();
		System.out.println("**********影响行数："+count);
		System.out.println("**********返回ID："+user.getId());
	}
	//修改
	@Test
	public void updateWithProvider() {
		User user=new User();
		user.setId(1000000049);
		user.setAge(25);
		user.setName("updateWithProvider");
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		user.setCreateBy(8765432);
		user.setUpdateBy(9876543);
		user.setUpdateTime(new Date());
		AnnotationUserMapper mapper = session.getMapper(AnnotationUserMapper.class);
		int count=mapper.updateWithProvider(user);
		session.commit();
		System.out.println("**********影响行数："+count);
		
	}
	//删除
	@Test
	public void delWithProvider() {
		AnnotationUserMapper mapper = session.getMapper(AnnotationUserMapper.class);
		int count=mapper.delWithProvider(1000000058);
		session.commit();
		System.out.println("**********影响行数："+count);
		
	}
	
}
