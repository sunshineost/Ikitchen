package study.wp.ikitchen.model.response;

/**
 * Created by wp on 2015-03-04.
 */
public class UniversalResult<T> {
    String status;
    String errorMsg;
    T resultMap;
}
