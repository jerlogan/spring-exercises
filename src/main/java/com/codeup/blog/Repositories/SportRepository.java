package com.codeup.blog.Repositories;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.Sport;
import org.springframework.data.repository.CrudRepository;

public interface  SportRepository extends CrudRepository<Sport, Long> {

}