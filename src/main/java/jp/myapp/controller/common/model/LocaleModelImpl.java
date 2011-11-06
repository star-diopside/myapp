package jp.myapp.controller.common.model;

import java.io.Serializable;

import jp.myapp.controller.common.form.LocaleForm;
import jp.myapp.controller.common.form.LocaleFormImpl;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class LocaleModelImpl implements LocaleModel, Serializable {

    private static final long serialVersionUID = 1L;

    private LocaleForm localeForm = new LocaleFormImpl();

    @Override
    public LocaleForm getLocaleForm() {
        return this.localeForm;
    }

    @Override
    public void setLocaleForm(LocaleForm localeForm) {
        this.localeForm = localeForm;
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
