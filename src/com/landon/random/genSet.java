package com.landon.random;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * 通过语言实现的数据结构set来实现从start到end里随机获取count个数字。 优点：时间相对genKunth方法来说性能优 缺点：空间开销大
 * 
 * @author xu
 *
 */
public class genSet extends StrategyPick {

	/**
	 * set集合对于相同的元素只存放一个，不会重复存放。 java中的set集合有两种实现hashset和treeset，treeset能够排序
	 */
	@Override
	public int[] genRandomNumber(int start, int end, int count) {
		if (checkParameter(start, end, count)) {
			int[] result = new int[count];
			Set set = new HashSet<>();
			Random random = new Random();
			while (set.size() < count) {
				set.add(random.nextInt(Integer.MAX_VALUE) % (end - start) + start);
			}
			Iterator iter = set.iterator();
			int i = 0;
			while (iter.hasNext()) {
				result[i++] = (int) iter.next();
				System.out.println(result[i - 1]);
			}
			return result;
		} else
			return new int[1];
	}
}
