package jp.myapp.data.dao.application;

import jp.myapp.data.entity.application.SequentialNumberManage;

/**
 * 連番管理DAOインタフェース
 */
public interface SequentialNumberManageDao {

    /**
     * 主キーで検索を行い、行ロックを行う。
     * 
     * @param sequentialClassId 連番区分ID
     * @return 連番管理エンティティ
     */
    SequentialNumberManage lock(String sequentialClassId);

    /**
     * 更新を行う。
     * 
     * @param entity 連番管理エンティティ
     */
    void update(SequentialNumberManage entity);

}
