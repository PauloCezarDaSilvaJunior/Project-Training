package br.com.training.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.training.model.Cidade;
import br.com.training.util.HibernateUtil;

public class CidadeDAO extends GenericDAO<Cidade>{
	
	public List<Cidade> buscarPorEstado(Long estadoCod){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria consulta = session.createCriteria(Cidade.class);
			consulta.add(Restrictions.eq("estado.codigo", estadoCod));
			consulta.addOrder(Order.asc("nome"));
			List<Cidade> resultado =  consulta.list();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
	}

}
