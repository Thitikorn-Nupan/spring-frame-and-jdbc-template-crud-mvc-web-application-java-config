package com.springframe.coding.configdb;

import com.springframe.coding.repository.UserRepository;
import com.springframe.coding.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:infodb/sqldb.properties")
public class ConfigDatabase {
    @Value("${info.jdbc.driver}")
    private String driver;
    @Value("${info.jdbc.url}")
    private  String url;
    @Value("${info.jdbc.username}")
    private  String username;
    @Value("${info.jdbc.password}")
    private  String password;

    private DriverManagerDataSource driverManagerDataSource;

    @Bean
    public DriverManagerDataSource getDriverManagerDataSource() {
        driverManagerDataSource = new DriverManagerDataSource(url,username,password);
        driverManagerDataSource.setDriverClassName(driver);
        return driverManagerDataSource;
    }
    @Bean
    public UserRepository userRepositoryCDI() { /* interface can return class implement */
        UserService userService = new UserService(getDriverManagerDataSource());
        /* when UserService class get to use */
        /* this class same construct UserService */
        /* we inject in ControllerEndpoint class */
        return userService;
    }

}
