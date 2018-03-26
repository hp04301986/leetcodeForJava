package test.hp.leetcode;

/**
 * ��ŵ������
 * Ϊ��Ҫ����n�����Ӵ�A�ƶ���c����Ҫ����N�����������n-1�������ƶ���b�ϣ��������ܽ���n�������ƶ���c��
 * ͬ��Ϊ�˽���n-1�����Ӵ�b�ƶ���c�ϣ���Ҫ��n-2�������ƶ���A�ϣ��������ܽ���n-1�������ƶ���c��
 * @author pihe
 *
 */
public class Hanoi {

	public Hanoi() {
		// TODO Auto-generated constructor stub
	}
	
	public static void moveDish(int level, char from, char inter, char to) {
		//ֻ��һ�����Ӿ��˳�����
		if(level == 1) {
			System.out.println("move 1 from "+ from + " to " + to);
		}else {
			moveDish(level-1, from, to, inter);
			System.out.println("move " + level + " from " + from + " to " + to);
			moveDish(level-1, inter, from, to);
		}	
	}
	
	public static void main(String[] args) {
		int dishNumber = 4;
		moveDish(dishNumber, 'A', 'B', 'C');
	}

}
