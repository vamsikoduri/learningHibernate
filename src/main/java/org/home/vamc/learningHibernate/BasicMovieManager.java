package org.home.vamc.learningHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class BasicMovieManager {

	private SessionFactory sessionFactory = null;

	private void initSessionFactory() {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		sessionFactory = config.buildSessionFactory(serviceRegistry);

	}

	private void init3x() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	private void persistMovie(Movie movie) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(movie);
		session.getTransaction().commit();
	}

	private void findMovie(int movieId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Movie movie = (Movie) session.load(Movie.class, movieId);
		if (null != movie) {
			System.err.println(movie.getId()+"  "+movie.getTitle());
			
		}
		session.getTransaction().commit();
	}

	public static void main(String args[]) {
		BasicMovieManager movieManager = new BasicMovieManager();
		movieManager.initSessionFactory();
		/*Movie mv = new Movie();
		mv.setId(105);
		mv.setTitle("JJJ");
		mv.setDirector("JMan");
		mv.setSynonypis("JThundr");
		movieManager.persistMovie(mv);*/
		System.err.println("The movie inserted successfully");
		movieManager.findMovie(105);

	}
}
