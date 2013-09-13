package jp.myapp.web.controller.common.form;

import java.util.List;

import org.apache.commons.collections.KeyValue;

public interface LocaleForm {

    String getLanguage();

    List<KeyValue> getLanguageList();

    void setLanguage(String language);

}
