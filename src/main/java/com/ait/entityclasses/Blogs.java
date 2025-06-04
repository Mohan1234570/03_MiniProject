package com.ait.entityclasses;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "blog_tbl")
public class Blogs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer blogId;

	private String title;
	private String description;
	
	@Lob
	private String content;
	
	@CreationTimestamp
	private LocalDate createdOn;
	
	@UpdateTimestamp
	private LocalDate updatedOn;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private UserDetails userDetails;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "blogDetails")
	private List<Comments> CommentDetails;

	// === Default Constructor ===
	public Blogs() {
	}

	// === All-Args Constructor ===
	public Blogs(Integer blogId, String title, String description, String content,
				 LocalDate createdOn, LocalDate updatedOn,
				 UserDetails userDetails, List<Comments> commentDetails) {
		this.blogId = blogId;
		this.title = title;
		this.description = description;
		this.content = content;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.userDetails = userDetails;
		this.CommentDetails = commentDetails;
	}

	// === Getters & Setters ===

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public List<Comments> getCommentDetails() {
		return CommentDetails;
	}

	public void setCommentDetails(List<Comments> commentDetails) {
		this.CommentDetails = commentDetails;
	}
}
