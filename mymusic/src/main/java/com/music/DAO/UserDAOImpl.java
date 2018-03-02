package com.music.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.music.model.UserDetail;
@Repository
@Transactional

public class UserDAOImpl implements UserDAO {
 
   	private List<UserDetail> listUser;
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void addUser(UserDetail ud)
	{ 
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		sess.save(ud);
		tx.commit();
		sess.close();
		System.out.println("successssss valu is "+ud.getUrole());
	}

	@Override
	public void updateUser(UserDetail ud) {
		Session sess=sessionFactory.openSession();
		Transaction trx=sess.beginTransaction();
		sess.saveOrUpdate(ud);
		trx.commit();
		sess.close();
	}

	@Override
	public void removeUSer(int uid) {
		Session sess=sessionFactory.openSession();
		Transaction trx=sess.beginTransaction();
		
		UserDetail  ud=(UserDetail)sess.load(UserDetail.class,uid );
			sess.delete(ud);
		trx.commit();
		sess.close();
	}
		@Override
	public List<UserDetail> getUser() {
		Session sess=sessionFactory.openSession();
		listUser=sess.createQuery("from UserDetail").list();
		return listUser;
	}
		
		
	@Override
	public UserDetail getUserbyId(int uid) {
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		listUser= sess.createQuery("from UserDetail u where u.uid=:uid").setParameter("uid", uid).list();
	tx.commit();
	sess.close();
			return listUser.size()>0?listUser.get(0):null;
	}
}
