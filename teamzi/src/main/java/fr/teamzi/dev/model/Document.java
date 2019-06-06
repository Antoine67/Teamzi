package fr.teamzi.dev.model;

import fr.teamzi.dev.utils.Utils;

public class Document {
 
	private Integer documentId;
    private Integer creatorId;
    private Integer templateId;
    private String data;
    private String documentName;

 
    public Document() {}

	public Document(Integer documentId, Integer creatorId, String documentName, Integer templateId, String data) {
		this.documentId = documentId;
		this.creatorId = creatorId;
		this.documentName = documentName;
		this.templateId = templateId;
		this.data = data;
		
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	
	
	public String getRelativeUrl() {
		return "/document/" + this.documentId + "-" + Utils.cleanName(this.documentName);
	}

   
}