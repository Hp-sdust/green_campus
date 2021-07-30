package com.qdtdhl.campus.common.plus.web;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.github.pagehelper.PageInfo;
import com.qdtdhl.campus.common.statent.Template;
import com.qdtdhl.campus.common.utils.QdTdhlTools;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qdtdhl.campus.common.plus.entity.BaseBotanyType;

import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import com.qdtdhl.campus.common.plus.service.IBaseBotanyTypeService;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "植物种类管理")
@RestController
@RequestMapping("baseBotanyType")
@SaCheckLogin
public class BaseBotanyTypeController {

    private final IBaseBotanyTypeService bokService;

    public BaseBotanyTypeController(IBaseBotanyTypeService bokService){
            this.bokService=bokService;
    }
    @SaCheckPermission("botanytype-add")
    @RequestMapping(value = "addBaseBotanyType", method = POST)
    @ApiOperation(value = "添加植物种类")
    public Template<BaseBotanyType> addBaseBotanyType(
        BaseBotanyType input,
        HttpServletRequest request
    ){
        if(bokService.install(input)){
            return QdTdhlTools.returnSuccess("添加成功!",getBaseBotanyType(input));
        }else{
            return QdTdhlTools.returnErr("添加失败!");
        }
    }

    @RequestMapping(value = "delBaseBotanyType", method = POST)
    @ApiOperation(value = "删除植物种类")
    @SaCheckPermission("botanytype-delete")
    public Template<BaseBotanyType> delBaseBotanyType(
        BaseBotanyType input,
        HttpServletRequest request
    ){
        if(bokService.delete(input)){
            return QdTdhlTools.returnSuccess("删除成功!",getBaseBotanyType(input));
        }else{
            return QdTdhlTools.returnErr("删除失败!");
        }
    }

    @RequestMapping(value = "delBaseBotanyTypeMall", method = POST)
    @ApiOperation(value = "多选删除植物种类")
    @SaCheckPermission("botanytype-delete")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "idJson", name = "idJson", required = true, paramType = "query", dataType = "String")
    })
    public Template<BaseBotanyType> delBaseBotanyTypeMall(
        @RequestParam(value = "idJson", required = false, defaultValue = "[]") String idJson,
        HttpServletRequest request
    ){
        if(bokService.deleteBath(idJson)){
            return QdTdhlTools.returnSuccess("删除成功!");
        }else{
            return QdTdhlTools.returnErr("删除失败!");
        }
    }


    @RequestMapping(value = "updateBaseBotanyType", method = POST)
    @ApiOperation(value = "修改植物种类")
    @SaCheckPermission("botanytype-update")
    public Template<BaseBotanyType> updateBaseBotanyType(
        BaseBotanyType input,
        HttpServletRequest request
    ){
        if(bokService.update(input)){
            return QdTdhlTools.returnSuccess("修改成功!",getBaseBotanyType(input));
        }else{
            return QdTdhlTools.returnErr("修改失败!");
        }
    }

    @RequestMapping(value = "findBaseBotanyType", method = GET)
    @ApiOperation(value = "查询植物种类-分页")
    @SaCheckPermission("botanytype-select")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页码", name = "pageNum", required = true, paramType = "query", dataType = "Integer",defaultValue="1"),
            @ApiImplicitParam(value = "每页数据数量", name = "pageSize", required = true, paramType = "query", dataType = "Integer",defaultValue="10")
    })
    public Template<PageInfo<BaseBotanyType>>findBaseBotanyType(
        BaseBotanyType input,
        @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
        HttpServletRequest request
    ){
        PageInfo<BaseBotanyType> res=bokService.findObsPage(input,pageNum,pageSize);
        return QdTdhlTools.returnSuccess("查询成功!",res);
    }

    @RequestMapping(value = "findAllBaseBotanyType", method = POST)
    @ApiOperation(value = "查询全部植物种类")
    @SaCheckPermission("botanytype-select")
    public Template<BaseBotanyType> findAllBaseBotanyType(
        BaseBotanyType input,
        HttpServletRequest request
    ){
        return QdTdhlTools.returnSuccess("查询成功!",bokService.findObsAll(input));
    }

    @RequestMapping(value = "getBaseBotanyType", method = GET)
    @ApiOperation(value = "获取植物种类详细信息")
    @SaCheckPermission("botanytype-select")
    public Template<BaseBotanyType> getBaseBotanyType(
        BaseBotanyType input,
        HttpServletRequest request
    ){
        return QdTdhlTools.returnSuccess("查询成功!",bokService.findObsInfo(input));
    }

    public BaseBotanyType getBaseBotanyType(BaseBotanyType input){
        return bokService.findObsMsg(input);
    }
}

