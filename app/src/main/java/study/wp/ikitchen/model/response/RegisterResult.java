package study.wp.ikitchen.model.response;

import study.wp.ikitchen.model.User;

/**
 * Created by wp on 2015-03-04.
 */
public class RegisterResult {
    private String status;
    private String errorMsg;
    private User user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
