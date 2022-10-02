package edu.deakin.sit218.examgeneration.entity;

public class KnowledgeQuery {
	protected String knowledgearea;
	
	public KnowledgeQuery() {
		
	}
	
	public KnowledgeQuery(String knowledgearea) {
		super();
		this.knowledgearea = knowledgearea;
	}

	public String getKnowledgearea() {
		return knowledgearea;
	}

	public void setKnowledgearea(String knowledgearea) {
		this.knowledgearea = knowledgearea;
	}
	
	
}
