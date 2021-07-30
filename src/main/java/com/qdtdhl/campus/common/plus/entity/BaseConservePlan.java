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

@Accessors(chain = true)
@TableName("base_conserve_plan")
public class BaseConservePlan extends Model<BaseConservePlan> {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;
    /**
     * 年份
     */
    @ApiModelProperty(value = "年份")
    private String year;
    /**
     * 周次
     */
    @ApiModelProperty(value = "周次")
    private String week;
    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String details;
    /**
     * 制定人
     */
    @ApiModelProperty(value = "制定人")
    @TableField("designer_id")
    private String designerId;
    /**
     * 制定时间
     */
    @ApiModelProperty(value = "制定时间")
    @TableField("designer_time")
    private Date designerTime;
    /**
     * 审核意见
     */
    @ApiModelProperty(value = "审核意见")
    @TableField("audit_content")
    private String auditContent;
    /**
     * 审核结果
     */
    @ApiModelProperty(value = "审核结果")
    @TableField("audit_result")
    private String auditResult;

    /**
     * 审核状态
     */
    @ApiModelProperty(value = "审核状态")
    @TableField("audit_status")
    private Integer auditStatus;
    /**
     * 审核人
     */
    @ApiModelProperty(value = "审核人")
    @TableField("audit_id")
    private String auditId;
    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    @TableField("audit_time")
    private Date auditTime;
    /**
     * 反馈结果
     */
    @ApiModelProperty(value = "反馈结果")
    @TableField("feedback_result")
    private String feedbackResult;
    /**
     * 反馈说明
     */
    @ApiModelProperty(value = "反馈说明")
    @TableField("feedback_content")
    private String feedbackContent;
    /**
     * 反馈人
     */
    @ApiModelProperty(value = "反馈人")
    @TableField("feedback_id")
    private String feedbackId;
    /**
     * 反馈时间
     */
    @ApiModelProperty(value = "反馈时间")
    @TableField("feedback_time")
    private Date feedbackTime;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String content;
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
     * 养护类型
     */
    @ApiModelProperty(value = "养护类型")
    private String type;


    @Override
protected Serializable pkVal(){
                return this.id;
            }

}
