package org.vvh.curnonbackendecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
public class ResponseData <T>{
    private final boolean success;
    private final int status;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T data;

    /**
     * Response data for api get data successfully
     */
    public ResponseData(int status, String message, T data) {
        this.success = true;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * Response data for api get data error
     */
    public ResponseData(int status, String message) {
        this.success = false;
        this.status = status;
        this.message = message;
        this.data = null;
    }
}
