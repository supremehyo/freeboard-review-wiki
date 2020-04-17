package com.example.demo.wikimodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "debate")
public class Debate implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private long debateid;

	public long getDebateid() {
		return debateid;
	}
	public void setDebateid(long debateid) {
		this.debateid = debateid;
	}
	@Column(name="debatetitle")
	private String debatetitle;

	private String content;
	

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getDebatetitle() {
		return debatetitle;
	}
	public void setDebatetitle(String debatetitle) {
		this.debatetitle = debatetitle;
	}

}
