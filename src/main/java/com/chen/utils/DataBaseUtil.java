/**
 * 
 */
package com.chen.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

/**
 * @author yuzhao.yang
 * @description:从固定的sql文件中，拆分出需要的数据,并在对应的目录下，生成bean
 * @time:2017年6月9日 下午3:50:15
 */
public class DataBaseUtil {
	public static void main(String[] args) throws IOException {
		DataBaseUtil.transferToBean(
				"C:\\Users/YYZYHC/Desktop/brand_details.sql", false,
				"BrandDetail", "com.chen.yuzhao");
	}

	/**
	 * 
	 * @description:
	 * @author:yuzhao.yang
	 * @param path
	 *            :要读取的文件
	 * @param needId
	 *            :是否需要id
	 * @param className
	 *            :生成class的名称
	 * @param directory
	 *            :生成class的所在地(只写到父目录，后面跟着model或者dao)
	 * @return:
	 * @time:2017年6月9日 下午3:53:16
	 */
	public static void transferToBean(String path, boolean needId,
			String className, String directory) throws IOException {

		// 应当解析出tableName

		File file = new File(path);
		String tableName = file.getName().substring(0,
				file.getName().indexOf("."));
		List<String> lines = FileUtils.readLines(file);

		Map<String, String> fields = new HashMap<String, String>();

		// 找到比较合适的方法，一次性拆分出其中的所有可能存在的字段
		for (String line : lines) {
			if (line.contains("TABLE")) {
				continue;
			}
			if (line.contains("PRIMARY")) {
				continue;
			}
			if (line.contains("ENGINE")) {
				continue;
			}
			// 通常第一行是不需要的
			int index1 = line.indexOf("`");
			int index2 = line.indexOf("` ");
			if (index1 >= 0 && index2 >= 0) {
				String text = line.substring(index1 + 1, index2);
				if (text.equalsIgnoreCase("id")) {
					if (needId) {
						fields.put(text, "Integer");
					}
				} else {
					if (line.contains("datetime")) {
						fields.put(text, "Date");
					} else {
						fields.put(text, "String");
					}
				}
			}
		}
		StringBuilder allKeys = new StringBuilder();
		StringBuilder withParamAllKeys = new StringBuilder();

		// 为了DAO生成的数据
		for (String string : fields.keySet()) {
			allKeys.append(string + ",");
			withParamAllKeys.append(":t." + string + ",");
		}

		// 其中的字段
		List<String> list = new ArrayList<String>();

		// 为了直接生成class的数据
		for (String key : fields.keySet()) {
			// 过滤一遍，看是否要添加其他的引入包
			list.add("private " + fields.get(key) + " " + key + ";");
		}

		System.out.println(System.getProperty("user.dir"));
		String newPath = System.getProperty("user.dir") + "/src/main/java";
		String[] splits = directory.split("\\.");

		StringBuilder sb = new StringBuilder(newPath);

		for (String split : splits) {
			sb.append("/" + split);
		}
		File classFile = new File(sb.toString() + "/model" + "/" + className
				+ ".java");

		FileUtils.write(classFile, "package " + directory + ".model" + ";",
				true);
		FileUtils.write(classFile, "import java.util.Date;\n", true);
		FileUtils.write(classFile, "public class " + className + "{", true);
		FileUtils.writeLines(classFile, list, true);
		FileUtils.write(classFile, "}", true);

		String daoPath = sb.toString() + "/dao";

		File daoFile = new File(daoPath + "/" + className + "DAO.java");
		FileUtils.write(daoFile, "package " + (directory + ".dao") + ";\n");

		FileUtils.write(daoFile,
				"import net.paoding.rose.jade.annotation.DAO;\n", true);
		FileUtils
				.write(daoFile,
						"import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;\n",
						true);
		FileUtils.write(daoFile,
				"import net.paoding.rose.jade.annotation.SQL;\n", true);
		FileUtils.write(daoFile,
				"import net.paoding.rose.jade.annotation.SQLParam;\n", true);
		FileUtils.write(daoFile,
				"import net.paoding.rose.jade.annotation.ShardBy;\n", true);

		FileUtils.write(daoFile, "import " + directory + ".model." + className
				+ ";\n", true);
		FileUtils.write(daoFile, "import java.util.List;\n", true);

		FileUtils.write(daoFile, "@DAO\n", true);

		FileUtils.write(daoFile, "public interface " + className + "DAO"
				+ "{\n\n", true);

		// 中间写一句插入语句
		FileUtils.write(daoFile, "@ReturnGeneratedKeys\n", true);
		FileUtils.write(daoFile, "@SQL(\"insert into " + tableName + " ("
				+ allKeys.substring(0, allKeys.length() - 1) + ") values ("
				+ withParamAllKeys.substring(0, withParamAllKeys.length() - 1)
				+ ")" + "\"" + ")\n", true);
		FileUtils.write(daoFile, "public int add(@SQLParam(\"t\") " + className
				+ " test);", true);

		FileUtils.write(daoFile, "}", true);

	}
}
