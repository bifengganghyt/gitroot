package gz.itcast.dao;

import gz.itcast.entity.User;

/**
 * �û�ģ���dao
 * @author APPle
 *
 */
public class UserDao {

	/**
	 * ģ���ѯ�û��ķ���
	 * @param user
	 * @return
	 */
	public User queryUser(User user){
		if(user.getName().equals("eric") && user.getPassword().equals("1234")){
			//������û������ض�Ӧ���û�����
			return new User("eric","1234");
		}else{
			//û������û�
			return null;
		}
	}
	/**
	 * ģ������û�����
	 * @param user
	 */
	public void addUser(User user){
		System.out.println(user);
		System.out.println("ע��ɹ�");
	}
}
