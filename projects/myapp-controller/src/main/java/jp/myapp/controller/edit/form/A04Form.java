package jp.myapp.controller.edit.form;

import java.io.File;

public interface A04Form {

    File getUploadFile();

    void setUploadFile(File uploadFile);

    String getUploadFileContentType();

    void setUploadFileContentType(String uploadFileContentType);

    String getUploadFileFileName();

    void setUploadFileFileName(String uploadFileFileName);

}
