package com.springframe.coding.configservlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@EnableWebMvc
@ComponentScan(value = "com.springframe.coding")
public class ConfigWebAppServlet extends WebMvcConfigurerAdapter {
    private InternalResourceViewResolver viewResolver;
    @Bean /* name bean is getResolver */
    private InternalResourceViewResolver getResolver() {
        viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/ui/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /* maps static resources directly with HTTP GET requests. For example images, javascript, CSS,.. resources do not have to go through controllers.  */
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
        registry.addResourceHandler("/bootstrap/css/**").addResourceLocations("/WEB-INF/bootstrap/css/");
        registry.addResourceHandler("/image/**").addResourceLocations("/WEB-INF/image/");
        registry.addResourceHandler("/font/**").addResourceLocations("/WEB-INF/font/");
    }

}
