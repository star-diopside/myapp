package jp.myapp.service;

import java.sql.Timestamp;
import java.text.DecimalFormat;

import jp.myapp.data.dao.application.SequentialNumberManageDao;
import jp.myapp.data.entity.application.SequentialNumberManage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 連番生成処理クラス
 */
@Service
public class SequentialNumberGeneratorImpl implements SequentialNumberGenerator {

    @Autowired
    private SequentialNumberManageDao sequentialNumberManageDao;

    /**
     * {@inheritDoc}<br>
     * 本メソッドは新規トランザクション内で処理を行う。
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String generate(String sequentialClassId) {

        // 連番管理テーブルを行ロックする。
        SequentialNumberManage entity = sequentialNumberManageDao.lock(sequentialClassId);

        // 連番値を取得する。
        int value = entity.getSequentialValue();

        // 連番文字列を生成する。
        StringBuilder sb = new StringBuilder();

        sb.append(StringUtils.defaultString(entity.getPrefix()));
        sb.append(new DecimalFormat(StringUtils.repeat('0', entity.getDigits())).format(value));
        sb.append(StringUtils.defaultString(entity.getSuffix()));

        // 連番値をインクリメントする。
        value++;

        // 連番管理テーブルを更新する。
        Timestamp current = new Timestamp(System.currentTimeMillis());
        entity.setSequentialValue(value);
        entity.setUpdatedTimestamp(current);
        entity.setUpdatedUserId("SYSTEM");
        sequentialNumberManageDao.update(entity);

        return sb.toString();
    }
}
