package com;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
/**
 * mysql-connector-java-5.0.4.jar
 * 不可以换版本
 * @author liutao
 *
 */
public class MybatisGeneratorRun {
	public static void main(String[] args) throws Exception {
		System.out.println("kaishile........");
		List<String> warnings = new ArrayList<String>();
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(MybatisGeneratorRun.class.getClassLoader().getResourceAsStream("generatorConfig.xml"));

		DefaultShellCallback shellCallback = new DefaultShellCallback(true);

		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
		myBatisGenerator.generate(null);
		for (String string : warnings) {
			System.out.println(string);
		}
	}
}
