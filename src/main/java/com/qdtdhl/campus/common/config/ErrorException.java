package com.qdtdhl.campus.common.config;


import lombok.Data;
@Data
public class ErrorException extends RuntimeException {

    public Object tTemplate;


    public ErrorException(Object tTemplate) {
        this.tTemplate = tTemplate;
    }



    public void settTemplate(Object tTemplate) {
        this.tTemplate = tTemplate;
    }

    public Object getTTemplate() {
        return tTemplate;
    }
}
