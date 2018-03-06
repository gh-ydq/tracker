package com.tracker.web.service;

import com.querydsl.core.types.Predicate;
import com.tracker.web.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IUserService<T>
{
    public List<User> findAll();

    public void saveUser(User user);
   
    public User findOne(long id);

    public void delete(long id);

    public List<User> findByName(String name);

    Page<User> findAll(Integer page, Integer size);

    Page<User> findAllByCretiaPage(Integer page, Integer size,Predicate  predicate);

}