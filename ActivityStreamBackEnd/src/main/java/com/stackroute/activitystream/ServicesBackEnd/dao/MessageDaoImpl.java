package com.stackroute.activitystream.ServicesBackEnd.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.ServicesBackEnd.model.Message;
import com.stackroute.activitystream.ServicesBackEnd.model.Outbox;
import com.stackroute.activitystream.ServicesBackEnd.model.User;
import com.stackroute.activitystream.ServicesBackEnd.model.UserCircle;
import com.stackroute.activitystream.ServicesBackEnd.model.UserMessage;

@Repository(value="messageDao")
@Component
@Transactional
@EnableTransactionManagement
public class MessageDaoImpl implements MessageDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	private UserMessageDao userMessageDao;
	private Outbox outbox=new Outbox();
	
	public MessageDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean sendMessage(Message message) {
		try{
			Session sess=sessionFactory.getCurrentSession();
			sess.save(message);
			outbox.setCircleId(message.getCircleId());
			outbox.setDateOfMessage(message.getDateOfMessage());
			outbox.setMessageContent(message.getMessageContent());
			outbox.setMessageId(message.getMessageId());
			outbox.setMessageSize(message.getMessageSize());
			outbox.setMessageType(message.getMessageType());
			outbox.setReceiverId(message.getReceiverId());
			outbox.setSenderId(message.getSenderId());
			sendMessageToOutbox(outbox);
			if(message.getCircleId()!=null){
				Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserCircle.class);
				cr.add(Restrictions.eq("circleId", message.getCircleId()));
				int userCountInCircle = cr.list().size();
				System.out.println(userCountInCircle);
				
				for(int i=1;i<userCountInCircle;i++){
					UserMessage inbox=new UserMessage();
					inbox.setCircleId(message.getCircleId());
					inbox.setDateOfMessage(message.getDateOfMessage());
					inbox.setMessageContent(message.getMessageContent());
					inbox.setMessageSize(message.getMessageSize());
					inbox.setMessageType(message.getMessageType());
					inbox.setReceiverId(message.getReceiverId());
					inbox.setSenderId(message.getSenderId());
					sendMessageToInbox(inbox);
				}
			}
			else{
				UserMessage inbox=new UserMessage();
				inbox.setCircleId(message.getCircleId());
				inbox.setDateOfMessage(message.getDateOfMessage());
				inbox.setMessageContent(message.getMessageContent());
				inbox.setMessageSize(message.getMessageSize());
				inbox.setMessageType(message.getMessageType());
				inbox.setReceiverId(message.getReceiverId());
				inbox.setSenderId(message.getSenderId());
				sendMessageToInbox(inbox);
			}
			return true;

			}
			catch(Exception e){
			return false;}
	}

	//it should be private method
@Override
public boolean sendMessageToInbox(UserMessage message) {
	try{
		sessionFactory.getCurrentSession().saveOrUpdate(message);
		
		return true;
		}
		catch(Exception e){
		return false;}
}

	//it should be private method
@Override
public boolean sendMessageToOutbox(Outbox message) {
	try{
		sessionFactory.getCurrentSession().saveOrUpdate(message);
		
		return true;
		}
		catch(Exception e){
		return false;}
}


	@Override
	public List<Message> getMessageFromUser(String senderID) {
		try{
			List<Message> results=  sessionFactory.getCurrentSession().createQuery("from Message m where m.senderId=:sid").setParameter("sid", senderID).list();
		
			System.out.println(results.get(0));
			return results;
			}
			catch(Exception e){
				return null;
			}
	}

	@Override
	public List<Message> getMessageFromCircle(String circleID) {
		try{
			List<Message> results= sessionFactory.getCurrentSession().createQuery("from Message m where m.circleId=:cid").setParameter("cid", circleID).list();
		
			System.out.println(results.get(0));
			return results;
			}
			catch(Exception e){
				return null;
			}
	}
	
	
	public boolean deleteSenderMessageInCircle(String messageId){
		try{
			sessionFactory.getCurrentSession().createQuery("delete UserMessage where messageId = :ID").setParameter("ID", Integer.parseInt(messageId)).executeUpdate();
			//System.out.println(getMessageById(msgId));
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		return false;}
	}
	
	public boolean deleteSenderMessageInChat(String messageId){
		try{
			sessionFactory.getCurrentSession().createQuery("delete UserMessage where messageId = :ID").setParameter("ID", Integer.parseInt(messageId)).executeUpdate();
			//System.out.println(getMessageById(msgId));
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		return false;}
	}
	
}
