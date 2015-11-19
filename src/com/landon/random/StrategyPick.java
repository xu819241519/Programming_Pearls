package com.landon.random;

/**
 * 策略模式
 * 
 * @author xu
 *
 */
public abstract class StrategyPick {

	/**
	 * 获取从start到end中取count个随机数
	 * 
	 * @param start
	 *            开始获取的数字（包括）
	 * @param end
	 *            结束获取的数字（不包括）
	 * @param count
	 *            要获取的个数
	 * @return 获取的结果
	 */
	public abstract int[] genRandomNumber(int start, int end, int count);

	public boolean checkParameter(int start, int end, int count) {
		if (count <= 0) {
			System.out.println("要取的个数不能为负数或0");
			return false;
		}
		if (end <= start) {
			System.out.println("输入的起止数据不正确！");
			return false;
		}
		return true;
	}
}
