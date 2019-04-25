package test.hp.sort;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * 有1千万个随机数，随机数的范围在1到1亿之间。现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来？
 * @author hp
 *
 */
public class Alibaba {
	public static void main(String[] args) {
		Random random = new Random();
		List<Integer> list = new ArrayList<>();
		int l = 10;
		for(int i=0; i < l; i ++) {
			list.add(random.nextInt(l));
		}
		System.out.println("产生的随机数有");
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
		BitSet bitSet = new BitSet(l);
		for(int i = 0; i < l; i ++) {
			bitSet.set(list.get(i));
		}
		System.out.println("0~1亿不在上述随机数中有");
		for(int i=0; i < l; i ++) {
			if(!bitSet.get(i)) {
				System.out.println(i);
			}
		}
	}
}
