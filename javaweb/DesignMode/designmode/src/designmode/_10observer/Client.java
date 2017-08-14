package designmode._10observer;
/**
 * ������
 */
public class Client {
	public static void main(String[] args) {
		//�����۲��߲�������
		Observer lisi = new Lisi();
		Observer wangSi = new WangSi();
		Observer liusi = new Liusi();
		
		//�����������
		HanFeiZi hanFeiZi = new HanFeiZi();
		
		//���˸�����ʷ�������ó������������ڹ۲캫����
		hanFeiZi.addObserver(lisi);
		hanFeiZi.addObserver(wangSi);
		hanFeiZi.addObserver(liusi);
		
		//�����Ӷ����������
		hanFeiZi.haveBreakfast();
	}

}
