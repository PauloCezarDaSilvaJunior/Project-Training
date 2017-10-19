package br.com.training.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.training.model.Exercicio;
import br.com.training.util.HibernateUtil;

public class ExercicioDAO extends GenericDAO<Exercicio>{
	@SuppressWarnings("unchecked")
	public List<Exercicio> listar(Long codProfessor){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria consulta = session.createCriteria(Exercicio.class);
			consulta.add(Restrictions.eq("professor.codigo", codProfessor));
			consulta.addOrder(Order.asc("nome"));
			List<Exercicio> resultado =  consulta.list();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
	}
}
