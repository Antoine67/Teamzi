package fr.teamzi.dev.model;

import java.util.Date;

public class Message {
	private Integer messageId;
	private Integer discussionId;
	private Integer userId;
	private String content;
	private Date date;
	
	public Message(Integer messageId, Integer discussionId, Integer userId, String content, Date date) {
		this.messageId = messageId;
		this.discussionId = discussionId;
		this.userId = userId;
		this.content = content;
		this.date = date;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getDiscussionId() {
		return discussionId;
	}
	public void setDiscussionId(Integer discussionId) {
		this.discussionId = discussionId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
