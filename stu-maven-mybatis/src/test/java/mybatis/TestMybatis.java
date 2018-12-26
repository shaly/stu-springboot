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

	@Test
	public void test() {
		//4.���mapper����
		UserMapper mapper = session.getMapper(UserMapper.class);
		//5.��ȡ����mapper����ִ��ҵ��
		List<User> users = mapper.queryAll();
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).toString());
		}
		
	}
	
}
