package com.ait.binding;

import javax.persistence.Lob;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostForm {
	
	private Integer blogId;
	private String title;
	private String description;
	
	@Lob
	private String content;
//
//	public Integer getBlogId() {
//		return blogId;
//	}
//
//	public void setBlogId(Integer blogId) {
//		this.blogId = blogId;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}

}
