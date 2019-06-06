package fr.teamzi.dev.model;

public class DocumentsAccess {
 
	private Integer documentId;
    private Integer userId;

    public DocumentsAccess() {}
    
    public DocumentsAccess(Integer documentId, Integer userId) {
		this.documentId = documentId;
		this.userId = userId;
	}


	public Integer getDocumentId() {
		return documentId;
	}


	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	

	
   
}