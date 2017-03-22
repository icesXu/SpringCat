/**
 * 
 */
package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 下午1:37:24
 * 
 * @author yuzhao.yang
 *
 */
public class ListTest {
	public static void main(String[] args) {
		// test();
		List<String> list = new ArrayList<String>();
		// list.add("longwang");
		// test(list);
		String[] array = new String[] { "first", "second", "third" };
		transFromArrayToCollection(array, list);
		for (String ele : list) {
			System.out.println(ele);
		}
	}

	public static void test(List<?> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	static <T> void transFromArrayToCollection(T[] array,
			Collection<T> collection) {
		for (T t : array) {
			collection.add(t);
		}
	}
}
