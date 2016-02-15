package com.springapp.mvc.data.service.InrerfaceService;

import com.springapp.mvc.classes.User;
import com.springapp.mvc.data.DAO.HibernateDAO.HibernateUserDAO;

import java.util.List;

/**
 * Created by �������� on 13.02.2016.
 */
public interface UserService {
    HibernateUserDAO.Pages getUsersList(int page);
    void deleteUser(long id);
    void updateUser(User user);
    void saveUser(User user);
    HibernateUserDAO.Pages findUsers(String name, int page);
}
