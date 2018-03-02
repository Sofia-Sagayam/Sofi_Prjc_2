package com.music.DAO;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import java.io.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.music.model.Music;


@Repository
@Transactional
public class MusicDaoImpl implements MusicDAO {
	private List<Music> listGenre;
		@Autowired
	SessionFactory sessionFactory;
		@SuppressWarnings("unchecked")   
	public List<Music> getGenre() {
		     		
		Session sess=sessionFactory.openSession();
		
		listGenre=sess.createQuery("from Music").list();
		return listGenre;
	}
		
		
	
		public void addGenre(Music m) {
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		sess.save(m);
		tx.commit();
		sess.close();
		System.out.println("successssss valu is "+m.getDesc());
		
	}

	public void updateGenre(Music m) {
		System.out.println("DAO Implementation");
		Session sess=sessionFactory.openSession();
		Transaction trx=sess.beginTransaction();
		sess.saveOrUpdate(m);
		trx.commit();
		sess.close();
	}



	@SuppressWarnings("unchecked")
	public Music getGenrebyId(String gid) {
			Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		listGenre= sess.createQuery("from Music m where m.genreid=:gid").setParameter("gid", gid).list();
	tx.commit();
	sess.close();
			return listGenre.size()>0?listGenre.get(0):null;
		
	}
			public void removeGenre(String gid) {
		Session sess=sessionFactory.openSession();
		Transaction trx=sess.beginTransaction();
		
		Music m=(Music)sess.load(Music.class,gid );
			sess.delete(m);
		trx.commit();
		sess.close();
	}

}
