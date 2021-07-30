package com.qdtdhl.campus.common.plus.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BaseGreenbeltService extends IService<BaseGreenbelt> {
    /**
     * 添加数据到 ;绿地斑块
     * @param obs 参数
     * @return 返回值 是否添加成功
     */
    boolean install(BaseGreenbelt obs);
    /**
     * 从 ;绿地斑块(乔木,灌木,地被) 删除一条数据
     * @param obs 参数
     * @return 返回值 是否删除成功
     */
    boolean delete(BaseGreenbelt obs);
    /**
     * 修改 ;绿地斑块(乔木,灌木,地被) 里的一条数据
     * @param obs 参数
     * @return 返回值 是否修改成功
     */
    boolean update(BaseGreenbelt obs);
    /**
     * 分页查询 ;绿地斑块(乔木,灌木,地被) 数据
     * @param obs 参数 实体
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return 返回值 查询出的分页数据
     */
    PageInfo<BaseGreenbelt> findObsPage(BaseGreenbelt obs, Integer pageNum, Integer pageSize);
    /**
     * 查询 ;绿地斑块(乔木,灌木,地被) 全部数据
     * @param obs 参数
     * @return 返回值 查询出的全部数据
     */
    List<BaseGreenbelt> findObsAll(BaseGreenbelt obs);
    /**
     * 获取 ;绿地斑块(乔木,灌木,地被) 一条数据的详细信息
     * @param obs 参数
     * @return 返回值 数据
     */
    BaseGreenbelt findObsInfo(BaseGreenbelt obs);
    /**
     * 查询 ;绿地斑块(乔木,灌木,地被) 的一条数据的详细信息
     * @param obs 参数
     * @return 返回值 数据的详细信息
     */
    BaseGreenbelt findObsMsg(BaseGreenbelt obs);
    /**
     * 删除 ;绿地斑块(乔木,灌木,地被) 的多条数据
     * @param idJson 参数 id list 的 string 字符串
     * @return 返回值 是否删除成功
     */
    boolean deleteBath(String idJson);


}
