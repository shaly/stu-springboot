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
		//1.����mybatis-config.xml�ļ���ȥװ�����ݵ�������Ϣ
		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
		//2.��ʼ��sqlsessionFactory����
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//3.��ȡsqlsession�Ự����
		session = sessionFactory.openSession();
	}

	@After
	public void after() {
		//6�ر�session
		session.close();
	}

//==================================== �ײ������ʽ ====================================
	
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
		int count = session.update("com.syf.study.mapper.UserMapper.addUser",user);//�����޸�ɾ������update����������Ҳ������insert
		session.commit();
		logger.info("������Ӱ������:"+count);
		logger.info("��������IDΪ:"+user.getId());
		System.out.println("������Ӱ������:"+count);
		System.out.println("��������IDΪ:"+user.getId());
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
		int count = session.update("com.syf.study.mapper.UserMapper.updateUser",user);//�����޸�ɾ������update
		session.commit();
		logger.info("�޸���Ӱ������:"+count);
		System.out.println("�޸���Ӱ������:"+count);
	}
	@Test
	public void deleteUser() {
		int count = session.update("com.syf.study.mapper.UserMapper.deleteUser",1000000006);//�����޸�ɾ������update
		session.commit();
		logger.info("ɾ����Ӱ������:"+count);
		System.out.println("ɾ����Ӱ������:"+count);
	}
//==================================== xml��� ====================================
	@Test
	public void updateTestUser() {
		TestUser user=new TestUser();
		user.setAge(25);
		user.setName("��567��");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setClasses("211��");
		user.setId(1000000001);
		int count = session.update("sdfsdf.updateTestUser",user);//�����޸�ɾ������update����������Ҳ������insert
		session.commit();
		logger.info("�޸�Ӱ������:"+count);
		System.out.println("�޸�Ӱ������:"+count);
	}
	

//==================================== �ӿڱ�� ====================================

	@Test
	public void query() {
		//4.���mapper����
		UserMapper mapper = session.getMapper(UserMapper.class);
		//5.��ȡ����mapper����ִ��ҵ��
		List<User> users = mapper.queryAll();
		for (int i = 0; i < users.size(); i++) {
			logger.debug(users.get(i).toString());
		}
		
	}

	@Test
	public void queryByPrimaryKey() {
		//4.���mapper����
		UserMapper mapper = session.getMapper(UserMapper.class);
		//5.��ȡ����mapper����ִ��ҵ��
		User users = mapper.queryByPrimaryKey(1000000001);
		logger.info("*****users:"+users.toString());
		User users1 = mapper.queryByPrimaryKey(1000000001);
		logger.info("*****users1:"+users1.toString());

		logger.info("***** ��ʼ�޸� ********");
		User user=new User();
		user.setId(1000000001);
		user.setAge(25);
		user.setName("�������");
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		user.setCreateBy(111222333);
		user.setUpdateBy(333222111);
		user.setUpdateTime(new Date());
		int count = session.update("com.syf.study.mapper.UserMapper.updateUser",user);//�����޸�ɾ������update
		session.commit();
		logger.info("�޸���Ӱ������:"+count);
		logger.info("***** �޸���� ********");
		User users2 = mapper.queryByPrimaryKey(1000000001);
		logger.info("*****users2:"+users2.toString());
		User users3 = mapper.queryByPrimaryKey(1000000001);
		logger.info("*****users3:"+users3.toString());
		
	}
	
	//ʮ�ֲ���ȫ����������
	@Test
	public void queryContent() {
		//4.���mapper����
		UserMapper mapper = session.getMapper(UserMapper.class);
		//5.��ȡ����mapper����ִ��ҵ��
		Map<String, String> queryMap=new HashMap<String, String>();
		queryMap.put("col", "id,name, age, birthday, createtime, updatetime, createby, updateby");
		queryMap.put("tab", "user");
		queryMap.put("where1", "name");
		queryMap.put("param1", "'%tttte%' or 1=1");
		List<User> listUser = mapper.queryContent(queryMap);
		for (User user : listUser) {
			logger.info("*** ���ؽ�� ***:"+user.toString());
		}
		
	}
	
	@Test
	public void curd() {
		User user=new User();
		user.setAge(26);
		user.setName("��1��");
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
		user.setName("Jane-�޸�");
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
	//	logger.info("������Ӱ������:"+deleteUser);
	}
	
	@Test
	public void queryAllCar() {
		//where����where��ѯ��ʽ
		Car queryCar=new Car();
		queryCar.setCarType("����");
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
		queryCar.setCarName("��������001");
		CarMapper mapper = session.getMapper(CarMapper.class);
		List<Car> queryAllChoose = mapper.queryUtile(queryCar);
		for (Car car : queryAllChoose) {
			logger.info("****"+car.toString());
		}
		queryCar.setCarName("��������003");
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
		logger.info("=======================��Ӱ��������"+update);
	}

	@Test
	public void queryForeach() {
		//where����where��ѯ��ʽ
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
			logger.info("bind��ѯ###############"+us.toString());
		}
		
	}

	@Test
	public void queryLikeIngnorBigSmall() {
		User user=new User();
		user.setName("jane-??");
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list=mapper.queryLikeIngnorBigSmall(user);
		for (User us : list) {
			logger.info("���Դ�Сд###############"+us.toString());
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
			logger.info("��������###############"+us.toString());
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
			logger.info("��ҳ###############"+us.toString());
		}
	}
}
