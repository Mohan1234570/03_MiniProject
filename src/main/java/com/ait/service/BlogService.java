package com.ait.service;

import java.util.List;

import com.ait.binding.CommentForm;
import com.ait.binding.LoginForm;
import com.ait.binding.PostForm;
import com.ait.binding.RegisterForm;
import com.ait.entityclasses.Blogs;
import com.ait.entityclasses.Comments;

public interface BlogService {

	public boolean saveUserDetails(RegisterForm form);

	public boolean userLogin(LoginForm login);

	public String userPost(PostForm post);

	List<Blogs> getPosts(PostForm form);

	public String peopleComments(CommentForm form);

	List<Comments> getComments(CommentForm form);
	
	List<Comments> getBlogComments(CommentForm form);
	
	//List<Blogs> getSearchPosts(PostForm form);

}
