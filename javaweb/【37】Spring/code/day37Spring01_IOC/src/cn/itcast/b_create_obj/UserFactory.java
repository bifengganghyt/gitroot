package cn.itcast.b_create_obj;

// 创建user对象的工厂
public class UserFactory {

	// 非静态
	public User getInstace() {
		System.out.println("调用getInstace方法");
		return new User(100,"工厂实例方法，创建对象");
	}
	
	// 静态
	public static User getStaticInstace() {
		System.out.println("调用getStaticInstace方法");
		return new User(101,"工厂静态方法，创建对象");
	}
}
