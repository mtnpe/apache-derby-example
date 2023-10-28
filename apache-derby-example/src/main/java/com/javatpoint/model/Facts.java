package com.javatpoint.model;

import java.util.Date;

public class Facts {

	private StatusFacts status;
	private String _id;
	private int __v;
	private String text;
	private Date updatedAt;
	private Date createdAt;
	private Boolean deleted;
	private String type;
	private User user;

	public Facts() {

	}

	public StatusFacts getStatus() {
		return status;
	}

	public void setStatus(StatusFacts status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int get__v() {
		return __v;
	}

	public void set__v(int __v) {
		this.__v = __v;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Facts [status=" + status + ", _id=" + _id + ", __v=" + __v + ", text=" + text + ", updatedAt="
				+ updatedAt + ", createdAt=" + createdAt + ", deleted=" + deleted + ", type=" + type + ", user=" + user
				+ "]";
	}
	

}
