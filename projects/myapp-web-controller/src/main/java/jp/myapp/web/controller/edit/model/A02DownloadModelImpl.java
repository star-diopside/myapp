package jp.myapp.web.controller.edit.model;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.core.logging.Loggable;
import jp.myapp.core.logging.LoggableUtil;
import jp.myapp.web.controller.edit.form.A02Form;
import jp.myapp.web.controller.edit.form.A02FormImpl;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class A02DownloadModelImpl implements A02DownloadModel, Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    private A02Form a02Form = new A02FormImpl();
    private InputStream inputStream;
    private String contentType = "application/octet-stream";
    private String contentDisposition = "attachment";

    @Override
    public A02Form getA02Form() {
        return a02Form;
    }

    @Override
    public void setA02Form(A02Form a02Form) {
        this.a02Form = a02Form;
    }

    @Override
    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String getContentDisposition() {
        return contentDisposition;
    }

    @Override
    public void setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, this.a02Form, "a02Form");

        return null;
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
