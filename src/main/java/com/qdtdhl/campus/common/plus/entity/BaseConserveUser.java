package com.qdtdhl.campus.common.plus.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableLogic;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

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
@TableName("base_conserve_user")
public class BaseConserveUser extends Model<BaseConserveUser> {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String six;
    /**
     * 民族
     */
    @ApiModelProperty(value = "民族")
    private String nation;
    /**
     * 出生年月
     */
    @ApiModelProperty(value = "出生年月")
    private String birthday;
    /**
     * 政治面貌
     */
    @ApiModelProperty(value = "政治面貌")
    private String politics;
    /**
     * 籍贯
     */
    @ApiModelProperty(value = "籍贯")
    private String natives;
    /**
     * 住址
     */
    @ApiModelProperty(value = "住址")
    private String address;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String phone;
    /**
     * 入职时间
     */
    @ApiModelProperty(value = "入职时间")
    @TableField("entry_time")
    private Date entryTime;
    /**
     * 工作范围
     */
    @ApiModelProperty(value = "工作范围")
    @TableField("work_area")
    private String workArea;
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


@Override
protected Serializable pkVal(){
                return this.id;
            }

}
