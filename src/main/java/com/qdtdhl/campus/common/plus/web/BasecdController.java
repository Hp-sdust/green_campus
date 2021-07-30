package com.qdtdhl.campus.common.plus.web;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.github.pagehelper.PageInfo;
import com.qdtdhl.campus.common.plus.entity.Basecd;
import com.qdtdhl.campus.common.plus.service.BasecdService;

import com.qdtdhl.campus.common.statent.Template;
import com.qdtdhl.campus.common.utils.QdTdhlTools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
@Api(tags = "地被管理")
@RestController
@RequestMapping("basecd")
public class BasecdController {

    private final BasecdService bokService;

    public BasecdController(BasecdService bokService) {
        this.bokService = bokService;
    }


    @RequestMapping(value = "addBasecd", method = POST)
    @ApiOperation(value = "添加地被")
    public Template<Basecd> addBasecd(
            Basecd input,
            HttpServletRequest request
    ) {
        if (bokService.install(input)) {
            return QdTdhlTools.returnSuccess("添加成功!", getBasecd(input));
        } else {
            return QdTdhlTools.returnErr("添加失败!");
        }
    }

    @RequestMapping(value = "delBasecd", method = POST)
    @ApiOperation(value = "删除地被")
    public Template<Basecd> delBasecd(
            Basecd input,
            HttpServletRequest request
    ) {
        if (bokService.delete(input)) {
            return QdTdhlTools.returnSuccess("删除成功!", getBasecd(input));
        } else {
            return QdTdhlTools.returnErr("删除失败!");
        }
    }

    @RequestMapping(value = "delBasecdMall", method = POST)
    @ApiOperation(value = "多选删除地被")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "idJson", name = "idJson", required = true, paramType = "query", dataType = "String")
    })
    public Template<Basecd> delBasecdMall(
            @RequestParam(value = "idJson", required = false, defaultValue = "[]") String idJson,
            HttpServletRequest request
    ) {
        if (bokService.deleteBath(idJson)) {
            return QdTdhlTools.returnSuccess("删除成功!");
        } else {
            return QdTdhlTools.returnErr("删除失败!");
        }
    }


    @RequestMapping(value = "updateBasecd", method = POST)
    @ApiOperation(value = "修改地被")
    public Template<Basecd> updateBasecd(
            Basecd input,
            HttpServletRequest request
    ) {
        if (bokService.update(input)) {
            return QdTdhlTools.returnSuccess("修改成功!", getBasecd(input));
        } else {
            return QdTdhlTools.returnErr("修改失败!");
        }
    }

    @RequestMapping(value = "findBasecd", method = GET)
    @ApiOperation(value = "查询地被-分页")

    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页码", name = "pageNum", required = true, paramType = "query", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(value = "每页数据数量", name = "pageSize", required = true, paramType = "query", dataType = "Integer", defaultValue = "10")
    })
    public Template<PageInfo<Basecd>> findBasecd(
            Basecd input,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            HttpServletRequest request
    ) {
        PageInfo<Basecd> res = bokService.findObsPage(input, pageNum, pageSize);
        return QdTdhlTools.returnSuccess("查询成功!", res);
    }

    @RequestMapping(value = "findAllBasecd", method = POST)
    @ApiOperation(value = "查询全部地被")

    public Template<Basecd> findAllBasecd(
            Basecd input,
            HttpServletRequest request
    ) {
        return QdTdhlTools.returnSuccess("查询成功!", bokService.findObsAll(input));
    }

    @RequestMapping(value = "getBasecd", method = GET)
    @ApiOperation(value = "获取地被详细信息")

    public Template<Basecd> getBasecd(
            Basecd input,
            HttpServletRequest request
    ) {
        return QdTdhlTools.returnSuccess("查询成功!", bokService.findObsInfo(input));
    }

    public Basecd getBasecd(Basecd input) {
        return bokService.findObsMsg(input);
    }
}