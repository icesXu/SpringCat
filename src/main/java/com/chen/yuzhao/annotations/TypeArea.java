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
 * @description:用于修饰一个类，解析出页面中，真正对应于一个类的小块区域
 * @time:2017年6月13日 下午1:43:49
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TypeArea {
	String cssValue() default "";

	String xpathValue() default "";

	String jPathValue() default "";

	String regexValue() default "";
}
