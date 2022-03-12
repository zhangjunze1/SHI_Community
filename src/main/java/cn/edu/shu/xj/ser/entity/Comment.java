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
@ApiModel(value="Comment对象", description="")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId("commentId")
    private Long commentId;

    @TableField("commentUserId")
    private Long commentUserId;

    @TableField("commentVideoId")
    private Long commentVideoId;

    @TableField("commentContent")
    private String commentContent;

    @TableField("commentTime")
    private Date commentTime;


}
