package com.qdtdhl.campus.common.plus.web;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.github.pagehelper.PageInfo;
import com.qdtdhl.campus.common.plus.entity.BaseConserveRecord;
import com.qdtdhl.campus.common.plus.mapper.BaseConservePlanMapper;
import com.qdtdhl.campus.common.statent.Template;
import com.qdtdhl.campus.common.utils.QdTdhlTools;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qdtdhl.campus.common.plus.entity.BaseConservePlan;

import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "养护计划表管理")
@RestController
@SaCheckLogin
@RequestMapping("baseConservePlan")

public class BaseConservePlanController {

    private final IBaseConservePlanService bokService;

    public BaseConservePlanController(IBaseConservePlanService bokService){
            this.bokService=bokService;
    }

    @SaCheckPermission("conservePlan-add")
    @RequestMapping(value = "addBaseConservePlan", method = POST)
    @ApiOperation(value = "添加养护计划表")
    public Template<BaseConservePlan> addBaseConservePlan(
        BaseConservePlan input,
        HttpServletRequest request
    ){
        if(bokService.install(input)){
            return QdTdhlTools.returnSuccess("添加成功!",getBaseConservePlan(input));
        }else{
            return QdTdhlTools.returnErr("添加失败!");
        }
    }

    @SaCheckPermission("conservePlan-audit")
    @RequestMapping(value = "auditBaseConservePlan", method = POST)
    @ApiOperation(value = "审核养护计划表")
    public Template<BaseConservePlan> auditBaseConservePlan(
            BaseConservePlan bcp,
            HttpServletRequest request
    ){
        bokService.update(bcp);
        if (bcp.getAuditResult().equals("通过")){
            new BaseConserveRecord().setId(bcp.getId()).setConserveId(bcp.getId()).insert();
            return QdTdhlTools.returnSuccess("审核成功",getBaseConservePlan(bcp));
        }else{
            return QdTdhlTools.returnErr("审核失败");
        }
//        if(bokService.update(input)){
//            return QdTdhlTools.returnSuccess("审核成功，已将该划添加至养护计划！",getBaseConservePlan(input));
//        }else{
//            return QdTdhlTools.returnErr("审核失败!");
//        }
    }

    BaseConservePlanMapper baseConservePlanMapper;
    @RequestMapping(value = "getConserveType", method = POST)
    @ApiOperation(value = "获取养护类型")
    public Template<BaseConservePlan> selectConserveType(
            HttpServletRequest request
    ){
        return QdTdhlTools.returnSuccess("养护类型",baseConservePlanMapper.selectConserveType());

    }

    @SaCheckPermission("conservePlan-delete")
    @RequestMapping(value = "delBaseConservePlan", method = POST)
    @ApiOperation(value = "删除养护计划表")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "id",name = "id", required = true, paramType = "query", dataType = "String")
    })
    public Template<BaseConservePlan> delBaseConservePlan(
        BaseConservePlan input,
        HttpServletRequest request
    ){
        if(bokService.delete(input)){
            return QdTdhlTools.returnSuccess("删除成功!",getBaseConservePlan(input));
        }else{
            return QdTdhlTools.returnErr("删除失败!");
        }
    }

    @SaCheckPermission("conservePlan-delete")
    @RequestMapping(value = "delBaseConservePlanMall", method = POST)
    @ApiOperation(value = "多选删除养护计划表")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "idJson", name = "idJson", required = true, paramType = "query", dataType = "String")
    })
    public Template<BaseConservePlan> delBaseConservePlanMall(
        @RequestParam(value = "idJson", required = false, defaultValue = "[]") String idJson,
        HttpServletRequest request
    ){
        if(bokService.deleteBath(idJson)){
            return QdTdhlTools.returnSuccess("删除成功!");
        }else{
            return QdTdhlTools.returnErr("删除失败!");
        }
    }


    @SaCheckPermission("conservePlan-update")
    @RequestMapping(value = "updateBaseConservePlan", method = POST)
    @ApiOperation(value = "修改养护计划表")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "id",name = "id", required = true, paramType = "query", dataType = "String")
    })
    public Template<BaseConservePlan> updateBaseConservePlan(
        BaseConservePlan input,
        HttpServletRequest request
    ){
        if(bokService.update(input)){
            return QdTdhlTools.returnSuccess("修改成功!",getBaseConservePlan(input));
        }else{
            return QdTdhlTools.returnErr("修改失败!");
        }
    }

    @SaCheckPermission("conservePlan-select")
    @RequestMapping(value = "findBaseConservePlan", method = GET)
    @ApiOperation(value = "查询养护计划表-分页")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页码", name = "pageNum", required = true, paramType = "query", dataType = "Integer",defaultValue="1"),
            @ApiImplicitParam(value = "每页数据数量", name = "pageSize", required = true, paramType = "query", dataType = "Integer",defaultValue="10")
    })
    public Template<PageInfo<BaseConservePlan>>findBaseConservePlan(
        BaseConservePlan input,
        @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
        HttpServletRequest request
    ){
        PageInfo<BaseConservePlan> res=bokService.findObsPage(input,pageNum,pageSize);
        return QdTdhlTools.returnSuccess("查询成功!",res);
    }

    @SaCheckPermission("conservePlan-select")
    @RequestMapping(value = "findAllBaseConservePlan", method = POST)
    @ApiOperation(value = "查询全部养护计划表")
    public Template<BaseConservePlan> findAllBaseConservePlan(
        BaseConservePlan input,
        HttpServletRequest request
    ){
        return QdTdhlTools.returnSuccess("查询成功!",bokService.findObsAll(input));
    }

    @SaCheckPermission("conservePlan-select")
    @RequestMapping(value = "getBaseConservePlan", method = GET)
    @ApiOperation(value = "获取养护计划表详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "id",name = "id", required = true, paramType = "query", dataType = "String")
    })

    public Template<BaseConservePlan> getBaseConservePlan(
        BaseConservePlan input,
        HttpServletRequest request
    ){
        return QdTdhlTools.returnSuccess("查询成功!",bokService.findObsInfo(input));
    }

    public BaseConservePlan getBaseConservePlan(BaseConservePlan input){
        return bokService.findObsMsg(input);
    }
}

