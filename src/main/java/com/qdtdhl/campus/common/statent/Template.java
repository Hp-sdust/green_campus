package com.qdtdhl.campus.common.statent;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data

public class Template<T> {

    @ApiModelProperty(value = "提示信息")
    private String msg = "";

    @ApiModelProperty(value = "请求状态")
    private Integer status = 0;

    @ApiModelProperty(value = "实体返回数据")
    private T data;

    @ApiModelProperty(value = "list返回数据")
    private List<T> dataList;

    @ApiModelProperty(value = "特殊数据返回值")
    private Object object;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
