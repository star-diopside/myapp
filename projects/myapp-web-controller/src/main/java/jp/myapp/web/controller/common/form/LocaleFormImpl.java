package jp.myapp.web.controller.common.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.collections.KeyValue;
import org.apache.commons.collections.keyvalue.DefaultKeyValue;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.I18nInterceptor;
import com.opensymphony.xwork2.util.LocalizedTextUtil;

public class LocaleFormImpl implements LocaleForm, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String getLanguage() {

        return ActionContext.getContext().getLocale().getLanguage();
    }

    @Override
    public List<KeyValue> getLanguageList() {

        List<KeyValue> list = new ArrayList<KeyValue>();

        list.add(new DefaultKeyValue("ja", "Japanese"));
        list.add(new DefaultKeyValue("en", "English"));

        return list;
    }

    @Override
    public void setLanguage(String language) {

        Locale locale = LocalizedTextUtil.localeFromString(language, null);
        ActionContext context = ActionContext.getContext();

        context.setLocale(locale);
        context.getSession().put(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE, locale);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, true);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, true);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
