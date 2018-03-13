package test.hp.leetcode;

/**
 * ����˻ʺ�����
 * @author pihe
 *
 */
public class EightQueen {

	public EightQueen() {
		// TODO Auto-generated constructor stub
	}
	
	static final int MAX_NUM=8;
	int chessBoard[][] = new int[MAX_NUM][MAX_NUM];
	
	/**
	 * �ж�����Ƿ�Ϲ�
	 * @param x �����꣬��ʾ����
	 * @param y �����꣬��ʾ����
	 * @return
	 */
	boolean check(int x, int y) {
		for(int i=0; i<y; i++) {
			//�������
			if(chessBoard[x][i] == 1) {
				return false;
			}
			//������б��
			if((x-1-i >= 0) && chessBoard[x-1-i][y-1-i] == 1) {
				return false;
			}
			//����Ҳ�б��
			if((x+1+i < MAX_NUM) && chessBoard[x+1+i][y-1-i] == 1) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * �ڷ�8�ʺ�
	 * @param y �����꣬��ʾ����
	 * @return
	 */
	boolean settleQueen(int y) {
		//��������8��˵���Ѿ��ҵ�����
		if (y == MAX_NUM) {
			return true;
		}
		//������ǰ�У������֤
		for(int i = 0; i<MAX_NUM; i ++) {
			//Ϊ��ǰ�����㣬�����ڻ���ʱ����������
			for(int x = 0; x< MAX_NUM; x++) {
				chessBoard[x][y] = 0;
			}
			if(check(i, y)) {
				chessBoard[i][y] = 1;
				if(settleQueen(y+1)) {
					return true;
				}
			}
		}
		return false;
	}
	
	void printCheckBoard() {
		//�����꣬��ʾ����
		for(int j = 0; j < MAX_NUM; j ++) {
			//�����꣬��ʾ��
			for(int i = 0; i < MAX_NUM; i ++) {
				System.out.print(chessBoard[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		EightQueen e = new EightQueen();
		e.settleQueen(0);
		e.printCheckBoard();
	}
	
}
