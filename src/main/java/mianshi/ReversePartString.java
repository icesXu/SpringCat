/**
 * 
 */
package mianshi;

import java.util.ArrayList;
import java.util.List;

import utils.InputUtils;

/**
 * 下午1:41:40
 * 
 * @author yuzhao.yang
 *
 *
 *         现在有一个字符串，你要对这个字符串进行 n 次操作，每次操作给出两个数字：(p, l) 表示当前字符串中从下标为 p 的字符开始的长度为
 *         l 的一个子串。你要将这个子串左右翻转后插在这个子串原来位置的正后方，求最后得到的字符串是什么。字符串的下标是从 0
 *         开始的，你可以从样例中得到更多信息。
 * 
 *         输入描述: 每组测试用例仅包含一组数据，每组数据第一行为原字符串，长度不超过 10 ，仅包含大小写字符与数字。接下来会有一个数字 n
 *         表示有 n 个操作，再接下来有 n 行，每行两个整数，表示每次操作的(p , l)。 保证输入的操作一定合法，最后得到的字符串长度不超过
 *         1000。
 * 
 *         输出描述: 输出一个字符串代表最后得到的字符串。
 */
public class ReversePartString extends BaseSpider {

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月15日
	 */
	@Override
	public void baseCount() {
		// TODO Auto-generated method stub
		// 每一次翻转字符串，需要记录当前字符串的位置和末尾长度，才能进行插入
		// 翻转就要截取成三部分，而后二次组合
		String input = InputUtils.getInput("请输入字符串:A");
		Integer int1 = InputUtils.getInt("请输入操作次数:");

		List<Operation> list = new ArrayList<ReversePartString.Operation>();
		// 输出操作数
		for (int i = 0; i < int1; i++) {
			String line = InputUtils.getInput("请输入第" + (i + 1)
					+ "次操作数:P:位置;L:长度");
			list.add(new Operation(line.split(" ")[0], line.split(" ")[1]));
		}
		for (int i = 0; i < list.size(); i++) {
			Operation op = list.get(i);
			int begin = Integer.parseInt(op.getPosition());
			int end = Integer.parseInt(op.getLength());

			String first = input.substring(0, begin);
			String second = input.substring(begin, begin + end);
			String last = input.substring(begin + end);

			// 切分成三部分，重新进行连接
			input = first + second
					+ new StringBuffer(second).reverse().toString() + last;
		}
		System.out.println("result:" + input);
	}

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月15日
	 */
	@Override
	public void betterCount() {
		// TODO Auto-generated method stub

	}

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月15日
	 */
	@Override
	public void bestCount() {
		// TODO Auto-generated method stub

	}

	class Operation {
		private String position;
		private String length;

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public String getLength() {
			return length;
		}

		public void setLength(String length) {
			this.length = length;
		}

		public Operation(String position, String length) {
			this.position = position;
			this.length = length;
		}

	}

}
