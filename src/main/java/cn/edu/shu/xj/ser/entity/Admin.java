package cn.edu.shu.xj.ser.entity;

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
@ApiModel(value="Admin对象", description="")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId("adminId")
      @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long adminId;

    @TableField("adminName")
    private String adminName;

    @TableField("adminEmail")
    private String adminEmail;

    @TableField("adminPhone")
    private String adminPhone;

    @TableField("adminPassword")
    private String adminPassword;


}
