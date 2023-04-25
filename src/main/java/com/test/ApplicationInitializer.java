package com.test;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servelt.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServeltException;

public class ApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException{
        AnnotiationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContect();
        context.register(ApplicationConfig.class)
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("mvc", new DispatcherServlet(context));

        servletRegistration.setLoadOnStartup(1); //this is the priority of initialization
        servletRegistration.addMapping("/");
    }
}
