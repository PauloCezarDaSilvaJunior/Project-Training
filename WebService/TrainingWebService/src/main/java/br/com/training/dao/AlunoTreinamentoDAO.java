package br.com.training.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.training.model.AlunoTreinamento;
import br.com.training.util.HibernateUtil;

public class AlunoTreinamentoDAO extends GenericDAO<AlunoTreinamento> {

	@SuppressWarnings("unchecked")
	public List<AlunoTreinamento> listarPorAlunoETreinamento(Long codAluno) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria consulta = session.createCriteria(AlunoTreinamento.class);
			consulta.add(Restrictions.eq("aluno.codigo", codAluno));
			List<AlunoTreinamento> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
	}

}
