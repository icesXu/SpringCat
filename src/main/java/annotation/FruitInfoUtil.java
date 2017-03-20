/**
 * 
 */
package annotation;

import java.lang.reflect.Field;

/**
 * 下午1:45:55
 * 
 * @author yuzhao.yang
 *
 */
public class FruitInfoUtil {
	public static void getFruitInfo(Class<?> clazz) {
		String strFruitName = "水果名称";
		String strFruitColor = "水果颜色";
		String strFruitProvider = "水果供应商";

		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			// 如果出现了该注解
			if (field.isAnnotationPresent(FruitName.class)) {
				FruitName fruitName = (FruitName) field
						.getAnnotation(FruitName.class);
				strFruitName = strFruitName + fruitName.value();
				System.out.println(strFruitName);
			}
			if (field.isAnnotationPresent(FruitColor.class)) {
				FruitColor fruitColor = (FruitColor) field
						.getAnnotation(FruitColor.class);
				strFruitColor = strFruitColor
						+ fruitColor.fruitColor().toString();
				System.out.println(strFruitColor);
			}
			if (field.isAnnotationPresent(FruitProvider.class)) {
				FruitProvider fruitProvider = (FruitProvider) field
						.getAnnotation(FruitProvider.class);
				strFruitProvider = " 供应商编号：" + fruitProvider.id() + " 供应商名称："
						+ fruitProvider.name() + " 供应商地址："
						+ fruitProvider.address();
				System.out.println(strFruitProvider);
			}
		}
	}
}
