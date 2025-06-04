package com.ait.entityclasses;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "comment_tbl")
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;
	
	private String name;
	private String email;
	
	@Lob
	private String comment;
	
	@CreationTimestamp
	private LocalDate createdOn;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "blogId")
	private Blogs blogDetails;


	// === Default Constructor ===
	public Comments() {
	}

	// === All-Arguments Constructor ===
	public Comments(Integer commentId, String name, String email, String comment, LocalDate createdOn, Blogs blogDetails) {
		this.commentId = commentId;
		this.name = name;
		this.email = email;
		this.comment = comment;
		this.createdOn = createdOn;
		this.blogDetails = blogDetails;
	}

	// === Getters and Setters ===

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public Blogs getBlogDetails() {
		return blogDetails;
	}

	public void setBlogDetails(Blogs blogDetails) {
		this.blogDetails = blogDetails;
	}
	

}
