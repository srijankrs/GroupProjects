package com.example.barteringandtrading.Dao;

import com.example.barteringandtrading.Model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository("UserDAO")
public class UserDAOImplement implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int saveAdminDetail(User user) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            return (Integer) session.save(user);
        } catch (Exception e) {
            log.error("Exception while saving admin Details : {}", e.getMessage());
            return 0;
        } finally {
            assert session != null;
            session.flush();
        }
    }

    @Override
    public int adminLogin(String emailId, String password) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            Query query = session.createQuery("from User where emailId=:emailId and password=:password", User.class);
            query.setParameter("emailId", emailId);
            query.setParameter("password", password);
            List<User> list = query.list();

            int size = list.size();
            if (size == 1) {
                return list.get(0).getId();
            } else {
                return -1;
            }
        } catch (Exception exception) {
            log.error("Exception while saving admin Details : {}", exception.getMessage());
            return 0;
        } finally {
            assert session != null;
            session.flush();
        }
    }

    @Override
    public List<User> getAdminData() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            Query<User> query = session.createQuery("from User",User.class);
            List<User> list = query.list();

            if (list.size() > 0) {
                return list;
            } else {
                return null;
            }

        } catch (Exception exception) {
            log.error("Exception while saving admin Details :{} ", exception.getMessage());
            return null;
        }
        finally
        {
            assert session != null;
            session.flush();
        }
    }
}