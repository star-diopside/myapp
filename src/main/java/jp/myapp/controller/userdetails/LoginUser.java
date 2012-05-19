package jp.myapp.controller.userdetails;

import java.sql.Timestamp;

public interface LoginUser {

    String getDisplayName();

    boolean isProvisionalRegistration();

    Timestamp getLastLogin();

}
