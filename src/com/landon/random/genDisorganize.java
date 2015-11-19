package com.landon.random;

import java.util.Arrays;
import java.util.Random;

/**
 * ���ô���˳�򷽷�����start��end�������ȡcount������
 * �ŵ㣺�ռ俪��o��n�������set����ҪС�ܶࡣҪ��õ���������������Ҫ��һ��m*ln��m�����Ӷȵ����������ܸ��Ӷ�n+m*ln��m����
 * ����n��ʾstart��end�ĸ�����m��ʾ��Ҫѡȡ�ĸ���
 * 
 * Ϊ�˽���ʼ���ĸ��Ӷ�n���ͳɳ���ʱ�䣬����ʹ�ö���Ŀռ����Ż��������Ż�����һ��ϰ��9
 * 
 * @author xu
 *
 */
public class genDisorganize extends StrategyPick {

	/**
	 * ��ԭ���������˳��Ȼ��ѡȡǰcount����
	 */
	@Override
	public int[] genRandomNumber(int start, int end, int count) {
		if (checkParameter(start, end, count)) {
			int total = end - start;
			int[] result = new int[total];
			// ���ȸ���ֵ
			for (int i = 0; i < end - start; ++i) {
				result[i] = i + start;
			}

			// Ȼ���ٽ���������count����total�������Ҫ�ų�ģ0�Ŀ��ܡ�
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
