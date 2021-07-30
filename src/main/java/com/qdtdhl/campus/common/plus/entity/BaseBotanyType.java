package com.qdtdhl.campus.common.plus.entity;

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
@TableName("base_botany_type")
public class BaseBotanyType extends Model<BaseBotanyType> {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private Integer number;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 别名
     */
    @ApiModelProperty(value = "别名")
    @TableField("alias_name")
    private String aliasName;
    /**
     * 拉丁名
     */
    @ApiModelProperty(value = "拉丁名")
    @TableField("latin_name")
    private String latinName;
    /**
     * 门
     */
    @ApiModelProperty(value = "门")
    private String phylum;
    /**
     * 纲
     */
    @ApiModelProperty(value = "纲")
    @TableField("base_class")
    private String baseClass;
    /**
     * 科
     */
    @ApiModelProperty(value = "科")
    private String family;
    /**
     * 属
     */
    @ApiModelProperty(value = "属")
    private String genus;
    /**
     * 类别
     */
    @ApiModelProperty(value = "类别")
    private String species;
    /**
     * 形态特征
     */
    @ApiModelProperty(value = "形态特征")
    private String morphological;
    /**
     * 生长习性
     */
    @ApiModelProperty(value = "生长习性")
    private String habit;
    /**
     * 病虫害
     */
    @ApiModelProperty(value = "病虫害")
    @TableField("illness_worm")
    private String illnessWorm;
    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private String image;
    /**
     * 诗词
     */
    @ApiModelProperty(value = "诗词")
    private String poetry;
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


@Override
protected Serializable pkVal(){
                return this.id;
            }

}
