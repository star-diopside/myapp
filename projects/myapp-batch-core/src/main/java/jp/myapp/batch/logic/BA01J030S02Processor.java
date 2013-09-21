package jp.myapp.batch.logic;

import java.sql.Timestamp;

import jp.myapp.batch.bean.PostalCodeAddress;
import jp.myapp.data.entity.application.PostalCode;

import org.springframework.batch.item.ItemProcessor;

/**
 * 郵便番号データファイルの情報を郵便番号テーブルのエンティティオブジェクトに変換する。
 */
public class BA01J030S02Processor implements ItemProcessor<PostalCodeAddress, PostalCode> {

    /** 現在の郵便番号テーブルレコードID */
    private int currentId = 0;

    @Override
    public PostalCode process(PostalCodeAddress item) throws Exception {

        PostalCode entity = new PostalCode();
        Timestamp current = new Timestamp(System.currentTimeMillis());

        entity.setId(currentId++);
        entity.setLocalGovernmentCode(item.getLocalGovernmentCode());
        entity.setPostalCode(item.getPostalCode());
        entity.setKanaPrefectureName(item.getKanaPrefectureName());
        entity.setKanaMunicipalityName(item.getKanaMunicipalityName());
        entity.setKanaAreaName(item.getKanaAreaName());
        entity.setKanjiPrefectureName(item.getKanjiPrefectureName());
        entity.setKanjiMunicipalityName(item.getKanjiMunicipalityName());
        entity.setKanjiAreaName(item.getKanjiAreaName());
        entity.setRegisterTimestamp(current);
        entity.setRegisterUserId("BA01J030");
        entity.setUpdatedTimestamp(current);
        entity.setUpdatedUserId("BA01J030");
        entity.setVersion(0);

        return entity;
    }
}
