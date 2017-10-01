package br.com.training.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.training.model.Mensagem;
import br.com.training.util.HibernateUtil;

public class MensagemDAO extends GenericDAO<Mensagem>{

	@SuppressWarnings("unchecked")
	public List<Mensagem> listarPorAlunoEProfessor(Long codAluno, Long codProfessor){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			Criteria consulta = session.createCriteria(Mensagem.class);
			consulta.add(Restrictions.eq("aluno", codAluno));
			consulta.add(Restrictions.eq("professor",codProfessor));
			
			return consulta.list();
		}catch(RuntimeException e){
			throw e;
		}finally {
			session.close();
		}
	}
}
