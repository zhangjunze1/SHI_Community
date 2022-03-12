package cn.edu.shu.xj.ser.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
    private Long videoId;

    @TableField("videoSub")
    private String videoSub;

    @TableField("videoDescribe")
    private String videoDescribe;

    @TableField("videoSort")
    private String videoSort;

    @TableField("videoUserId")
    private Long videoUserId;

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
    private Date videoTime;


}
