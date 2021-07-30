package com.qdtdhl.campus.common.plus.service.impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdtdhl.campus.common.plus.entity.BaseConserveUser;
import com.qdtdhl.campus.common.plus.mapper.BaseConserveUserMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
import com.qdtdhl.campus.common.utils.ErrorUtil;
import com.qdtdhl.campus.common.statent.StaticParameters;
import com.qdtdhl.campus.common.utils.QdTdhlTools;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BaseConserveUserServiceImpl extends ServiceImpl<BaseConserveUserMapper, BaseConserveUser>implements IBaseConserveUserService {

    /**
     * 添加数据到 养护人员
     * @param obs 参数
     * @return 返回值 是否添加成功
     */
    @Override
    public boolean install(BaseConserveUser obs){
        if(obs==null){
            return false;
        }else{
            return obs.insert();
        }
    }

    /**
     * 从 养护人员 删除一条数据
     * @param obs 参数
     * @return 返回值 是否删除成功
     */
    @Override
    public boolean delete(BaseConserveUser obs){
        if(obs==null){
            return false;
        }else{
            if(obs.getId()==null){
                ErrorUtil.error("主键为空!");
            }
            obs.setDelFlg(0);
            return obs.updateById();
        }
    }

    /**
     * 修改 养护人员 里的一条数据
     * @param obs 参数
     * @return 返回值 是否修改成功
     */
    @Override
    public boolean update(BaseConserveUser obs){
        if(obs==null){
            return false;
        }else{
            if(obs.getId()==null){
                ErrorUtil.error("主键为空!");
            }
            return obs.updateById();
        }
    }

    /**
     * 分页查询 养护人员 数据
     * @param obs 参数 实体
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return 返回值 查询出的分页数据
     */
    @Override
    public PageInfo<BaseConserveUser>findObsPage(BaseConserveUser obs,Integer pageNum,Integer pageSize){
        //添加分页
        PageHelper.startPage(pageNum,pageSize);
        List<BaseConserveUser>tag3=new BaseConserveUser().selectList(QdTdhlTools.addConditionToEw(obs));

        return new PageInfo<>(tag3);
    }

    /**
     * 查询 养护人员 全部数据
     * @param obs 参数
     * @return 返回值 查询出的全部数据
     */
    @Override
    public List<BaseConserveUser>findObsAll(BaseConserveUser obs){
        return new BaseConserveUser().selectList(QdTdhlTools.addConditionToEw(obs));
    }

    /**
     * 获取 养护人员 一条数据的详细信息
     * @param obs 参数
     * @return 返回值 数据
     */
    @Override
    public BaseConserveUser findObsInfo(BaseConserveUser obs){
        if(obs==null){
            return null;
        }else{
            if(obs.getId()==null){
                ErrorUtil.error("主键为空!");
            }
            return obs.selectById();
        }
    }

    /**
     * 查询 养护人员 的一条数据的详细信息
     * @param obs 参数
     * @return 返回值 数据的详细信息
     */
    @Override
    public BaseConserveUser findObsMsg(BaseConserveUser obs){
        if(obs==null){
            return null;
        }else{
            if(obs.getId()==null){
                return null;
            }
            return obs.selectById();
        }
    }

    /**
     * 删除 养护人员 的多条数据
     * @param idJson 参数 id list 的 string 字符串
     * @return 返回值 是否删除成功
     */
    @Override
    public boolean deleteBath(String idJson){
        boolean dl=false;
        if(StaticParameters.KONG.equals(idJson)){
            ErrorUtil.error("请至少输入一个主键!");
        }
        JSONArray jsonArray=JSONUtil.parseArray(idJson);
        BaseConserveUser de=new BaseConserveUser();
        de.setDelFlg(0);
        for(Object x:jsonArray){
            BaseConserveUser os=new BaseConserveUser().selectById(String.valueOf(x));
            if(os!=null){
                de.setId(os.getId());
                if(de.updateById()){
                    dl=true;
                }
            }
        }
        return dl;
    }
}
