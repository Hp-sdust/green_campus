package com.qdtdhl.campus.common.plus.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.google.common.net.InternetDomainName;
import com.qdtdhl.campus.common.mybatic.MyModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("base_cd")
public class Basecd extends MyModel<Basecd> {
    private static final long serialVersionUID=1L;


    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "斑块编号")
    @TableField("area_id")
    private String areaid;

    private Integer area;



    @ApiModelProperty(value = "健康状况")
    private String health;

    @ApiModelProperty(value = "种植时间")
    private Date zzsj;




    @ApiModelProperty(value = "价格")
    private String price;

    @ApiModelProperty(value = "养护规范编号")
    @TableField("yhgf_id")
    private String yhgfid;

    @TableField("zjyh_id")
    private String zjyhid;


    @ApiModelProperty(value = "删除标志位")
    @TableField("del_flg")
    @TableLogic
    private Integer delFlg;


    @Override
    protected Serializable pkVal(){
        return this.id;
    }

}
