package com.landon.random;

/**
 * ����ģʽ
 * 
 * @author xu
 *
 */
public abstract class StrategyPick {

	/**
	 * ��ȡ��start��end��ȡcount�������
	 * 
	 * @param start
	 *            ��ʼ��ȡ�����֣�������
	 * @param end
	 *            ������ȡ�����֣���������
	 * @param count
	 *            Ҫ��ȡ�ĸ���
	 * @return ��ȡ�Ľ��
	 */
	public abstract int[] genRandomNumber(int start, int end, int count);

	public boolean checkParameter(int start, int end, int count) {
		if (count <= 0) {
			System.out.println("Ҫȡ�ĸ�������Ϊ������0");
			return false;
		}
		if (end <= start) {
			System.out.println("�������ֹ���ݲ���ȷ��");
			return false;
		}
		return true;
	}
}
