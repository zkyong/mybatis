import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.mapper.GroupMapper;
import com.yiibai.mybatis.mapper.UserGroupMapper;
import com.yiibai.mybatis.mapper.UserMapper;
import com.yiibai.mybatis.models.Group;
import com.yiibai.mybatis.models.User;
import com.yiibai.mybatis.models.UserGroup;

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
		// testInsertGroup();
		// testInsertUser();
		// testInsertUserGroup();
		testGetGroupAndUsers();
		testGetUserAndGroups();
	}

	public static void testInsertUser() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			User record = new User();
			record.setUserId(10);
			record.setUserName("张一");
			record.setUserDept("销售部");
			record.setUserPhone("13838009988");
			record.setUserWebsite("www.zhangyi.com");
			UserMapper userMapper = session.getMapper(UserMapper.class);
			userMapper.insert(record);
			session.commit();
		} finally {
			session.close();
		}
	}

	public static void testInsertGroup() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Group record = new Group();
			record.setGroupId(1);
			record.setGroupName("用户组-1");
			GroupMapper groupMapper = session.getMapper(GroupMapper.class);
			groupMapper.insert(record);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public static void testInsertUserGroup() {
		UserGroup record = new UserGroup();
		record.setGroupId(1);
		record.setUserId(2);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserGroupMapper userGroupMaper = session.getMapper(UserGroupMapper.class);
			userGroupMaper.insert(record);
			session.commit();
		} finally {
			session.close();
		}

	}

	public static void testGetGroupAndUsers() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			GroupMapper groupMapper = session.getMapper(GroupMapper.class);
			Group group = groupMapper.selectGroupById(1);
			System.out.println(group);
		} finally {
			session.close();
		}
	}
	
	public static void testGetUserAndGroups() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			User user = userMapper.selectUserById(1);
			System.out.println(user);
		} finally {
			session.close();
		}
	}
}