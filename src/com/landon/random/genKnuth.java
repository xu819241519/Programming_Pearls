package com.landon.random;

import java.util.Random;

/**
 * ����knuth��the art of computer programming�еķ��� ����start��end�������ȡcount������
 * �ŵ㣺�ڴ�ʹ���٣���������������� ȱ�㣺��count�ܴ�ʱ���ٶ���
 * 
 * @author xu
 *
 */
public class genKnuth extends StrategyPick {

	/**
	 * ���Ǵ�start��end���ζ�ÿһ�����з��������ȶ�start������ȡstart�ĸ���Ϊcount/(end-start)��ȡstart+
	 * 1�ĸ������ǻ���Ҫȡ�ĸ�����count��������ʣ�»��ܴ���ȡ�ĸ�����end-start-1�����������ơ�
	 */
	@Override
	public int[] genRandomNumber(int start, int end, int count) {
		if (checkParameter(start, end, count)) {
			int[] result = new int[count];
			// total��ʾʣ�»��ܴ���ȡ�ĸ�����count��ʾ����Ҫȡ�ĸ���
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
