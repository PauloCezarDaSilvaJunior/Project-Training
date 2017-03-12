package br.com.farmacia.util;

import org.hibernate.Session;
import org.junit.Test;

import br.com.training.util.HibernateUtil;

public class HibernateUtilTeste {

	@Test
	public void conectarHibernate() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
}
