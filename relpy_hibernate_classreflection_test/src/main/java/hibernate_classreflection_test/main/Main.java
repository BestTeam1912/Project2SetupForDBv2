package hibernate_classreflection_test.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernate_classreflection_test.pojo.ActiveUser;
import hibernate_classreflection_test.pojo.Comment;
import hibernate_classreflection_test.pojo.Community;
import hibernate_classreflection_test.pojo.Thread;
import hibernate_classreflection_test.pojo.User;

public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		
		Community community = new Community();
		Thread thread = new Thread();
		Comment comment = new Comment();
		User user = new User();
		ActiveUser activeUser = new ActiveUser();
		System.out.println("HI Relpy");
		
		session.save(community);
		session.save(thread);
		session.save(comment);
		session.save(user);
		session.save(activeUser);
		
		transaction.commit();
		session.close();
		factory.close();
	}
}
