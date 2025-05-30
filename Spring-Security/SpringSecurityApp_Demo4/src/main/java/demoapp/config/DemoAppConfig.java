package demoapp.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "demoapp")
@PropertySource("classpath:application.properties")
public class DemoAppConfig implements WebMvcConfigurer
{
    @Autowired
    private Environment environment;

    @Bean
    public DataSource securityDatasource()
    {
        //create connection pool
        ComboPooledDataSource securityDatasource = new ComboPooledDataSource();

        //set the jdbc driver
        try {

            // set database connection properties
            securityDatasource.setDriverClass(environment.getProperty("jdbc.driver"));
            securityDatasource.setUser(environment.getProperty("jdbc.username"));
            securityDatasource.setPassword(environment.getProperty("jdbc.password"));
            securityDatasource.setJdbcUrl(environment.getProperty("jdbc.url"));

            //set connection pool
            securityDatasource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
            securityDatasource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));
            securityDatasource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
            securityDatasource.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));

        }catch (PropertyVetoException ex)
        {
            throw new RuntimeException(ex);
        }
        return securityDatasource;
    }


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}


