package com.ait.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ait.binding.CommentForm;
import com.ait.binding.PostForm;
import com.ait.entityclasses.Blogs;
import com.ait.entityclasses.Comments;
import com.ait.repository.BlogRepository;
import com.ait.service.BlogService;

@Controller
public class IndexController {

	@Autowired
	private HttpSession session;

	@Autowired
	private BlogService blogService;

	@Autowired
	private BlogRepository blogRepo;

	@GetMapping("/")
	public String indexPage() {

		return "index";
	}

	@GetMapping("/allPosts")
	public String allPostsPage(PostForm form, Model model) {

		List<Blogs> findAll = blogRepo.findAll();

		model.addAttribute("getPosts", findAll);

		return "allposts";
	}

	
	@GetMapping("/showPosts")
	public String showDeatiledPosts(@RequestParam Integer blogId, @ModelAttribute("form") CommentForm form,
			Model model) {

		session.setAttribute("blogId", blogId);

		Optional<Blogs> findByblogId = blogRepo.findById(blogId);

		if (findByblogId.isPresent()) {

			Blogs blogs = findByblogId.get();

			model.addAttribute("post", blogs);

			List<Comments> blogComments = blogService.getBlogComments(form);

			model.addAttribute("listOfComments", blogComments);
		}

		return "viewblogs";
	}

	@PostMapping("/PostComments")
	public String insertComments(@ModelAttribute("form") CommentForm form, Model model) {

		String peopleComments = blogService.peopleComments(form);

		model.addAttribute("peopleComments", peopleComments);

		Integer blogId = (Integer) session.getAttribute("blogId");

		Optional<Blogs> findByblogId = blogRepo.findById(blogId);

		if (findByblogId.isPresent()) {

			Blogs blogs = findByblogId.get();

			model.addAttribute("post", blogs);

		}
		return "viewblogs";

	}

	@GetMapping("/Postssearch")
	public String search(@RequestParam("title") String title, Model model) {
		List<Blogs> titleContaining = blogRepo.findByTitleContaining(title);

		model.addAttribute("getPosts", titleContaining);

		return "allposts";

	}

}
