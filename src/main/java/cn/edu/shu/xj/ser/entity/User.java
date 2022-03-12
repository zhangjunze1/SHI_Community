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
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId("userId")
    private Long userId;

    @TableField("userEmail")
    private String userEmail;

    @TableField("userName")
    private String userName;

    @TableField("userPassword")
    private String userPassword;

    @TableField("userPhone")
    private String userPhone;

    @TableField("userNumVideo")
    private Integer userNumVideo;

    @TableField("userLikeNumVideo")
    private Integer userLikeNumVideo;

    @TableField("userCreatedTime")
    private Date userCreatedTime;

    @TableField("userRecentTime")
    private Date userRecentTime;

    @TableField("userSignature")
    private String userSignature;


}
