package com.myproject.H2DB;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private static final String DATABASE_DIR = "~/ProjectDB";

    @Bean(name = "mainDataSource")
    public DataSource createMainDataSource() {
        final JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:" + DATABASE_DIR);
        ds.setUser("pc");
        ds.setPassword("");
        return ds;
    }
}