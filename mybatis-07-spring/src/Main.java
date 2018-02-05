import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yiibai.mybatis.mapper.UserMapper;
import com.yiibai.mybatis.models.Order;
import com.yiibai.mybatis.models.User;

public class Main {

	private static ApplicationContext ctx;

	static {
		ctx = new ClassPathXmlApplicationContext("config/applicationContext.xml");
	}

	public static void main(String[] args) {
		UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
		// ����id=1���û���ѯ���ɸ������ݿ��е�����޸�.
		User user = userMapper.selectUserById(1);
		System.out.println("��ȡ�û� ID=1 ���û�����"+user.getUserName());

		// �õ������б����
		System.out.println("�õ��û�idΪ1�����ж����б�:");
		System.out.println("--------------------------------");
		List<Order> orders = userMapper.selectUserOrders(1);

		for (Order order : orders) {
			System.out.println("������|"+order.getOrderNo() + "|�������|" + order.getOrderMoney());
			System.out.println("--------------------------------");
		}

	}

}