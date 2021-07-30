package com.qdtdhl.campus.common.plus.entity;

import java.lang.reflect.Type;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.*;
import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotations.TableLogic;
import java.sql.SQLException;

import io.swagger.annotations.ApiModelProperty;
import org.postgis.Geometry;
import org.postgis.GeometryBuilder;


@Data
@Accessors(chain = true)
@TableName("base_conserve_record")
public class BaseConserveRecord extends Model<BaseConserveRecord> {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;
    /**
     * 起始时间
     */
    @ApiModelProperty(value = "起始时间")
    @TableField("start_time")
    private Date startTime;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    @TableField("end_time")
    private Date endTime;
    /**
     * 位置
     */
    @ApiModelProperty(value = "位置")
    private String location;
    /**
     * 养护类型
     */
    @ApiModelProperty(value = "养护类型")
    @TableField("conserve_type")
    private String conserveType;
    /**
     * 养护说明
     */
    @ApiModelProperty(value = "养护说明")
    @TableField("conserve_content")
    private String conserveContent;
    /**
     * 执行人
     */
    @ApiModelProperty(value = "执行人")
    @TableField("execute_user")
    private String executeUser;
    /**
     * 负责人
     */
    @ApiModelProperty(value = "负责人")
    private String principal;
    /**
     * 提交时间
     */
    @ApiModelProperty(value = "提交时间")
    @TableField("up_time")
    private Date upTime;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String content;
    /**
     * 养护计划
     */
    @ApiModelProperty(value = "养护计划")
    @TableField("conserve_id")
    private String conserveId;
    /**
     * 养护区域
     */
    @ApiModelProperty(value = "养护区域")
    @TableField("conserve_area")
    private String conserveArea;
    /**
     * 系统所属
     */
    @ApiModelProperty(value = "系统所属")
    @TableField("supper_id")
    private String supperId;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    @TableField("create_user_id")
    private String createUserId;
    /**
     * 最后更新时间
     */
    @ApiModelProperty(value = "最后更新时间")
    @TableField("last_update_time")
    private Date lastUpdateTime;
    /**
     * 最后更新人
     */
    @ApiModelProperty(value = "最后更新人")
    @TableField("last_update_user_id")
    private String lastUpdateUserId;
    /**
     * 删除标志位
     */
    @ApiModelProperty(value = "删除标志位")
    @TableField("del_flg")
    @TableLogic
    private Integer delFlg;
    /**
     * 空间数据
     */
    @ApiModelProperty(value = "空间数据")
    private Geometry space;

    public void setSpace(String space){
        try{
            if(space==null){
                this.space=null;
            }else{
                this.space=GeometryBuilder.geomFromString("SRID=4326;"+space);
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }
    

@Override
protected Serializable pkVal(){
                return this.id;
            }

}
