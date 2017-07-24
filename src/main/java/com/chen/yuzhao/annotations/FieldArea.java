package com.chen.yuzhao.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yuzhao.yang
 * @description:class中每个属性值的注解
 * @time:2017年6月13日 下午2:15:01
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldArea {
	public String cssValue() default "";

	public String regexValue() default "";

	public String xpathValue() default "";

	public String jsonPath() default "";
}
