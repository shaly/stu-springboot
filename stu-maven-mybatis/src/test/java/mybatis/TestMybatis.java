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
		//1.����mybatis-config.xml�ļ���ȥװ�����ݵ�������Ϣ
		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
		//2.��ʼ��sqlsessionFactory����
		sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//3.��ȡsqlsession�Ự����
		session = sessionFactory.openSession();
	}

	@After
	public void after() {
		//6�ر�session
		session.close();
	}

//==================================== �ײ������ʽ ====================================
	
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
		int count = session.update("com.syf.study.mapper.UserMapper.addUser",user);//�����޸�ɾ������update����������Ҳ������insert
		session.commit();
		logger.info("������Ӱ������:"+count);
		logger.info("��������IDΪ:"+user.getId());
		System.out.println("������Ӱ������:"+count);
		System.out.println("��������IDΪ:"+user.getId());
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
		int count = session.update("com.syf.study.mapper.UserMapper.updateUser",user);//�����޸�ɾ������update
		session.commit();
		logger.info("�޸���Ӱ������:"+count);
		System.out.println("�޸���Ӱ������:"+count);
	}
	//@Test
	public void deleteUser() {
		int count = session.update("com.syf.study.mapper.UserMapper.deleteUser",1000000006);//�����޸�ɾ������update
		session.commit();
		logger.info("ɾ����Ӱ������:"+count);
		System.out.println("ɾ����Ӱ������:"+count);
	}
