package com.qdtdhl.campus.common.plus.web;

import com.github.pagehelper.PageInfo;
import com.qdtdhl.campus.common.statent.Template;
import com.qdtdhl.campus.common.utils.QdTdhlTools;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qdtdhl.campus.common.plus.entity.BaseConserveRecord;

import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Api(tags = "养护记录管理")
@RestController
@RequestMapping("baseConserveRecord")

public class BaseConserveRecordController {

    private final IBaseConserveRecordService bokService;

    public BaseConserveRecordController(IBaseConserveRecordService bokService){
            this.bokService=bokService;
    }

    @RequestMapping(value = "addBaseConserveRecord", method = POST)
    @ApiOperation(value = "添加养护记录")
    public Template<BaseConserveRecord> addBaseConserveRecord(
        BaseConserveRecord input,
        HttpServletRequest request
    ){
        if(bokService.install(input)){
            return QdTdhlTools.returnSuccess("添加成功!",getBaseConserveRecord(input));
        }else{
            return QdTdhlTools.returnErr("添加失败!");
        }
    }

    @RequestMapping(value = "delBaseConserveRecord", method = POST)
    @ApiOperation(value = "删除养护记录")
    public Template<BaseConserveRecord> delBaseConserveRecord(
        BaseConserveRecord input,
        HttpServletRequest request
    ){
        if(bokService.delete(input)){
            return QdTdhlTools.returnSuccess("删除成功!",getBaseConserveRecord(input));
        }else{
            return QdTdhlTools.returnErr("删除失败!");
        }
    }

    @RequestMapping(value = "delBaseConserveRecordMall", method = POST)
    @ApiOperation(value = "多选删除养护记录")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "idJson", name = "idJson", required = true, paramType = "query", dataType = "String")
    })
    public Template<BaseConserveRecord> delBaseConserveRecordMall(
        @RequestParam(value = "idJson", required = false, defaultValue = "[]") String idJson,
        HttpServletRequest request
    ){
        if(bokService.deleteBath(idJson)){
            return QdTdhlTools.returnSuccess("删除成功!");
        }else{
            return QdTdhlTools.returnErr("删除失败!");
        }
    }


    @RequestMapping(value = "updateBaseConserveRecord", method = POST)
    @ApiOperation(value = "修改养护记录")
    public Template<BaseConserveRecord> updateBaseConserveRecord(
        BaseConserveRecord input,
        HttpServletRequest request
    ){
        if(bokService.update(input)){
            return QdTdhlTools.returnSuccess("修改成功!",getBaseConserveRecord(input));
        }else{
            return QdTdhlTools.returnErr("修改失败!");
        }
    }

    @RequestMapping(value = "findBaseConserveRecord", method = GET)
    @ApiOperation(value = "查询养护记录-分页")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页码", name = "pageNum", required = true, paramType = "query", dataType = "Integer",defaultValue="1"),
            @ApiImplicitParam(value = "每页数据数量", name = "pageSize", required = true, paramType = "query", dataType = "Integer",defaultValue="10")
    })
    public Template<PageInfo<BaseConserveRecord>>findBaseConserveRecord(
        BaseConserveRecord input,
        @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
        HttpServletRequest request
    ){
        PageInfo<BaseConserveRecord> res=bokService.findObsPage(input,pageNum,pageSize);
        return QdTdhlTools.returnSuccess("查询成功!",res);
    }

    @RequestMapping(value = "findAllBaseConserveRecord", method = POST)
    @ApiOperation(value = "查询全部养护记录")
    public Template<BaseConserveRecord> findAllBaseConserveRecord(
        BaseConserveRecord input,
        HttpServletRequest request
    ){
        return QdTdhlTools.returnSuccess("查询成功!",bokService.findObsAll(input));
    }

    @RequestMapping(value = "getBaseConserveRecord", method = GET)
    @ApiOperation(value = "获取养护记录详细信息")
    public Template<BaseConserveRecord> getBaseConserveRecord(
        BaseConserveRecord input,
        HttpServletRequest request
    ){
        return QdTdhlTools.returnSuccess("查询成功!",bokService.findObsInfo(input));
    }

    public BaseConserveRecord getBaseConserveRecord(BaseConserveRecord input){
        return bokService.findObsMsg(input);
    }
}

