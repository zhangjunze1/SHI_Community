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
@ApiModel(value="Video对象", description="")
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId("videoId")
      @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long videoId;

    @TableField("videoSub")
    private String videoSub;

    @TableField("videoDescribe")
    private String videoDescribe;

    @TableField("videoSort")
    private String videoSort;

    @TableField("videoUserName")
    private String videoUserName;

    @TableField("videoState")
    private String videoState;

    @TableField("videoAgree")
    private Integer videoAgree;

    @TableField("videoComment")
    private Integer videoComment;

    @TableField("videoViewNum")
    private Integer videoViewNum;

    @TableField("videoUrl")
    private String videoUrl;

    @TableField("videoTime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date videoTime;

}
