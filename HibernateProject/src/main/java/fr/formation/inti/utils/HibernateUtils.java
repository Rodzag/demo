package fr.formation.inti.utils;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtils {

	private static final Log log = LogFactory.getLog(HibernateUtils.class);
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		
		return metadata.getSessionFactoryBuilder().build();
	}
	
	public static SessionFactory getSessionFactory() {
		log.debug("Creation de la session Factory");
		return sessionFactory;
	}
	
	public static void close() {
		getSessionFactory().close();
	}
	
	
}
