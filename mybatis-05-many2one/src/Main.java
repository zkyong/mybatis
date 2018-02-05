import java.io.Reader;
import java.text.MessageFormat;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.dao.PostMapper;
import com.yiibai.mybatis.models.Post;

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
			//级联查询
			testSelecOne2Many();
		} finally {
			session.close();
		}
	}

	// 级联查询
	public static void testSelecOne2Many() {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			PostMapper ipost = session.getMapper(PostMapper.class);
			System.out.println("Test select start...");
			printPosts(ipost.selectMany2One());
			System.out.println("Test select finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	// 打印用户信息到控制台
	private static void printPosts(final List<Post> posts) {
		int count = 0;
		for (Post post : posts) {
			System.out.println(MessageFormat.format("============= Post[{0}]=================", ++count));
			System.out.println(post);
		}
	}
}