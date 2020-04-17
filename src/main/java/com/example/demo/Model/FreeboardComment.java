package com.example.demo.Model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="freeboardcommnet")
public class FreeboardComment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentid;
	public Long getCommentid() {
		return commentid;
	}

	public void setCommentid(Long commentid) {
		this.commentid = commentid;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public LocalDateTime getWirteData() {
		return wirteData;
	}


	public void setWirteData(LocalDateTime wirteData) {
		this.wirteData = wirteData;
	}


	public String getWirter() {
		return wirter;
	}


	public void setWirter(String wirter) {
		this.wirter = wirter;
	}


	public long getCommentOriginId() {
		return commentOriginId;
	}


	public void setCommentOriginId(long commentOriginId) {
		this.commentOriginId = commentOriginId;
	}


	public int getCommentlevel() {
		return commentlevel;
	}


	public void setCommentlevel(int commentlevel) {
		this.commentlevel = commentlevel;
	}


	public long getFreeid() {
		return freeid;
	}


	public void setFreeid(long freeid) {
		this.freeid = freeid;
	}


	@Column(name="content")
	private String content;
	@Column(name="wirtedata")
	private LocalDateTime wirteData;
	@Column(name="wirter")
	private String wirter;
	@Column(name="commentoriginid")
	private long commentOriginId;
	@Column(name="commentlevel")
	private int commentlevel;
	
	
//	@ManyToOne(targetEntity = Freeboard.class)
	//@JoinColumn(foreignKey = @ForeignKey(name="freeid")) // 몇번글에 달린 댓글인지 알기위해  join 컬럼사용
	private long freeid;
}
