package com.baizhi.entity;

public class Result {

    private boolean status;
    private String message;

    public Result() {
    }

    public Result(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
