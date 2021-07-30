package com.qdtdhl.campus.common.plus.web;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.github.pagehelper.PageInfo;
import com.qdtdhl.campus.common.statent.Template;
import com.qdtdhl.campus.common.utils.QdTdhlTools;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qdtdhl.campus.common.plus.entity.BaseConserveUser;

import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "养护人员管理")
@RestController
@SaCheckLogin
@RequestMapping("baseConserveUser")

public class BaseConserveUserController {

    private final IBaseConserveUserService bokService;

    public BaseConserveUserController(IBaseConserveUserService bokService){
            this.bokService=bokService;
    }
    @SaCheckPermission("conserveUser-add")
    @RequestMapping(value = "addBaseConserveUser", method = POST)
    @ApiOperation(value = "添加养护人员")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "id",name = "id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(value = "姓名",name = "name", required = true, paramType = "query", dataType = "String"),
    })

    public Template<BaseConserveUser> addBaseConserveUser(
        BaseConserveUser input,
        HttpServletRequest request
    ){
        if(bokService.install(input)){
            return QdTdhlTools.returnSuccess("添加成功!",getBaseConserveUser(input));
        }else{
            return QdTdhlTools.returnErr("添加失败!");
        }
    }

    @SaCheckPermission("conserveUser-delete")
    @RequestMapping(value = "delBaseConserveUser", method = POST)
    @ApiOperation(value = "删除养护人员")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "id",name = "id", required = true, paramType = "query", dataType = "String")
    })
    public Template<BaseConserveUser> delBaseConserveUser(
        BaseConserveUser input,
        HttpServletRequest request
    ){
        if(bokService.delete(input)){
            return QdTdhlTools.returnSuccess("删除成功!",getBaseConserveUser(input));
        }else{
            return QdTdhlTools.returnErr("删除失败!");
        }
    }

    @SaCheckPermission("conserveUser-delete")
    @RequestMapping(value = "delBaseConserveUserMall", method = POST)
    @ApiOperation(value = "多选删除养护人员")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "idJson", name = "idJson", required = true, paramType = "query", dataType = "String")
    })
    public Template<BaseConserveUser> delBaseConserveUserMall(
        @RequestParam(value = "idJson", required = false, defaultValue = "[]") String idJson,
        HttpServletRequest request
    ){
        if(bokService.deleteBath(idJson)){
            return QdTdhlTools.returnSuccess("删除成功!");
        }else{
            return QdTdhlTools.returnErr("删除失败!");
        }
    }

    @SaCheckPermission("conserveUser-update")
    @RequestMapping(value = "updateBaseConserveUser", method = POST)
    @ApiOperation(value = "修改养护人员")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "id",name = "id", required = true, paramType = "query", dataType = "String")
    })

    public Template<BaseConserveUser> updateBaseConserveUser(
        BaseConserveUser input,
        HttpServletRequest request
    ){
        if(bokService.update(input)){
            return QdTdhlTools.returnSuccess("修改成功!",getBaseConserveUser(input));
        }else{
            return QdTdhlTools.returnErr("修改失败!");
        }
    }
    @SaCheckPermission("conserveUser-select")
    @RequestMapping(value = "findBaseConserveUser", method = GET)
    @ApiOperation(value = "查询养护人员-分页")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页码", name = "pageNum", required = true, paramType = "query", dataType = "Integer",defaultValue="1"),
            @ApiImplicitParam(value = "每页数据数量", name = "pageSize", required = true, paramType = "query", dataType = "Integer",defaultValue="10")
    })
    public Template<PageInfo<BaseConserveUser>>findBaseConserveUser(
        BaseConserveUser input,
        @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
        HttpServletRequest request
    ){
        PageInfo<BaseConserveUser> res=bokService.findObsPage(input,pageNum,pageSize);
        return QdTdhlTools.returnSuccess("查询成功!",res);
    }

    @SaCheckPermission("conserveUser-select")
    @RequestMapping(value = "findAllBaseConserveUser", method = POST)
    @ApiOperation(value = "查询全部养护人员")
    public Template<BaseConserveUser> findAllBaseConserveUser(
        BaseConserveUser input,
        HttpServletRequest request
    ){
        return QdTdhlTools.returnSuccess("查询成功!",bokService.findObsAll(input));
    }

    @SaCheckPermission("conserveUser-select")
    @RequestMapping(value = "getBaseConserveUser", method = GET)
    @ApiOperation(value = "获取养护人员详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "id",name = "id", required = true, paramType = "query", dataType = "String")
    })
    public Template<BaseConserveUser> getBaseConserveUser(
        BaseConserveUser input,
        HttpServletRequest request
    ){
        return QdTdhlTools.returnSuccess("查询成功!",bokService.findObsInfo(input));
    }

    public BaseConserveUser getBaseConserveUser(BaseConserveUser input){
        return bokService.findObsMsg(input);
    }
}

