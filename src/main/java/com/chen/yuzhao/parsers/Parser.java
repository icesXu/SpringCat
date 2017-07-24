/**
 * 
 */
package com.chen.yuzhao.parsers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.chen.yuzhao.annotations.FieldArea;
import com.chen.yuzhao.annotations.TypeArea;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月13日 下午1:56:05
 */
public class Parser<T> {
	public List<T> parse(Element doc, Class<T> clazz) throws Exception {
		List<T> list = new ArrayList<>();
		T newInstance = clazz.newInstance();
		// 先判断class是否有注解
		if (clazz.isAnnotationPresent(TypeArea.class)) {
			// 获取类的所有注解，并进行遍历
			TypeArea typeArea = clazz.getAnnotation(TypeArea.class);
			if (StringUtils.isNotEmpty(typeArea.cssValue())) {
				String cssValue = typeArea.cssValue();
				// 根据该注解，获取所有的可以转化为类的数据
				Elements elements = doc.select(cssValue);
				System.out.println(elements.outerHtml());
				// 可能存在cssValue写错的情况
				if (null != elements && elements.size() != 0) {
					// 遍历
					for (Element innerElement : elements) {
						// 对于其中到类的每一块区域，进行更细致化的选择
						// 每个属性，遍历
						Field[] fields = clazz.getDeclaredFields();
						for (Field field : fields) {
							if (field.isAnnotationPresent(FieldArea.class)) {
								FieldArea fieldArea = field
										.getAnnotation(FieldArea.class);
								String fieldCssValue = fieldArea.cssValue();
								System.out.println(fieldCssValue);
								String text = innerElement
										.select(fieldCssValue).text();
								System.out.println(text);
								Method[] methods = clazz.getDeclaredMethods();

								for (Method method : methods) {
									if (method.getName().toLowerCase()
											.contains("set")
											&& method
													.getName()
													.toLowerCase()
													.contains(
															field.getName()
																	.toLowerCase())) {
										method.invoke(newInstance, text);
										break;
									}
								}
							}
						}
						list.add(newInstance);
					}
				} else {
					throw new Exception("css选择器错误!");
				}
			}
			if (StringUtils.isNotEmpty(typeArea.xpathValue())) {

			}
			if (StringUtils.isNotEmpty(typeArea.jPathValue())) {

			}
			if (StringUtils.isNotEmpty(typeArea.regexValue())) {

			}
		} else {
			throw new Exception("您所选择的类没有类型注解!");
		}
		return list;
	}
}
