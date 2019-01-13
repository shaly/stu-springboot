package com.syf.study.core;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;

import com.alibaba.druid.pool.DruidDataSource;

public class DruidDataSourceFactory implements DataSourceFactory {
	//与c3p0一样，值来自<properties resource="db.properties"></properties>
    private Properties props;

    public DataSource getDataSource() {
        DruidDataSource dds = new DruidDataSource();
        dds.setDriverClassName(this.props.getProperty("driver"));
        dds.setUrl(this.props.getProperty("url"));
        dds.setUsername(this.props.getProperty("username"));
        dds.setPassword(this.props.getProperty("password"));
        // 其他配置可以根据MyBatis主配置文件进行配置
        //dds.setMaxActive(20);
        //dds.setMinIdle(10);
        try {
            dds.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dds;
    }

    public void setProperties(Properties props) {
        this.props = props;
    }
}