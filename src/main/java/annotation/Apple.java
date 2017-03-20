/**
 * 
 */
package annotation;

import annotation.FruitColor.Color;

/**
 * 下午1:38:37
 * 
 * @author yuzhao.yang
 *
 */
public class Apple {
	@FruitName("apple")
	String appleName;

	@FruitColor(fruitColor = Color.RED)
	String appleColor;

	@FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省某个地址")
	String appleProvider;

	public String getAppleName() {
		return appleName;
	}

	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	public String getAppleColor() {
		return appleColor;
	}

	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	public void displayName() {
		System.out.println("水果的名字" + appleName);
	}

}
