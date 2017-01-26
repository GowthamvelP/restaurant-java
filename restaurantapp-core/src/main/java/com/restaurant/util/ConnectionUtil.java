package com.restaurant.util;


	import javax.sql.DataSource;

	import org.apache.commons.dbcp2.BasicDataSource;
	import org.springframework.jdbc.core.JdbcTemplate;

	public class ConnectionUtil {
		public static DataSource getDataSource() {
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUsername("root");
			ds.setPassword("maha6989");
			ds.setUrl("jdbc:mysql://localhost:3306/test");
			return ds;
		}

		public static JdbcTemplate getJdbcTemplate() {
			JdbcTemplate jt = new JdbcTemplate();
			jt.setDataSource(getDataSource());
			return jt;
		}
	
}
