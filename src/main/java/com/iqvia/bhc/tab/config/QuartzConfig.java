package com.iqvia.bhc.tab.config;

import java.io.IOException;
import java.util.Properties;

import org.quartz.*;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig implements SchedulerFactoryBeanCustomizer {

	    @Bean
	    public Properties properties() throws IOException {
	        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
	        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
	        propertiesFactoryBean.afterPropertiesSet();
	        return propertiesFactoryBean.getObject();
	    }

	    @Bean
	    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
	        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
	        schedulerFactoryBean.setQuartzProperties(properties());
	        return schedulerFactoryBean;
	    }

	    @Bean
	    public Scheduler iqviaClusterScheduler() throws IOException {
	        return schedulerFactoryBean().getScheduler();
	    }

	    @Override
	    public void customize(SchedulerFactoryBean schedulerFactoryBean) {
	        schedulerFactoryBean.setStartupDelay(2);
	        schedulerFactoryBean.setAutoStartup(true);
	        schedulerFactoryBean.setOverwriteExistingJobs(true);
	    }
}
