/**
 * 
 */
package mianshi;

import utils.InputUtils;

/**
 * 下午10:10:18
 * 
 * @author yuzhao.yang
 *
 *
 *         DNA分子是以4种脱氧核苷酸为单位连接而成的长链，这4种脱氧核苷酸分别含有A,T,C,G四种碱基。碱基互补配对原则：A和T是配对的，
 *         C和G是配对的。如果两条碱基链长度是相同的并且每个位置的碱基是配对的，那么他们就可以配对合成为DNA的双螺旋结构。现在给出两条碱基链，
 *         允许在其中一条上做替换操作：把序列上的某个位置的碱基更换为另外一种碱基。问最少需要多少次让两条碱基链配对成功
 */
public class DnaMerge {

	public static void main(String[] args) {
		merge();
	}

	public static void merge() {
		String line1 = InputUtils.getInput("请输入第一个字符串:");
		String line2 = InputUtils.getInput("请输入第二个字符串:");

		// 先找出第一条的匹配串，与第二条进行比对。看有多少个不一样的
		char[] charArray = line1.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == 'A') {
				sb.append('T');
			}
			if (charArray[i] == 'T') {
				sb.append('A');
			}
			if (charArray[i] == 'C') {
				sb.append('G');
			}
			if (charArray[i] == 'G') {
				sb.append('C');
			}
		}
		String pipei = sb.toString();
		// 拼凑出第一条的匹配字符串，与字符串二进行匹配
		int num = 0;
		for (int i = 0; i < pipei.length(); i++) {
			if (pipei.charAt(i) != line2.charAt(i)) {
				num++;
			}
		}
		System.out.println("最少数目:" + num);
	}
}
