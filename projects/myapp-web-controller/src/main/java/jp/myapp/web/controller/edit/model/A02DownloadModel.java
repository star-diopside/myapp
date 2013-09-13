package jp.myapp.web.controller.edit.model;

import java.io.InputStream;

import jp.myapp.web.controller.edit.form.A02Form;

public interface A02DownloadModel {

    A02Form getA02Form();

    void setA02Form(A02Form a02Form);

    InputStream getInputStream();

    void setInputStream(InputStream inputStream);

    String getContentType();

    void setContentType(String contentType);

    String getContentDisposition();

    void setContentDisposition(String contentDisposition);

}
