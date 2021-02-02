package cn.qtlplay.wcofone.config;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @description: 数据库配置类
 * @author: Qiao Tongliang
 * @create: 2021-01-29
 */
@Configuration
@MapperScan("cn.qtlplay.wcofone.mapper")
public class HikariDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource(){
        return new HikariDataSource();
    }

}
