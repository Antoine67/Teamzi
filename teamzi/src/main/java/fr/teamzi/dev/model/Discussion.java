package fr.teamzi.dev.model;

public class Discussion {
	private Integer discussionId;
	private Integer documentId;
	
	public Discussion(Integer discussionId, Integer documentId) {
		this.discussionId = discussionId;
		this.documentId = documentId;
	}
	public Integer getDiscussionId() {
		return discussionId;
	}
	public void setDiscussionId(Integer discussionId) {
		this.discussionId = discussionId;
	}
	public Integer getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}
	
	
	
}
