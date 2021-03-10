package cn.qtlplay.wcofone.model;

import cn.qtlplay.wcofone.model.enums.Role;
import cn.qtlplay.wcofone.model.enums.Status;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

/**
 * @description: test
 * @author: Qiao Tongliang
 * @create: 2021-01-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
@TableName("t_user")
public class User {
    /**
     * 主键自增
     */
    @TableId(type = IdType.AUTO)
    private Integer uId;
    @NotNull
    private String userName;
    @NotNull
    private String password;
    private Role role;
    private Status status;
    /**
     * 默认值在service中指定
     */
    private Date createTime;
    private Date updateTime;
}
