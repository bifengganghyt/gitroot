package cn.itcast.b_create_obj;

public class User {
	private int id;
	private String name;
	
	public User() {
		System.out.println("User.User(), 创建User对象...");
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		System.out.println("调用User(int id, String name)构造方法");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	// 初始化时候调用
	public void init() {
		System.out.println("初始化...");
	}
	
	// 销毁对象实例时候调用
	public void destroy_() {
		System.out.println("销毁...");
	}
}
