package com.springapp.mvc.data.DAO.HibernateDAO;

import com.springapp.mvc.classes.User;
import com.springapp.mvc.data.DAO.InterfaceDAO.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анатолий on 13.02.2016.
 */
@Repository
public class HibernateUserDAO implements UserDAO {
    private SessionFactory sessionFactory;
    @Autowired
    public HibernateUserDAO(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    public class Pages{
        private List<User> users;
        private int pageCount;

        public Pages(List<User> users, int pageCount) {
            this.users = users;
            this.pageCount = pageCount;
        }

        public List<User> getUsers() {
            return users;
        }
        public int getPageCount() {
            return pageCount;
        }

    }
    @Override
    public Pages getUsersList(int page) {
        List<User> users=new ArrayList<User>();

        users=(List<User>)currentSession().createSQLQuery("SELECT * FROM user").addEntity(User.class).setFirstResult(page*5).setMaxResults(5).list();
        int pageCount=currentSession().createSQLQuery("SELECT * FROM user").addEntity(User.class).list().size();
        pageCount= (int) Math.ceil((double) pageCount/5);
        return new Pages(users, pageCount);
    }

    @Override
    public void deleteUser(long id) {
        currentSession().delete(new User(id));
    }

    @Override
    public void updateUser(User user) {
        currentSession().update(user);
    }

    @Override
    public void saveUser(User user) {
        currentSession().save(user);
    }

    @Override
    public Pages findUsers(String name, int page) {

        List<User> usersList = (List<User>)currentSession().createSQLQuery("SELECT * FROM user WHERE name LIKE :name").addEntity(User.class).setString("name", name).setFirstResult(page * 5).setMaxResults(5).list();
        int pageCount=currentSession().createSQLQuery("SELECT * FROM user WHERE name LIKE :name").addEntity(User.class).setString("name", name).list().size();
        pageCount= (int) Math.ceil((double) pageCount/5);
        return new Pages(usersList, pageCount);
    }
}
