package com.WebSite.demo.dataBase;

import jakarta.annotation.PreDestroy;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    @Getter
    private static SessionFactory sessionFactory = getSessionFactory();

    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // Load configuration from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @PreDestroy
    public static void closeSessionFactory(){
        sessionFactory.close();
    }

}
