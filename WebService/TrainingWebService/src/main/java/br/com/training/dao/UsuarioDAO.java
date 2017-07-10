package br.com.training.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.training.model.Usuario;
import br.com.training.util.HibernateUtil;
import org.apache.shiro.crypto.hash.SimpleHash;

public class UsuarioDAO extends GenericDAO<Usuario>{

	public boolean logar(Usuario usuario) {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			Criteria consulta = session.createCriteria(Usuario.class);
			consulta.add(Restrictions.eq("email", usuario.getEmail()));
			
			SimpleHash hash = new SimpleHash("sha-256",usuario.getSenha());
			consulta.add(Restrictions.eq("senha",hash.toHex()));
			
			Usuario resultado = (Usuario) consulta.uniqueResult();
			
			if(resultado != null){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			throw e;
		}finally {
			session.close();
		}
	}

}
