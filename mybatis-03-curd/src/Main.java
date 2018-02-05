import java.io.Reader;
import java.text.MessageFormat;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.dao.UserMapper;
import com.yiibai.mybatis.models.User;

public class Main {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("config/Configure.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// �û������б�
			selectList();
			
			// ��������
			testInsert();
			
			// ��������
			testUpdate();
			
			// ɾ������
			testDelete();
		} finally {
			session.close();
		}
	}

	// �����û���Ϣ
	public static void testInsert() {
		try {
			// ��ȡSession����
			SqlSession session = sqlSessionFactory.openSession();
			// ��ȡMapper
			UserMapper userMapper = session.getMapper(UserMapper.class);
			System.out.println("Test insert start...");
			// ִ�в���
			User user = new User();
			user.setId(0);
			user.setName("Google");
			user.setDept("Tech");
			user.setWebsite("http://www.google.com");
			user.setPhone("120");
			userMapper.insert(user);
			// �ύ����
			session.commit();

			// ��ʾ����֮��User��Ϣ
			System.out.println("After insert");
			selectList();
			System.out.println("Test insert finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��ȡ�û��б�
	public static void selectList() {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			UserMapper iuser = session.getMapper(UserMapper.class);
			// ��ʾUser��Ϣ
			System.out.println("Test Get start...");
			printUsers(iuser.selectList());
			System.out.println("Test Get finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �����û���Ϣ
	public static void testUpdate() {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			UserMapper iuser = session.getMapper(UserMapper.class);
			System.out.println("Test update start...");
			printUsers(iuser.selectList());
			// ִ�и���
			User user = iuser.selectByPrimaryKey(0);
			user.setName("New name");
			iuser.update(user);
			// �ύ����
			session.commit();
			// ��ʾ����֮��User��Ϣ
			System.out.println("After update");
			printUsers(iuser.selectList());
			System.out.println("Test update finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ɾ���û���Ϣ
	public static void testDelete() {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			UserMapper iuser = session.getMapper(UserMapper.class);
			System.out.println("Test delete start...");
			// ��ʾɾ��֮ǰUser��Ϣ
			System.out.println("Before delete");
			printUsers(iuser.selectList());
			// ִ��ɾ��
			iuser.deleteByPrimaryKey(0);
			// �ύ����
			session.commit();
			// ��ʾɾ��֮��User��Ϣ
			System.out.println("After delete");
			printUsers(iuser.selectList());
			System.out.println("Test delete finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ��ӡ�û���Ϣ������̨
	private static void printUsers(final List<User> users) {
		int count = 0;
		for (User user : users) {
			System.out.println(MessageFormat.format("============= User[{0}]=================", ++count));
			System.out.println("User Id: " + user.getId());
			System.out.println("User Name: " + user.getName());
			System.out.println("User Dept: " + user.getDept());
			System.out.println("User Phone: " + user.getPhone());
			System.out.println("User Website: " + user.getWebsite());
		}
	}
}