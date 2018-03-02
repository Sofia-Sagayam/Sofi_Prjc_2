package com.stackroute.activitystream.servicesbackend.dao;



import com.stackroute.activitystream.servicesbackend.model.Circle;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


@Repository(value="circleDao")
@Component
@Transactional
@EnableTransactionManagement
public class CircleDaoImpl implements CircleDao {
	@Autowired
	SessionFactory sessionFactory;	
	private List<Circle> listOfCircle;
	public CircleDaoImpl(){
		
	}
	
	public CircleDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean addCircle(Circle circle) {
		try{
			circle.setCircleInit(new Date());
			circle.setCircleStatus(true);
			sessionFactory.getCurrentSession().save(circle);
			return true;
			}
			catch(Exception e){
			return false;}
	}

	public boolean removeCircle(String circleId) {
		try{
			sessionFactory.getCurrentSession().delete(getCircleById(circleId));
			return true;
		}
		catch(Exception e){
		return false;}
	}

	public List<Circle> getAllCircle() {
		try{	 		
		listOfCircle=sessionFactory.openSession().createQuery("from Circle").list();
			return listOfCircle;
		}
		catch(Exception e){
			return null;
		}
		
	}

	public Circle getCircleById(String circleId) {
		try{
			return sessionFactory.getCurrentSession().get(Circle.class, circleId);
			}
			catch(Exception e){}
			return null;
	}
	
	public boolean updateCircle(Circle circle) {
		
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(circle);
			return true;
		}
		catch(Exception e){
		return false;}
		}
}
