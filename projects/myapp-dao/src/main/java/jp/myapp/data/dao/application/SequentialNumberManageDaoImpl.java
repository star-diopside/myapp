package jp.myapp.data.dao.application;

import jp.myapp.data.entity.application.SequentialNumberManage;

import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 連番管理DAOクラス
 */
@Repository
public class SequentialNumberManageDaoImpl implements SequentialNumberManageDao {

    @Autowired
    @Qualifier("applicationSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public SequentialNumberManage lock(String sequentialClassId) {
        return (SequentialNumberManage) sessionFactory.getCurrentSession().load(SequentialNumberManage.class,
                sequentialClassId, LockOptions.UPGRADE);
    }

    @Override
    @Transactional
    public void update(SequentialNumberManage entity) {
        sessionFactory.getCurrentSession().update(entity);
    }
}
