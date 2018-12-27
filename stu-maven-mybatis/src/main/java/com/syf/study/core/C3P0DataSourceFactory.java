package com.syf.study.core;
import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
        
public class C3P0DataSourceFactory implements DataSourceFactory {

	private Properties props;
	
	@Override
	public void setProperties(Properties props) {
		this.props = props;
	}
	
	@Override
	public DataSource getDataSource() {
		try {
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			dataSource.setDriverClass(this.props.getProperty("driver"));
			dataSource.setJdbcUrl(this.props.getProperty("url"));
			dataSource.setUser(this.props.getProperty("username"));
			dataSource.setPassword(this.props.getProperty("password"));
			
			//�޸����ݿ�Ĭ���������ԣ�Ĭ����15����com.mchange.v2.c3p0.impl.C3P0Defaults�����趨
			dataSource.setMaxPoolSize(20);
			dataSource.setMinPoolSize(5);
			dataSource.setInitialPoolSize(3);
			
			return dataSource;
		} catch (PropertyVetoException e) {
			e.printStackTrace();
			return null;
		}
	}
}