package com.neoteric.doubleSchema.configuration;
import java.util.HashMap;

import javax.sql.DataSource;

import com.neoteric.doubleSchema.product.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;



@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.neoteric.doubleSchema.repository.product",
        entityManagerFactoryRef = "productEntityManagerFactory",
        transactionManagerRef = "productTransactionManager")


public class PersistenceProductConfiguration {





        @Bean
        @ConfigurationProperties("spring.datasource.second")
        public DataSourceProperties serverDataSourceProperties() {
            return new DataSourceProperties();
        }

        @Bean
        @ConfigurationProperties("spring.datasource.second")
        public DataSource serverDataSource() {
            return serverDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
        }

        @Bean(name = "productEntityManagerFactory")
        public LocalContainerEntityManagerFactoryBean serverEntityManagerfactory(EntityManagerFactoryBuilder builder) {
            return builder.dataSource(serverDataSource()).packages(Product.class).build();
        }

        @Bean(name = "productTransactionManager")
        public PlatformTransactionManager serverTransactionManager(
                final @Qualifier("productEntityManagerFactory") LocalContainerEntityManagerFactoryBean serverEntityManagerFactory) {
            return new JpaTransactionManager(serverEntityManagerFactory.getObject());
        }

    }