package br.com.training.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.training.model.Aluno;
import br.com.training.model.Professor;
import br.com.training.util.HibernateUtil;

public class ProfessorDAO extends GenericDAO<Professor>{
	@SuppressWarnings("unchecked")
	public List<Aluno> buscarAlunoPorProfessor(Long codProfessor){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria consulta = session.createCriteria(Aluno.class);
			consulta.add(Restrictions.eq("professor.codigo", codProfessor));
			consulta.addOrder(Order.asc("nome"));
			List<Aluno> resultado =  consulta.list();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
	}
}
