package jp.myapp.data.dao;

import jp.myapp.data.entity.Users;
import jp.myapp.data.entity.UsersImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsersDaoImpl implements UsersDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public UsersImpl get(String userId) {
        return (UsersImpl) this.sessionFactory.getCurrentSession().get(UsersImpl.class, userId);
    }

    @Override
    @Transactional
    public UsersImpl load(String userId) {
        return (UsersImpl) this.sessionFactory.getCurrentSession().load(UsersImpl.class, userId);
    }

    @Override
    @Transactional
    public void update(Users users) {
        this.sessionFactory.getCurrentSession().update(users);
    }
}
