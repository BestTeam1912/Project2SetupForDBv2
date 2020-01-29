package hibernate_classreflection_test.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernate_classreflection_test.main.UserType;
import hibernate_classreflection_test.pojo.ActiveUser;
import hibernate_classreflection_test.pojo.Comment;
import hibernate_classreflection_test.pojo.Community;
import hibernate_classreflection_test.pojo.Thread;
import hibernate_classreflection_test.pojo.User;


public class Main {

	public static void main(String[] args) throws SQLException {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Community community = new Community();
		Thread thread = new Thread();
		Comment comment = new Comment();
		Comment comment1 = new Comment();
		Comment comment2 = new Comment();
		User user = new User();
		User user1 = new User();
		ActiveUser au = new ActiveUser();
		ActiveUser au1 = new ActiveUser();
		System.out.println("HI Relpy");
		Date date = new Date();
		
		user.setDateCreated(date);
		user.setUsername("user");
		user.setPassword("pass");
		user.setUserType(UserType.norm);
		user.setActiveUserList(new ArrayList<ActiveUser>());
		
		user1.setDateCreated(date);
		user1.setUsername("user");
		user1.setPassword("pass");
		user1.setUserType(UserType.norm);
		user1.setActiveUserList(new ArrayList<ActiveUser>());
		
		community.setId(10);
		community.setThreads(new ArrayList<Thread>());
		community.setTitle("Mice");
		community.setDescription("discuss mice");
		community.setDateCreated(date);
		
		thread.setId(11);
		thread.setTitle("Are they real");
		thread.setDescription("What happened to anyone");
		thread.setActiveUserList(new ArrayList<ActiveUser>());
		thread.setCommunity(community);
		
		au.setCharacterBank(500);
		au.setUser(user);
		au.setMythread(thread);
		
		au1.setCharacterBank(500);
		au1.setUser(user1);
		au1.setMythread(thread);
		
		comment.setText("Woot");
		comment.setThread(thread);
		comment.setUser(user);
		
		comment1.setText("toowoow");
		comment1.setThread(thread);
		comment1.setUser(user1);
		comment1.setReplyingTo(comment);
		comment2.setText("thr second repli");
		comment2.setThread(thread);
		comment2.setUser(user1);
		comment2.setReplyingTo(comment);
		
		comment.setReplies(new ArrayList<Comment>());
		List<Comment> commentList = comment.getReplies();
		commentList.add(comment1);
		commentList.add(comment2);
		comment.setReplies(commentList);
		
		List<ActiveUser> aul = thread.getActiveUserList();
		aul.add(au);
		aul.add(au1);
		thread.setActiveUserList(aul);
		
		List<Thread> threads = community.getThreads();
		threads.add(thread);
		community.setThreads(threads);
		
		session.save(community);
		session.save(thread);
		session.save(comment);
		session.save(comment1);
		session.save(comment2);
		session.save(user);
		session.save(au);
		session.save(user1);
		session.save(au1);
		
		transaction.commit();
		session.close();
		factory.close();
	}
}
