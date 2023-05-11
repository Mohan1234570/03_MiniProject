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

}
