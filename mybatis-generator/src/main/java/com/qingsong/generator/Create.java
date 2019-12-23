package com.qingsong.generator;


public class Create {
	public static void main(String[] args) {
		Create ot=new Create();
		ot.test();
	}
	
	public void test(){

		// 数据库连接信息
		String url = "jdbc:mysql://120.27.71.186:3306/db_test?useUnicode=true&characterEncoding=utf8";
		String MysqlUser = "root";
		String mysqlPassword = "chen1208";
		// 数据库及数据表名称
		String database = "db_test";
		String table = "user_info";

//		String url = "jdbc:mysql://raycloudtest.mysql.rds.aliyuncs.com:3306/ding_cw_1?useUnicode=true&amp;characterEncoding=UTF-8&amp;allowMultiQueries=true";
//		String MysqlUser = "youcheng";
//		String mysqlPassword = "qTemX6MPAU2P";
//		String database = "ding_cw_1";
//		String table = "project_info_log";

		// 配置作者及Domain说明.
		String classAuthor = "chenqingsong";
		String functionName = "项目实例操作日志表";
		// 公共包路径 (例如 BaseDao、 BaseService、 BaseServiceImpl)
		String commonName ="";
		
		String packageName ="com.qingsong";
		String moduleName = "";

		//Mapper文件存储地址  默认在resources中
		String batisName = "config/mapping";
		String db="mysql";
		
		try {
			String classNamePrefix = getClassName(table);
			MybatisGenerate.generateCode(db,url, MysqlUser, mysqlPassword, database, table,commonName,packageName,batisName,moduleName,classAuthor,functionName,classNamePrefix);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getClassName(String tableName) {
	    String beanName = tableName.substring(0,1).toUpperCase() + tableName.substring(1);
	    while(beanName.indexOf("_") >=0){
	        int firstSpe = beanName.indexOf("_");
	        beanName = beanName.substring(0,firstSpe) + beanName.substring(firstSpe+1,firstSpe+2).toUpperCase() + beanName.substring(firstSpe+2);
	    }
		return beanName;
	}
	

}
