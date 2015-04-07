package study.wp.ikitchen.model.response;

import study.wp.ikitchen.model.Concern;

/**
 * Created by wp on 2015-03-30.
 */
public class ConcernResult {
    String status;
    String errorMsg;
    Concern concern;

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

    public Concern getConcern() {
        return concern;
    }

    public void setConcern(Concern concern) {
        this.concern = concern;
    }
}
