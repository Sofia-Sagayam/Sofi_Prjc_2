package com.stackroute.activitystream.servicesbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.servicesbackend.model.UserCircle;
@Repository(value="userCircleDao")
@Component
@Transactional
@EnableTransactionManagement
public class UserCircleDaoImpl implements UserCircleDao {
	@Autowired
	SessionFactory sessionFactory;
	private List<UserCircle> listOfUserCircle;
	
	public UserCircleDaoImpl() {
	}
	
	
	public UserCircleDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;	}
	
	@Override
	public boolean addUserCircle(UserCircle usercircle) {
		try{
			
			sessionFactory.getCurrentSession().save(usercircle);
			return true;
			}
			catch(Exception e){
			return false;}
	}
	

	@Override
	public boolean removeUserCircle(String userCircleId) {
		try{
			//should not be delete.  set status = U (unsubscribe)
			sessionFactory.getCurrentSession().delete(getUserCircleById(userCircleId));
			return true;
		}
		catch(Exception e){
		return false;}
	}

	@Override
	public List<UserCircle> getAllUserCircle() {
		try{	 		
			listOfUserCircle=sessionFactory.openSession().createQuery("from UserCircle").list();
				return listOfUserCircle;
			}
			catch(Exception e){
				return null;
			}
	}

	@Override
	public UserCircle getUserCircleById(String userCircleId) {
		try{
			return sessionFactory.getCurrentSession().get(UserCircle.class, userCircleId);
			}
			catch(Exception e){}
			return null;
	}

	@Override
	public boolean updateUserCircle(UserCircle circle) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(circle);
			return true;
		}
		catch(Exception e){
		return false;}
	}
}
