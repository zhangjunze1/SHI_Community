package cn.edu.shu.xj.ser.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhangjz
 * @since 2022-03-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Agree对象", description="")
public class Agree implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId("agreeId")
      @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long agreeId;

    @TableField("agreeUserId")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long agreeUserId;

    @TableField("agreeVideoId")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long agreeVideoId;

    @TableField("agreeRecentLike")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date agreeRecentLike;

    @TableField("agreeState")
    private String agreeState;


}
