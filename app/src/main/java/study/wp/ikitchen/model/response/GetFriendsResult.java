package study.wp.ikitchen.model.response;

import java.util.List;

import study.wp.ikitchen.model.User;

/**
 * Created by wp on 2015-03-27.
 */
public class GetFriendsResult {
    String status;
    String errorMsg;
    List<User> users;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
