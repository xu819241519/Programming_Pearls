package com.landon.random;

import java.util.Random;

/**
 * 运用knuth在the art of computer programming中的方法 ，从start到end里随机获取count个数字
 * 优点：内存使用少，输出的是有序序列 缺点：当count很大时，速度慢
 * 
 * @author xu
 *
 */
public class genKnuth extends StrategyPick {

	/**
	 * 考虑从start到end依次对每一个进行分析，首先对start分析，取start的概率为count/(end-start)，取start+
	 * 1的概率则是还需要取的个数（count’）除以剩下还能从中取的个数（end-start-1），依次类推。
	 */
	@Override
	public int[] genRandomNumber(int start, int end, int count) {
		if (checkParameter(start, end, count)) {
			int[] result = new int[count];
			// total表示剩下还能从中取的个数，count表示还需要取的个数
			int total = end - start;
			int index = 0;
			for (int i = start; i < end; ++i) {
				Random ran = new Random();
				if (ran.nextInt(Integer.MAX_VALUE) % total < count) {
					result[index++] = i;
					System.out.println(result[index - 1]);
					count--;
				}
				total--;

			}
			return result;
		}

		else
			return new int[1];

	}
}
