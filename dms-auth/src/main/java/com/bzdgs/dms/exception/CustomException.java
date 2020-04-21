package com.bzdgs.dms.exception;

import com.bzdgs.dms.domain.ResultJson;
import lombok.Getter;

/**
 * @author Joetao
 * Created at 2018/8/24.
 */
@Getter
public class CustomException extends RuntimeException{
    private ResultJson resultJson;

    public CustomException(ResultJson resultJson) {
        this.resultJson = resultJson;
    }
}
