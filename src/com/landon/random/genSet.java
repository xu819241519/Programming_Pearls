package com.landon.random;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * ͨ������ʵ�ֵ����ݽṹset��ʵ�ִ�start��end�������ȡcount�����֡� �ŵ㣺ʱ�����genKunth������˵������ ȱ�㣺�ռ俪����
 * 
 * @author xu
 *
 */
public class genSet extends StrategyPick {

	/**
	 * set���϶�����ͬ��Ԫ��ֻ���һ���������ظ���š� java�е�set����������ʵ��hashset��treeset��treeset�ܹ�����
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
