package com.qdtdhl.campus.common.plus.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BasegmService extends IService<Basegm> {
    /**
     * 添加数据到 灌木
     * @param obs 参数
     * @return 返回值 是否添加成功
     */
    boolean install(Basegm obs);
    /**
     * 从 灌木 删除一条数据
     * @param obs 参数
     * @return 返回值 是否删除成功
     */
    boolean delete(Basegm obs);
    /**
     * 修改 灌木 里的一条数据
     * @param obs 参数
     * @return 返回值 是否修改成功
     */
    boolean update(Basegm obs);
    /**
     * 分页查询 灌木 数据
     * @param obs 参数 实体
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return 返回值 查询出的分页数据
     */
    PageInfo<Basegm> findObsPage(Basegm obs, Integer pageNum, Integer pageSize);
    /**
     * 查询 灌木 全部数据
     * @param obs 参数
     * @return 返回值 查询出的全部数据
     */
    List<Basegm> findObsAll(Basegm obs);
    /**
     * 获取 灌木 一条数据的详细信息
     * @param obs 参数
     * @return 返回值 数据
     */
    Basegm findObsInfo(Basegm obs);
    /**
     * 查询 灌木 的一条数据的详细信息
     * @param obs 参数
     * @return 返回值 数据的详细信息
     */
    Basegm findObsMsg(Basegm obs);
    /**
     * 删除 灌木 的多条数据
     * @param idJson 参数 id list 的 string 字符串
     * @return 返回值 是否删除成功
     */
    boolean deleteBath(String idJson);
}
