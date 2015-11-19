package com.landon.excrises;

import java.util.Random;

import org.omg.CORBA.INTERNAL;

/**
 * 编程珠玑第一张习题9，为了优化初始化本身所消耗的时间，在第一次访问向量的项时将其初始化为0。 为了模拟未初始化的状态，先定义向量的所有值都不为0
 * 
 * @author xu
 *
 */
public class AvoidInitialization {

	private static int N = 10;

	/**
	 * top表示已经初始化的数目。若i已经初始化，from[i]表示第i个元素在to元素中的索引值，若没初始化，from中的值未定义。
	 * to中前top个记录了已经初始化的元素，其中to[i]的值表示在原向量中的索引。to中的元素是按照初始化顺序排列的
	 * to和from的关系很微妙，to[from[i]]=i就能说明。from[i]的值变成to中的索引，from中的索引i变成to的值i。
	 * 若未初始化时，from[i]的值能够小于top的可能性比较小，再加上from和to的这个微妙关系，可以基本确认能够概率接近0，
	 * 所以能够为作为初始化的方法。
	 * 
	 * 另外，在当初考虑这个问题的时候，我以为直接开辟一个和原数组大小一样的数组作为记录是否初始化就行了，可是忘记考虑这个新开辟的数组也必须也要初始化。
	 * 
	 */
	public static void main(String[] args) {

		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int[] from = new int[N];
		int[] to = new int[N];
		int top = 0;

		// 为了模拟from和to两个数组未定义的行为，将其中的值取随机数
		Random random = new Random();
		for (int i = 0; i < N; ++i) {
			from[i] = random.nextInt(Integer.MAX_VALUE);
			to[i] = random.nextInt(Integer.MAX_VALUE);
		}

		// 若要访问x元素
		int x = random.nextInt(N);
		// 条件成立，说明已经初始化过
		if (from[x] < top && to[from[x]] == x) {
			data[x] = -1;
		}
		// 否则说明是第一次访问，应该初始化
		else {
			from[x] = top;
			to[from[x]] = x;// 或者to[top] = x;
			data[x] = 0;
			top++;
		}
		System.out.println(data[x]);
	}

}
