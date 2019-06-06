package fr.teamzi.dev.model;

import fr.teamzi.dev.utils.Utils;

public class Template {

	private Integer templateId;
	private Integer userId;
	private String templateName;
	private String data;
	private Boolean draftState;
	
	public Template(Integer templateId, Integer userId, String templateName, String data, Boolean draftState) {
		this.templateId = templateId;
		this.userId = userId;
		this.templateName = templateName;
		this.data = data;
		this.draftState = draftState;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Boolean getDraftState() {
		return draftState;
	}

	public void setDraftState(Boolean draftState) {
		this.draftState = draftState;
	}
	
	public String getRelativeUrl() {
		return "/template/" + this.templateId + "-" + Utils.cleanName(this.templateName);
	}
	
	
	
	
	
	
}
