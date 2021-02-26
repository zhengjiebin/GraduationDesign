package com.zheng.blogserver.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;

// 导入Druid数据源
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDatasource(){
        return new DruidDataSource();
    }

    // 配置Durid的监控
    // 1.配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        HashMap<String, String> initParamer = new HashMap<>();
        initParamer.put("jmxUrl","");
        initParamer.put("jmxUsername","root");
        initParamer.put("jmxUserpassword","root");
        bean.setInitParameters(initParamer);
        return bean;
    }
    // 2.配置监控的Filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        HashMap<String, String> initParamer = new HashMap<>();
        initParamer.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParamer);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
