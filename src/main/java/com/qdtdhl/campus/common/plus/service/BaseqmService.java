package com.qdtdhl.campus.common.plus.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface BaseqmService extends IService<Baseqm> {
    /**
     * 添加数据到 乔木
     * @param obs 参数
     * @return 返回值 是否添加成功
     */
    boolean install(Baseqm obs);
    /**
     * 从 乔木 删除一条数据
     * @param obs 参数
     * @return 返回值 是否删除成功
     */
    boolean delete(Baseqm obs);
    /**
     * 修改 乔木 里的一条数据
     * @param obs 参数
     * @return 返回值 是否修改成功
     */
    boolean update(Baseqm obs);
    /**
     * 分页查询 乔木 数据
     * @param obs 参数 实体
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return 返回值 查询出的分页数据
     */
    PageInfo<Baseqm> findObsPage(Baseqm obs, Integer pageNum, Integer pageSize);
    /**
     * 查询 乔木 全部数据
     * @param obs 参数
     * @return 返回值 查询出的全部数据
     */
    List<Baseqm> findObsAll(Baseqm obs);
    /**
     * 获取 乔木 一条数据的详细信息
     * @param obs 参数
     * @return 返回值 数据
     */
    Baseqm findObsInfo(Baseqm obs);
    /**
     * 查询 乔木 的一条数据的详细信息
     * @param obs 参数
     * @return 返回值 数据的详细信息
     */
    Baseqm findObsMsg(Baseqm obs);
    /**
     * 删除 乔木 的多条数据
     * @param idJson 参数 id list 的 string 字符串
     * @return 返回值 是否删除成功
     */
    boolean deleteBath(String idJson);

}
