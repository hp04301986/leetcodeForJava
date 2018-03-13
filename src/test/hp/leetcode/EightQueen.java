package test.hp.leetcode;

/**
 * 经典八皇后问题
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
	 * 判断落点是否合规
	 * @param x 横坐标，表示列数
	 * @param y 纵坐标，表示行数
	 * @return
	 */
	boolean check(int x, int y) {
		for(int i=0; i<y; i++) {
			//检查纵向
			if(chessBoard[x][i] == 1) {
				return false;
			}
			//检查左侧斜向
			if((x-1-i >= 0) && chessBoard[x-1-i][y-1-i] == 1) {
				return false;
			}
			//检查右侧斜向
			if((x+1+i < MAX_NUM) && chessBoard[x+1+i][y-1-i] == 1) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 摆放8皇后
	 * @param y 纵坐标，表示行数
	 * @return
	 */
	boolean settleQueen(int y) {
		//行数超过8，说明已经找到答案了
		if (y == MAX_NUM) {
			return true;
		}
		//遍历当前行，逐格验证
		for(int i = 0; i<MAX_NUM; i ++) {
			//为当前行清零，以免在回溯时出现脏数据
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
		//横坐标，表示列数
		for(int j = 0; j < MAX_NUM; j ++) {
			//纵坐标，表示行
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
