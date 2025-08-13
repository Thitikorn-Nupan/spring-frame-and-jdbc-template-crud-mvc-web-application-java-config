package com.springframe.coding.webapp_config;

import com.springframe.coding.servlet_config.WebAppServletConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
       This is the typical configuration for a Spring MVC-based application with declaration for Spring’s DispatcherServlet along  with the Spring
       configuration ConfigurationWeb class Finally, it specifies the URL mapping for Spring’s DispatcherServlet to handle all requests.
*/
public class WebAppDispatcherConfig implements WebApplicationInitializer {
    private AnnotationConfigWebApplicationContext context;
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        context = new AnnotationConfigWebApplicationContext();
        context.register(WebAppServletConfig.class);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringMvc" , new DispatcherServlet(context));
        // both is Interface
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
