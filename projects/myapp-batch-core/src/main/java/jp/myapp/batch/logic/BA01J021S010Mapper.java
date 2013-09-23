package jp.myapp.batch.logic;

import jp.myapp.batch.bean.PostalCodeAddress;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * 郵便番号データCSVファイルのマッピングを行う。
 */
public class BA01J021S010Mapper implements FieldSetMapper<PostalCodeAddress> {

    @Override
    public PostalCodeAddress mapFieldSet(FieldSet fieldSet) throws BindException {

        PostalCodeAddress item = new PostalCodeAddress();

        item.setLocalGovernmentCode(fieldSet.readString(0));
        item.setOldPostalCode(fieldSet.readString(1));
        item.setPostalCode(fieldSet.readString(2));
        item.setKanaPrefectureName(fieldSet.readString(3));
        item.setKanaMunicipalityName(fieldSet.readString(4));
        item.setKanaAreaName(fieldSet.readString(5));
        item.setKanjiPrefectureName(fieldSet.readString(6));
        item.setKanjiMunicipalityName(fieldSet.readString(7));
        item.setKanjiAreaName(fieldSet.readString(8));
        item.setFlag1(fieldSet.readString(9));
        item.setFlag2(fieldSet.readString(10));
        item.setFlag3(fieldSet.readString(11));
        item.setFlag4(fieldSet.readString(12));
        item.setFlag5(fieldSet.readString(13));
        item.setFlag6(fieldSet.readString(14));

        return item;
    }
}
