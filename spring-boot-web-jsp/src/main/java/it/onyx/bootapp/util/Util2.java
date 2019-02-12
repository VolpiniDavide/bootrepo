package it.onyx.bootapp.util;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.onyx.bootapp.dao.UserDao;



public class Util2 {
	
	
	//-----------------------  metodo login ------------------------------ //
	
public static UserDao login ( String email , String password) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
		Session session = cfg.buildSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<UserDao> cr = cb.createQuery(UserDao.class);
		Root<UserDao> root = cr.from(UserDao.class);
		cr.select(root).where(cb.equal(root.get("email"), email),cb.equal(root.get("password"), password));	
		Query<UserDao> query = session.createQuery(cr);
		UserDao ud = query.getSingleResult();
		
		session.close();
		
		return ud;

}

// --------------------------------  metodo di verifica email ------------------------ //

public static Boolean emailExist ( String email) {
	
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	Session session = cfg.buildSessionFactory().getCurrentSession();
	
	session.beginTransaction();
	
	CriteriaBuilder cb = session.getCriteriaBuilder();
	CriteriaQuery<UserDao> cr = cb.createQuery(UserDao.class);
	Root<UserDao> root = cr.from(UserDao.class);
	cr.select(root).where(cb.equal(root.get("email"), email));	
	Query<UserDao> query = session.createQuery(cr);
	List<UserDao> users = query.getResultList();
	
	session.close();
	
	if( users.size() > 0 ) {
		return true;
	}else { return false; }
	
}


//----------------------------------- metodo di insert ---------------------------------------- //

public static Boolean createUser ( UserDao ud ) {

							//--- hibernate insert -- //
			
				Configuration cfg = new Configuration();
				cfg.configure("hibernate.cfg.xml");
	            Session session = cfg.buildSessionFactory().getCurrentSession();
	            session.beginTransaction();
	            session.save(ud);
	            session.getTransaction().commit();
//	    TODO        try {
//					Util.sendEmail(email);
//					myLogger.error("mail sent");
//				} catch (AddressException e) {
//					myLogger.error("mail not sent");
//				}       
			
	
	
	return null;
}




}