//==================================== xml��� ====================================
	//@Test
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

	//@Test
	public void query() {
		//4.���mapper����
		UserMapper mapper = session.getMapper(UserMapper.class);
		//5.��ȡ����mapper����ִ��ҵ��
		List<User> users = mapper.queryAll();
		for (int i = 0; i < users.size(); i++) {
			logger.debug(users.get(i).toString());
		}
		
	}

	//@Test
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
	//@Test
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
	//����ɾ�Ĳ�
	//@Test
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

	//where����where��ѯ��ʽ
	//@Test
	public void queryAllCar() {
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
	//choose��ѯ
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
	
	//�����������ж�
	//@Test
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
	
	//@Test	
	public void update() {
		Car upCar=new Car();
		upCar.setCarName("asdf");
		upCar.setId(1000000001);
		CarMapper mapper = session.getMapper(CarMapper.class);
		int update = mapper.update(upCar);
		session.commit();
		logger.info("=======================��Ӱ��������"+update);
	}

	//ѭ������
	//@Test
	public void queryForeach() {
		//where����where��ѯ��ʽ
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
	//ģ����ѯbind��%%
	//@Test
	public void queryLike() {
		User user=new User();
		user.setName("Jane-");
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list=mapper.queryLike(user);
		for (User us : list) {
			logger.info("bind��ѯ###############"+us.toString());
		}
		
	}

	//ģ����ѯ���Դ�Сд
	//@Test
	public void queryLikeIngnorBigSmall() {
		User user=new User();
		user.setName("jane-??");
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list=mapper.queryLikeIngnorBigSmall(user);
		for (User us : list) {
			logger.info("���Դ�Сд###############"+us.toString());
		}
		
	}


	//�޸����ݣ���¼��ǰʱ��
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

	//���������
	//@Test
	public void queryByAge() {
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list=mapper.queryByAge(26);
		for (User us : list) {
			logger.info("��������###############"+us.toString());
		}
	}

	//��ҳ
	//@Test
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
	

	//�洢����
	//@Test
	public void callQueryById() {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u=mapper.callQueryById(1000000001);
		logger.info("��ҳ###############"+u.toString());
	}
	

	//����
	//@Test
	public void transaction() {
		//ԭ���ԣ��л�����Ԫ������ת��ʱ��ǮȡǮ��һ����Ԫ����
		//������(��ת�˺���ת�˻���Ӱ��)
		//һ���ԣ�Ҫô�ɹ�Ҫôʧ�ܡ��ɹ�һ��ɹ���ʧ��һ��ʧ�ܣ�
		//�־��ԣ�һ���ύ�ɹ���������Ч����
		User user=new User();
		user.setAge(25);
		user.setName("22���Բ�������");
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		user.setCreateBy(1234567890);
		user.setUpdateBy(9876543);
		user.setUpdateTime(new Date());
		int count = session.update("com.syf.study.mapper.UserMapper.addUser",user);//�����޸�ɾ������update����������Ҳ������insert
		UserMapper mapper = session.getMapper(UserMapper.class);
		//����δ�ύ����mapper��sqlsession�����в鵽��δ�ύ������
		List<User> list = mapper.queryAll();
		for (User us : list) {
			logger.info(count+"����###############"+us.toString());
		}
		
		
		
		//session.commit();
		
	}

	//mybatis��һ���������
	//@Test
	public void querySqlSession() {
		//һ�����棺Sqlsession	Ĭ���ǿ�����
		//private SqlSession session ;
		
		//session���ص�ǰ���£�ͬ���Ĳ�����ѯ���֮��ִ��һ��
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		//sqlsession�ײ���ʵ��һ��Hashmap,������key,������value
		User q1 = mapper.queryByPrimaryKey(1000000001);
		System.out.println("q1="+q1.toString());
		User q2 = mapper.queryByPrimaryKey(1000000001);
		System.out.println("q2="+q2.toString());
		User q3 = mapper.queryByPrimaryKey(1000000002);
		System.out.println("q3="+q3.toString());
		User q4 = mapper.queryByPrimaryKey(1000000001);
		System.out.println("q4="+q4.toString());
		//���mybatis����
		session.clearCache();
		User q5 = mapper.queryByPrimaryKey(1000000001);
		System.out.println("q5="+q5.toString());
	}
	
	//mybatis�Ķ����������,(ehcacheҲ�������������)
	//@Test
	public void queryCachEnable() {
		//�������棺Sqlsession	Ĭ���ǹرյģ���Ҫ�������ļ��д�
		//private SqlSession session ;
		
		//һ�������ִ�н�����ڶ���������Ĭ�ϱ���һ��,
		//��һ�β�ѯsqlsession����Ҳû��ϵ������sqlsession��ȥ����������ȥ��֮ǰ���ݵ�
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		//sqlsession�ײ���ʵ��һ��Hashmap,������key,������value
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
	//һ��һӳ��
	//@Test
	public void onebyone() {
		//�������棺Sqlsession	Ĭ���ǹرյģ���Ҫ�������ļ��д�
		//private SqlSession session ;
		
		//һ�������ִ�н�����ڶ���������Ĭ�ϱ���һ��,
		//��һ�β�ѯsqlsession����Ҳû��ϵ������sqlsession��ȥ����������ȥ��֮ǰ���ݵ�
		MybatisStudentMapper mapper = session.getMapper(MybatisStudentMapper.class);
		
		//sqlsession�ײ���ʵ��һ��Hashmap,������key,������value
		MybatisStudent q1 = mapper.queryById(100001);
		System.out.println("q1="+q1.toString());
		session.close();
	}
	

	//һ��һӳ��,���sql���һ�������һ���������ID��ѯһ���study_class
	//�����ʽ�������ӳټ��أ��õ��ټ��أ�û�õ�������
	//@Test
	public void onebyoneSql() {
		//�������棺Sqlsession	Ĭ���ǹرյģ���Ҫ�������ļ��д�
		//private SqlSession session ;
		
		//һ�������ִ�н�����ڶ���������Ĭ�ϱ���һ��,
		//��һ�β�ѯsqlsession����Ҳû��ϵ������sqlsession��ȥ����������ȥ��֮ǰ���ݵ�
		MybatisStudentMapper mapper = session.getMapper(MybatisStudentMapper.class);
		
		//sqlsession�ײ���ʵ��һ��Hashmap,������key,������value
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
	
	//һ�Զ��ϵ
	//@Test
	public void oneByMore() {
		MybatisClassMapper mapper = session.getMapper(MybatisClassMapper.class);
		
		//sqlsession�ײ���ʵ��һ��Hashmap,������key,������value
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

	//һ�Զ��ϵ
	@Test
	public void oneByMoreUserOrders() {
		MybatisStudentMapper mapper = session.getMapper(MybatisStudentMapper.class);
		
		//sqlsession�ײ���ʵ��һ��Hashmap,������key,������value
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

	//��Զ��ϵ
	@Test
	public void queryCourseByOrderId() {
		MybatisOrderMapper mapper = session.getMapper(MybatisOrderMapper.class);
		
		//sqlsession�ײ���ʵ��һ��Hashmap,������key,������value
		MybatisOrder ordAndCourse = mapper.queryOrderAndCourse(100001);
		List<MybatisCourse> courses = ordAndCourse.getCourses();
		for(MybatisCourse c:courses) {
			System.out.println("******="+c);
		}
		String jsonString = JSON.toJSONString(ordAndCourse);
		System.out.println("******="+jsonString);
		session.close();
	}
	//ӳ���ϵ�ܽ᡾������á�
	//����ά����������⣬Ӱ������
	


	//=================================================ע���ѯ
	//��ѯ
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
	//����
	@Test
	public void annotationAdd() {
		User user=new User();
		user.setAge(25);
		user.setName("333���Բ�������");
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		user.setCreateBy(1234567890);
		user.setUpdateBy(9876543);
		user.setUpdateTime(new Date());
		AnnotationUserMapper mapper = session.getMapper(AnnotationUserMapper.class);
		int count = mapper.addUser(user);
		session.commit();
		System.out.println("����������Ӧ�����"+count);
		System.out.println("��������ID��"+user.getId());
	}
	//�޸�
	@Test
	public void annotationUp() {
		User user=new User();
		user.setId(1000000059);
		user.setAge(25);
		user.setName("666���Բ�������");
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		user.setCreateBy(8765432);
		user.setUpdateBy(9876543);
		user.setUpdateTime(new Date());
		AnnotationUserMapper mapper = session.getMapper(AnnotationUserMapper.class);
		int count = mapper.updateUser(user);
		session.commit();
		System.out.println("�޸ķ�����Ӧ�����"+count);
	}
	//ɾ��
	@Test
	public void annotationDel() {
		User user=new User();
		AnnotationUserMapper mapper = session.getMapper(AnnotationUserMapper.class);
		int count = mapper.deleteUser(1000000059);
		session.commit();
		System.out.println("ɾ��������Ӧ�����"+count);
	}
	//��ѯ����ָ����
	@Test
	public void annotationContent() {
		AnnotationUserMapper mapper = session.getMapper(AnnotationUserMapper.class);
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
	//========================���췽ʽ
	//��ѯ
	@Test
	public void queryWithProvider() {
		User user=new User();
		user.setAge(25);
		user.setName("�������");
		user.setCreateBy(1);
		AnnotationUserMapper mapper = session.getMapper(AnnotationUserMapper.class);
		List<User> list = mapper.queryWithProvider(user);
		
		for (User u : list) {
			logger.info("*** ���ؽ�� ***:"+u.toString());
		}
		
		logger.info("**********************************");
		User queryWithProviderId = mapper.queryWithProviderId(1000000001);

		logger.info("****queryWithProviderId"+queryWithProviderId.toString());
		
		
	}
	//����
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
		System.out.println("**********Ӱ��������"+count);
		System.out.println("**********����ID��"+user.getId());
	}
	//�޸�
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
		System.out.println("**********Ӱ��������"+count);
		
	}
	//ɾ��
	@Test
	public void delWithProvider() {
		AnnotationUserMapper mapper = session.getMapper(AnnotationUserMapper.class);
		int count=mapper.delWithProvider(1000000058);
		session.commit();
		System.out.println("**********Ӱ��������"+count);
		
	}
	
}
