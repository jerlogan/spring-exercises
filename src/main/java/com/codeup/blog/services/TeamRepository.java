package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.Team;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface  TeamRepository extends CrudRepository<Team, Long> {

//    @Query("from teams where team_name = name")
//    Set<Team> searchTeamByTeamName(@Param("name") String name);
//

}