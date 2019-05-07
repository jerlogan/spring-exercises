package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
//    public Post findOne(long id){
//        return postsDao.findOne(id); // select * from posts where id = ?
//    }
//
//    public Post save(Post post){
//        postsDao.save(post); // insert into posts(title, body) values (?, ?)
//        return post;
//    }
//
//    public void deletePost(long id){
//        postsDao.delete(id);
//    }
}
