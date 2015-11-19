package com.landon.excrises;

import java.util.Random;

import org.omg.CORBA.INTERNAL;

/**
 * ��������һ��ϰ��9��Ϊ���Ż���ʼ�����������ĵ�ʱ�䣬�ڵ�һ�η�����������ʱ�����ʼ��Ϊ0�� Ϊ��ģ��δ��ʼ����״̬���ȶ�������������ֵ����Ϊ0
 * 
 * @author xu
 *
 */
public class AvoidInitialization {

	private static int N = 10;

	/**
	 * top��ʾ�Ѿ���ʼ������Ŀ����i�Ѿ���ʼ����from[i]��ʾ��i��Ԫ����toԪ���е�����ֵ����û��ʼ����from�е�ֵδ���塣
	 * to��ǰtop����¼���Ѿ���ʼ����Ԫ�أ�����to[i]��ֵ��ʾ��ԭ�����е�������to�е�Ԫ���ǰ��ճ�ʼ��˳�����е�
	 * to��from�Ĺ�ϵ��΢�to[from[i]]=i����˵����from[i]��ֵ���to�е�������from�е�����i���to��ֵi��
	 * ��δ��ʼ��ʱ��from[i]��ֵ�ܹ�С��top�Ŀ����ԱȽ�С���ټ���from��to�����΢���ϵ�����Ի���ȷ���ܹ����ʽӽ�0��
	 * �����ܹ�Ϊ��Ϊ��ʼ���ķ�����
	 * 
	 * ���⣬�ڵ���������������ʱ������Ϊֱ�ӿ���һ����ԭ�����Сһ����������Ϊ��¼�Ƿ��ʼ�������ˣ��������ǿ�������¿��ٵ�����Ҳ����ҲҪ��ʼ����
	 * 
	 */
	public static void main(String[] args) {

		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int[] from = new int[N];
		int[] to = new int[N];
		int top = 0;

		// Ϊ��ģ��from��to��������δ�������Ϊ�������е�ֵȡ�����
		Random random = new Random();
		for (int i = 0; i < N; ++i) {
			from[i] = random.nextInt(Integer.MAX_VALUE);
			to[i] = random.nextInt(Integer.MAX_VALUE);
		}

		// ��Ҫ����xԪ��
		int x = random.nextInt(N);
		// ����������˵���Ѿ���ʼ����
		if (from[x] < top && to[from[x]] == x) {
			data[x] = -1;
		}
		// ����˵���ǵ�һ�η��ʣ�Ӧ�ó�ʼ��
		else {
			from[x] = top;
			to[from[x]] = x;// ����to[top] = x;
			data[x] = 0;
			top++;
		}
		System.out.println(data[x]);
	}

}
