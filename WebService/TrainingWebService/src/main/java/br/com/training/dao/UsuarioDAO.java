package br.com.training.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.training.model.Usuario;
import br.com.training.util.HibernateUtil;

public class UsuarioDAO extends GenericDAO<Usuario>{

	public Usuario logar(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			Criteria consulta = session.createCriteria(Usuario.class);
			consulta.add(Restrictions.eq("email", usuario.getEmail()));
			
			SimpleHash hash = new SimpleHash("sha-256",usuario.getSenha());
			consulta.add(Restrictions.eq("senha",hash.toHex()));
			
			return (Usuario) consulta.uniqueResult();
		}catch(RuntimeException e){
			throw e;
		}finally {
			session.close();
		}
	}

}
