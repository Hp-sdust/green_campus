package com.qdtdhl.campus.common.plus.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.qdtdhl.campus.common.plus.entity.Basecd;
import com.qdtdhl.campus.common.plus.entity.Basecd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface BasecdService extends IService<Basecd> {
    /**
     * 添加数据到 地被
     * @param obs 参数
     * @return 返回值 是否添加成功
     */
    boolean install(Basecd obs);
    /**
     * 从 地被 删除一条数据
     * @param obs 参数
     * @return 返回值 是否删除成功
     */
    boolean delete(Basecd obs);
    /**
     * 修改 地被 里的一条数据
     * @param obs 参数
     * @return 返回值 是否修改成功
     */
    boolean update(Basecd obs);
    /**
     * 分页查询 地被 数据
     * @param obs 参数 实体
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return 返回值 查询出的分页数据
     */
    PageInfo<Basecd> findObsPage(Basecd obs, Integer pageNum, Integer pageSize);
    /**
     * 查询 地被 全部数据
     * @param obs 参数
     * @return 返回值 查询出的全部数据
     */
    List<Basecd> findObsAll(Basecd obs);
    /**
     * 获取 地被 一条数据的详细信息
     * @param obs 参数
     * @return 返回值 数据
     */
    Basecd findObsInfo(Basecd obs);
    /**
     * 查询 地被 的一条数据的详细信息
     * @param obs 参数
     * @return 返回值 数据的详细信息
     */
    Basecd findObsMsg(Basecd obs);
    /**
     * 删除 地被 的多条数据
     * @param idJson 参数 id list 的 string 字符串
     * @return 返回值 是否删除成功
     */
    boolean deleteBath(String idJson);
}
