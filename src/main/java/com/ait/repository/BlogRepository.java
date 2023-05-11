package com.ait.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entityclasses.Blogs;

public interface BlogRepository extends JpaRepository<Blogs, Integer>{

	List<Blogs> findByTitleContaining(String title);
}
