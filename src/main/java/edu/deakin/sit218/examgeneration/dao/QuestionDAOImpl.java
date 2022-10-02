package edu.deakin.sit218.examgeneration.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import edu.deakin.sit218.examgeneration.entity.Question;


public class QuestionDAOImpl implements QuestionDAO{
	
	SessionFactory factory;

	public QuestionDAOImpl() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.buildSessionFactory();
	}
	
	public void updateQuestion(Question question) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(question);
			session.getTransaction().commit();
		}
		finally {
			session.close();
		}	
	}

	public void insertQuestion(Question question) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(question);
			session.getTransaction().commit();
		}
		finally {
			session.close();
		}	
	}
	
	public Question retrieveQuestion(Question question) {
		Session session = factory.getCurrentSession();
		try {
			//use the session object to check for a question
			//start a transaction
			session.beginTransaction();
			
			//create the query concatenate
			//String hql = "from Question where questioncontent = '"+ question.getQuestioncontent() +"'";
			//Query<Question> query = session.createQuery(hql);
			
			// create query parameterised
			String questionContent = question.getQuestioncontent();
			Query<Question> query = session.createQuery("from Question where questioncontent = :questionContent");
			query.setParameter("questionContent", questionContent);
			
			//Obtain the query results
			List<Question> questions = query.getResultList();
			if (questions.isEmpty()) {
				throw new RuntimeException("There is no client: "+ question.toString());
			}
			else if (questions.size() > 1) { 
				throw new RuntimeException("More than one client: "
						+ question.toString() +" exists");
			}
			else {
				return questions.get(0);
			}
		}
		finally {
			session.close();
		}
	}

	public List<Question> retrieveQuestions(String knowledgearea) {
		Session session = factory.getCurrentSession();
		try {
			//use the session object to check for a question
			//start a transaction
			session.beginTransaction();
			
			//create the query
			Query<Question> query = session.createQuery("from Question where knowledgearea = :knowledgearea");
			query.setParameter("knowledgearea", knowledgearea);
			//Obtain the query results
			List<Question> questions = query.getResultList();
			if (questions.isEmpty()) {
				throw new RuntimeException("There is no knowledge area of "+ knowledgearea);
			}
			else {
				return questions;
			}
		}
		finally {
			session.close();
		}
	}

	public boolean existsQuestion(Question question) {
		Session session = factory.getCurrentSession();		
		try {
			session.beginTransaction();
			//create the query
			String hql = "from Question where questioncontent = '"+ question.getQuestioncontent() +"'";
			Query<Question> query = session.createQuery(hql);
			//Obtain the query results
			List<Question> clients = query.getResultList();
			return !clients.isEmpty();
		}
		finally {
			session.close();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		//Close session factory before destroying the object
		factory.close();
	}
	
}
