package com.stackroute.activitystream.ServicesBackEnd.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.ServicesBackEnd.model.Circle;
import com.stackroute.activitystream.ServicesBackEnd.model.Message;
import com.stackroute.activitystream.ServicesBackEnd.model.Outbox;
import com.stackroute.activitystream.ServicesBackEnd.model.UserMessage;


@Repository(value="userMessageDao")
@Component
@Transactional
@EnableTransactionManagement
public class UserMessageDaoImpl implements UserMessageDao {
	@Autowired
	SessionFactory sessionFactory;
	
	
	public UserMessageDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean sendMessage(UserMessage message) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(message);
			
			return true;
			}
			catch(Exception e){
			return false;}
	}
	
	@Override
	public boolean sendMessage(Outbox message) {
		try{
			sessionFactory.getCurrentSession().save(message);
			
			return true;
			}
			catch(Exception e){
			return false;}
	}

	@Override
	public UserMessage getMessageFromUser(String receiverId) {
		try{
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserMessage.class);
			cr.add(Restrictions.eq("receiverId", receiverId));
			List<UserMessage> message = cr.list();
			return message.get(0);	
				}
		catch(Exception e){
			return null;
		}
	}

	@Override
	public UserMessage getMessageFromCircle(String circleID) {
		try{
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserMessage.class);
			cr.add(Restrictions.eq("circleID", circleID));
			List<UserMessage> message = cr.list();
			return message.get(0);		
					}
			catch(Exception e){
				return null;
			}
	}

	


}
