package com.abctreinamentos;
// Generated 29/12/2018 10:54:54 by Hibernate Tools 5.2.11.Final

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.spi.CurrentSessionContext;

/**
 * Home object for domain model class Cliente.
 * 
 * @see com.abctreinamentos.Cliente
 * @author Hibernate Tools
 */
public class ClienteDAO {

	private static final Log log = LogFactory.getLog(ClienteDAO.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration().configure(new File("src/META-INF/hibernate.cfg.xml"))
				.buildSessionFactory();

		return sessionFactory;
	}

	public void persist(Cliente transientInstance) {
		log.debug("persisting Cliente instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.persist(transientInstance);
			session.getTransaction().commit();			
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(Cliente persistentInstance) {
		log.debug("deleting Cliente instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.delete(persistentInstance);
			session.getTransaction().commit();			
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void merge(Cliente detachedInstance) {
		log.debug("merging Cliente instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.merge(detachedInstance);
			session.getTransaction().commit();			
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public Cliente findById(long cpf)	{
		log.debug("getting Cliente instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Cliente instance = (Cliente) session.get("com.abctreinamentos.Cliente", cpf);
			session.getTransaction().commit();
			if(instance == null) {
				log.debug("get sucessful, no instance found");
			} else {
				log.debug("get sucessful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
		
	public List<Cliente> findAll() {
		log.debug("getting all Cliente");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			String hql = "from Cliente";
			Query query = session.createQuery(hql);
			List<Cliente> clientes = query.list();
			session.getTransaction().commit();
			return clientes;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
}
