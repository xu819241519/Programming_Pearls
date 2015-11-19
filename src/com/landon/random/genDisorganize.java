package com.landon.random;

import java.util.Arrays;
import java.util.Random;

/**
 * 运用打乱顺序方法，从start到end里随机获取count个数字
 * 优点：空间开销o（n），相比set方法要小很多。要想得到有序的随机数，需要加一个m*ln（m）复杂度的排序函数，总复杂度n+m*ln（m）。
 * 其中n表示start到end的个数，m表示所要选取的个数
 * 
 * 为了将初始化的复杂度n降低成常量时间，可以使用额外的空间来优化。具体优化见第一张习题9
 * 
 * @author xu
 *
 */
public class genDisorganize extends StrategyPick {

	/**
	 * 将原先数组打乱顺序，然后选取前count个数
	 */
	@Override
	public int[] genRandomNumber(int start, int end, int count) {
		if (checkParameter(start, end, count)) {
			int total = end - start;
			int[] result = new int[total];
			// 首先赋初值
			for (int i = 0; i < end - start; ++i) {
				result[i] = i + start;
			}

			// 然后再交换，考虑count大于total的情况，要排除模0的可能。
			for (int i = 0; i < count && i < total; ++i) {
				Random random = new Random();
				if (total - i - 1 != 0)
					swap(result, i, random.nextInt(Integer.MAX_VALUE) % (total - i - 1) + i + 1);
			}

			Arrays.sort(result, 0, count);
			for (int i = 0; i < count; ++i)
				System.out.println(result[i]);
			return result;
		} else
			return new int[1];
	}

	private void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

}
