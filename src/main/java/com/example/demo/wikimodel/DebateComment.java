package com.example.demo.wikimodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Currency;

@Entity
@Table(name = "debateComment")
public class DebateComment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String nickname;
	public String content;
	@Column(name = "debateid")
	public long debateid;
	
	public long getDebateid() {
		return debateid;
	}
	public void setDebateid(long debateid) {
		this.debateid = debateid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
