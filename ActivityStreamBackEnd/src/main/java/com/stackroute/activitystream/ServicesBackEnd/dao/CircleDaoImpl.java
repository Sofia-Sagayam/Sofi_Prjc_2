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
	//why default access specifier?
	@Autowired
	SessionFactory sessionFactory;	
	private List<Circle> listOfCircle;
	public CircleDaoImpl(){
		
	}
	
	public CircleDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

<<<<<<< HEAD
	public boolean addCircle(Circle circle) {
=======
	//What is c?
	public boolean addCircle(Circle c) {
>>>>>>> 510ac28f9ce32f7248135fde80af97a7e75898fb
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
			//What is the use of circleStatus field if you delete from the db?
			sessionFactory.getCurrentSession().delete(getCircleById(circleId));
			return true;
		}
		catch(Exception e){
		return false;}
	}

	public List<Circle> getAllCircle() {
		try{	 		
			//Should get only active circles,  not all circles.
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
