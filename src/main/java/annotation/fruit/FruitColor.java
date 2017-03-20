/**
 * 
 */
package annotation.fruit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 下午1:35:22
 * 
 * @author yuzhao.yang
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

	public enum Color {
		BLUE, RED, GREEN
	};

	Color fruitColor() default Color.GREEN;
}
