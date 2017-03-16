/**
 * 
 */
package mianshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.InputUtils;

/**
 * 下午1:06:31
 * 
 * @author yuzhao.yang
 *
 *
 *         给出N条drawline指令以及对应的线段坐标，小王想知道，实际最少用多少次drawline指令就可以画出来。
 * 
 *         小王想先从最简单的情况开始分析优化，所以线段只包含四种情况：水平线段，垂直线段以及正反45度的线段。
 */
public class LeastDrawLines extends BaseSpider {

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月16日
	 */
	@Override
	public void baseCount() {
		// TODO Auto-generated method stub
		List<Line> list = new ArrayList<Line>();
		Integer int1 = InputUtils.getInt("请输入线条个数:");
		for (int i = 0; i < int1; i++) {
			String line = InputUtils.getInput("请输入第" + i + "条线:");
			String[] array = line.split(" ");

			Integer beginX = Integer.parseInt(array[0]);
			Integer beginY = Integer.parseInt(array[1]);
			Integer endX = Integer.parseInt(array[2]);
			Integer endY = Integer.parseInt(array[3]);

			// 计算角度
			Line item = new Line(beginX, beginY, endX, endY);

			// 横坐标相等，90
			// 纵坐标相等：0
			// 斜率1：45
			// 斜率-1：-45
			if (beginX == endX) {
				item.setAngle(90);
			}
			if (beginY == endY) {
				item.setAngle(0);
			}
			if (endY - beginY == endX - beginX) {
				item.setAngle(45);
			}
			if (endY - beginY != endX - beginX) {
				item.setAngle(-45);
			}
			list.add(item);
		}
		// 生成当前的所有线条。
		// 拥有不同角度的，肯定不可能用一次drawline绘制
		for (Line line : list) {
			// 现在的线条，都是各自带着自己的角度
			

		}
	}

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月16日
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
	 * @date 2017年3月16日
	 */
	@Override
	public void bestCount() {
		// TODO Auto-generated method stub

	}

	class Line {
		private Integer beginX;
		private Integer beginY;
		private Integer endX;
		private Integer endY;

		private Integer angle;

		public Integer getAngle() {
			return angle;
		}

		public void setAngle(Integer angle) {
			this.angle = angle;
		}

		public Integer getBeginX() {
			return beginX;
		}

		public void setBeginX(Integer beginX) {
			this.beginX = beginX;
		}

		public Integer getBeginY() {
			return beginY;
		}

		public void setBeginY(Integer beginY) {
			this.beginY = beginY;
		}

		public Integer getEndX() {
			return endX;
		}

		public void setEndX(Integer endX) {
			this.endX = endX;
		}

		public Integer getEndY() {
			return endY;
		}

		public void setEndY(Integer endY) {
			this.endY = endY;
		}

		/**
		 * @param beginX
		 * @param beginY
		 * @param endX
		 * @param endY
		 */
		public Line(Integer beginX, Integer beginY, Integer endX, Integer endY) {
			super();
			this.beginX = beginX;
			this.beginY = beginY;
			this.endX = endX;
			this.endY = endY;
		}
	}
}
