package com.qdtdhl.campus.common.plus.service;

import com.qdtdhl.campus.common.plus.entity.BaseBotanyType;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBaseBotanyTypeService extends IService<BaseBotanyType> {
    /**
     * 添加数据到 植物种类
     * @param obs 参数
     * @return 返回值 是否添加成功
     */
    boolean install(BaseBotanyType obs);
    /**
     * 从 植物种类 删除一条数据
     * @param obs 参数
     * @return 返回值 是否删除成功
     */
    boolean delete(BaseBotanyType obs);
    /**
     * 修改 植物种类 里的一条数据
     * @param obs 参数
     * @return 返回值 是否修改成功
     */
    boolean update(BaseBotanyType obs);
    /**
     * 分页查询 植物种类 数据
     * @param obs 参数 实体
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return 返回值 查询出的分页数据
     */
    PageInfo<BaseBotanyType> findObsPage(BaseBotanyType obs,Integer pageNum,Integer pageSize);
    /**
     * 查询 植物种类 全部数据
     * @param obs 参数
     * @return 返回值 查询出的全部数据
     */
    List<BaseBotanyType> findObsAll(BaseBotanyType obs);
    /**
     * 获取 植物种类 一条数据的详细信息
     * @param obs 参数
     * @return 返回值 数据
     */
    BaseBotanyType findObsInfo(BaseBotanyType obs);
    /**
     * 查询 植物种类 的一条数据的详细信息
     * @param obs 参数
     * @return 返回值 数据的详细信息
     */
    BaseBotanyType findObsMsg(BaseBotanyType obs);
    /**
     * 删除 植物种类 的多条数据
     * @param idJson 参数 id list 的 string 字符串
     * @return 返回值 是否删除成功
     */
    boolean deleteBath(String idJson);

}
