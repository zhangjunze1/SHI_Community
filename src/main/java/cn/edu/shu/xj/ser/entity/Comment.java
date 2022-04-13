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
@ApiModel(value="Comment对象", description="")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId("commentId")
      @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long commentId;

    @TableField("commentUserId")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long commentUserId;

    @TableField("commentVideoId")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long commentVideoId;

    @TableField("commentContent")
    private String commentContent;

    @TableField("commentTime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date commentTime;


}
