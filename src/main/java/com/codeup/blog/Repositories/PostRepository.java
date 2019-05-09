package com.codeup.blog.Repositories;

import com.codeup.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface  PostRepository extends CrudRepository<Post, Long> {

}
