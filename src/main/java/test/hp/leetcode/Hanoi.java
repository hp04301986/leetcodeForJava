package test.hp.leetcode;

/**
 * 汉诺塔问题
 * 为了要将第n个盘子从A移动到c，需要将第N个盘子上面的n-1个盘子移动到b上，这样才能将第n个盘子移动到c。
 * 同理，为了将第n-1个盘子从b移动到c上，需要将n-2个盘子移动到A上，这样才能将第n-1个盘子移动到c上
 * @author pihe
 *
 */
public class Hanoi {

	public Hanoi() {
		// TODO Auto-generated constructor stub
	}
	
	public static void moveDish(int level, char from, char inter, char to) {
		//只有一个盘子就退出迭代
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
