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
@ApiModel(value="Log对象", description="")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId("logId")
      @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long logId;

    @TableField("logOperate")
    private String logOperate;

    @TableField("logUserId")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long logUserId;

    @TableField("logVideoId")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long logVideoId;

    @TableField("logTime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date logTime;


}
