package jp.myapp.controller.userdetails;

import java.util.Date;

public interface LoginUser {

    String getDisplayName();

    boolean isProvisionalRegistration();

    Date getLastLogin();

}
