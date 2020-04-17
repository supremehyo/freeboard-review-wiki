package com.example.demo.wikimodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "wikidocument")
public class Wikidocument implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="documentId")
	private long documentId;
	private String content;
	private String title;
	private int linktitle;
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@OneToMany(fetch=FetchType.EAGER ,cascade = CascadeType.ALL)
	@JoinColumn(name="debateId")
	private Collection<Debate> debateList;
	
	public Collection<Debate> getDebateList() {
		return debateList;
	}
	public void setDebateList(List<Debate> debateList) {
		this.debateList = debateList;
	}
	public long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLinktitle() {
		return linktitle;
	}
	public void setLinktitle(int linktitle) {
		this.linktitle = linktitle;
	}

	public void addDabate(Debate debate) {
		if(debateList == null) {
			debateList = new ArrayList<Debate>();
		}
		debateList.add(debate);
	}
	
	


}
