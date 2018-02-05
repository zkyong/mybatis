
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.models.User;

public class HelloWord {
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
			User user = (User) session.selectOne("com.yiibai.mybatis.models.UserMapper.GetUserByID", 1);
			if (user != null) {
				String userInfo = "���֣�" + user.getName() + ", �������ţ�" + user.getDept() + ", ��ҳ��" + user.getWebsite();
				System.out.println(userInfo);
			}
		} finally {
			session.close();
		}
	}

}