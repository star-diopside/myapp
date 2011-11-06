package jp.myapp.controller.edit.form;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.util.Loggable;
import jp.myapp.util.LoggableUtil;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class A04FormImpl implements A04Form, Loggable, Serializable {

    private static final long serialVersionUID = -5126391020712898082L;

    private File uploadFile;
    private String uploadFileContentType;
    private String uploadFileFileName;

    @Override
    public File getUploadFile() {
        return this.uploadFile;
    }

    @Override
    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    @Override
    public String getUploadFileContentType() {
        return this.uploadFileContentType;
    }

    @Override
    public void setUploadFileContentType(String uploadFileContentType) {
        this.uploadFileContentType = uploadFileContentType;
    }

    @Override
    public String getUploadFileFileName() {
        return this.uploadFileFileName;
    }

    @Override
    public void setUploadFileFileName(String uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }

    @Override
    public Collection<String> getLogText() {

        ArrayList<String> list = new ArrayList<String>();

        LoggableUtil.addLog(list, this.uploadFile, "uploadFile");
        LoggableUtil.addLog(list, this.uploadFileContentType, "uploadFileContentType");
        LoggableUtil.addLog(list, this.uploadFileFileName, "uploadFileFileName");

        return list;
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
