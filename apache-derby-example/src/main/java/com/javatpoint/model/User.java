package com.javatpoint.model;

public class User {
	private Name name;
	private String _id;
	private String photo;

	public User() {

	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", _id=" + _id + ", photo=" + photo + "]";
	}

	
}
