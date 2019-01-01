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

/**
 * Home object for domain model class Curso.
 * @see com.abctreinamentos.Curso
 * @author Hibernate Tools
 */
public class CursoDAO {

	private static final Log log = LogFactory.getLog(CursoDAO.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration().configure(new File("src/META-INF/hibernate.cfg.xml"))
				.buildSessionFactory();

		return sessionFactory;
	}

	public void persist(Curso transientInstance) {
		log.debug("persisting Curso instance");
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

	public void delete(Curso persistentInstance) {
		log.debug("deleting Curso instance");
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

	public void merge(Curso detachedInstance) {
		log.debug("merging Curso instance");
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

	public Curso findById(int cdcurso) {
		log.debug("getting Curso instance with id: " + cdcurso);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Curso instance = (Curso) session.get("com.abctreinamentos.Curso", cdcurso);
			session.getTransaction().commit();
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Curso> findAll() {
		log.debug("finding Curso instance by example");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			String hql = "from Curso";
			Query query = session.createQuery(hql);
			List<Curso> cursos = query.list();
			session.getTransaction().commit();
			return cursos;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
