package com.tzg.service.support.result;

import java.io.Serializable;

public class Result implements Serializable {

    /** 响应状态位 */
    public final static String OK    = "ok";
    public final static String ERROR = "error";

    /** 业务状态位。 */
    private String status;

    /** 业务数据 */
    private Object data;

    public Result() {
        this.status = Result.OK;
    }

    public Result( String status, Object data ) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData( Object data ) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

}

