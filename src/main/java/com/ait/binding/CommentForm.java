package com.ait.binding;

import javax.persistence.Lob;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentForm {
	
	private Integer commentId;
	private String name;
	private String email;
	
	@Lob
	private String comment;

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

}
