package edu.deakin.sit218.examgeneration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idquestion")
	protected int id;
	
	@NotNull(message = "is required")
	@Size(min=1, message = "is required")
	@Column(name="questioncontent")
	protected String questioncontent;
	
	@NotNull(message = "is required")
	@Size(min=1, message = "is required")
	@Column(name="answer")
	protected String answer;
	
	@NotNull(message = "is required")
	@Size(min=1, message = "is required")
	@Column(name="knowledgearea")
	protected String knowledgearea;
	
	public Question() {
		
	}
		
	public Question(String question, String answer, String knowledgearea) {
		super();
		this.questioncontent = question;
		this.answer = answer;
		this.knowledgearea = knowledgearea;
	}
	
	public String getQuestioncontent() {
		return questioncontent;
	}

	public void setQuestioncontent(String questioncontent) {
		this.questioncontent = questioncontent;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getKnowledgearea() {
		return knowledgearea;
	}

	public void setKnowledgearea(String knowledgearea) {
		this.knowledgearea = knowledgearea;
	}

	public String toString() {
		return "question = [question content: "+ getQuestioncontent() + ", answer: "+ getAnswer() + ", knowledge area: "+ getKnowledgearea() + "]\n";
	}


}
