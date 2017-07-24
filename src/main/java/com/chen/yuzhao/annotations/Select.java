/**
 * 
 */
package com.chen.yuzhao.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月12日 下午2:35:36
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Select {
	public String cssValue() default "";

	public String regexValue() default "";

	public String xpathValue() default "";

	public String jsonPath() default "";
}
