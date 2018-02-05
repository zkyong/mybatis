import java.io.Reader;
import java.text.MessageFormat;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.dao.UserMapper;
import com.yiibai.mybatis.models.Post;
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
			//������ѯ
			testSelecOne2Many();
		} finally {
			session.close();
		}
	}

	// ������ѯ
	public static void testSelecOne2Many() {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			UserMapper iuser = session.getMapper(UserMapper.class);
			System.out.println("Test select start...");
			printUsers(iuser.selectOne2Many(1));
			System.out.println("Test select finished...");
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
			if(user.getPosts() != null && user.getPosts().size() != 0){
				for (Post post : user.getPosts()) {
					System.out.println("----post begin----");
					System.out.println(post.toString());
					System.out.println("----post end------");
				}
			}
			System.out.println("======================================");
		}
	}
}