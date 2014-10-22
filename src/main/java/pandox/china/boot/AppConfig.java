package pandox.china.boot;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import org.apache.log4j.Logger;
import org.hibernate.ejb.HibernatePersistence;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pandox.china.boot.util.BasePropertyConfigurer;
import pandox.china.boot.util.NameGenerator;

import java.util.Properties;

/**
 * Classe de configuração Spring MVC 3
 */
@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan(nameGenerator = NameGenerator.class, basePackages = "pandox", excludeFilters = @Filter(Configuration.class))
@EnableTransactionManagement
@EnableJpaRepositories("pandox.china.repo")
@EnableWebMvc
@EnableAsync
@EnableScheduling
public class AppConfig extends WebMvcConfigurerAdapter {
    private static Logger log = Logger.getLogger(AppConfig.class);


    @Autowired
    private Environment env;

//    @Bean
//    public static MultipartResolver multipartResolver() {
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
////        commonsMultipartResolver.setMaxUploadSize(250000);
//        return commonsMultipartResolver;
//    }

    @Bean
    public static final BasePropertyConfigurer propertyConfigurer() {
        BasePropertyConfigurer config = new BasePropertyConfigurer();
        config.setIgnoreResourceNotFound(false);
        Resource location = new ClassPathResource("config.properties");
        config.setLocation(location);
        return config;
    }

    @Bean
    public AWSCredentials getAWSCredentials() {

        String accessKey = env.getProperty("aws_access_key_id");
        String secretKey = env.getProperty("aws_secret_access_key");
        return new BasicAWSCredentials(accessKey, secretKey);
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        log.info("Configurando [dataSource]...");
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");

        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.user"));
        ds.setPassword(env.getProperty("jdbc.pass"));
        log.info("Datasource configurado: " + ds.toString());
        return ds;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        log.info("Configurando [entityManagerFactory]...");
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("pandox.china");
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);

        Properties hibernateProperties = new Properties();

        hibernateProperties.put("hibernate.hbm2ddl.auto", "update");

        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2005Dialect");
        hibernateProperties.put("hibernate.format_sql", "false");
        hibernateProperties.put("hibernate.show_sql", "false");

        entityManagerFactoryBean.setJpaProperties(hibernateProperties);

        log.info(entityManagerFactoryBean);
        return entityManagerFactoryBean;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public EmbeddedCacheManager cache() {
        DefaultCacheManager defaultCacheManager = new DefaultCacheManager();

        return defaultCacheManager;
    }

}
