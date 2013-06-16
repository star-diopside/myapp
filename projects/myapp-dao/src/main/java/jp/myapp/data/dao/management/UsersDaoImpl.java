package jp.myapp.data.dao.management;

import jp.myapp.data.entity.management.Users;

import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsersDaoImpl implements UsersDao {

    @Autowired
    @Qualifier("managementSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Users get(String userId) {
        return (Users) sessionFactory.getCurrentSession().get(Users.class, userId);
    }

    @Override
    @Transactional
    public Users load(String userId) {
        return (Users) sessionFactory.getCurrentSession().load(Users.class, userId);
    }

    @Override
    @Transactional
    public Users loadForUpdate(String userId) {
        return (Users) sessionFactory.getCurrentSession().load(Users.class, userId, LockOptions.UPGRADE);
    }

    @Override
    @Transactional
    public void update(Users users) {
        sessionFactory.getCurrentSession().update(users);
    }
}
