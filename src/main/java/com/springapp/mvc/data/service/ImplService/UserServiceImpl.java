package com.springapp.mvc.data.service.ImplService;

import com.springapp.mvc.classes.User;
import com.springapp.mvc.data.DAO.HibernateDAO.HibernateUserDAO;
import com.springapp.mvc.data.DAO.InterfaceDAO.UserDAO;
import com.springapp.mvc.data.service.InrerfaceService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Анатолий on 13.02.2016.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO hibernateUserDAO;

    @Override
    public HibernateUserDAO.Pages getUsersList(int page) {
        return hibernateUserDAO.getUsersList(page);
    }

    @Override
    public void deleteUser(long id) {
        hibernateUserDAO.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        hibernateUserDAO.updateUser(user);
    }

    @Override
    public void saveUser(User user) {
        hibernateUserDAO.saveUser(user);
    }

    @Override
    public HibernateUserDAO.Pages findUsers(String name, int page) {
        return hibernateUserDAO.findUsers(name, page);
    }
}
