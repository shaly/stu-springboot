package com.syf.study.core;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;

import com.alibaba.druid.pool.DruidDataSource;

public class DruidDataSourceFactory implements DataSourceFactory {
	//��c3p0һ����ֵ����<properties resource="db.properties"></properties>
    private Properties props;

    public DataSource getDataSource() {
        DruidDataSource dds = new DruidDataSource();
        dds.setDriverClassName(this.props.getProperty("driver"));
        dds.setUrl(this.props.getProperty("url"));
        dds.setUsername(this.props.getProperty("username"));
        dds.setPassword(this.props.getProperty("password"));
        // �������ÿ��Ը���MyBatis�������ļ���������
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