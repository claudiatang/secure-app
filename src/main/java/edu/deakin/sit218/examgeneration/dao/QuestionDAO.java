package edu.deakin.sit218.examgeneration.dao;

import java.util.List;

import edu.deakin.sit218.examgeneration.entity.Question;

public interface QuestionDAO {
	
	public void updateQuestion(Question question);

	public void insertQuestion(Question question);
	
	public Question retrieveQuestion(Question question);

	public List<Question> retrieveQuestions(String knowledgearea);

	public boolean existsQuestion(Question question);
	
}
