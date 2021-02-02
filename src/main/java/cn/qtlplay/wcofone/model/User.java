package cn.qtlplay.wcofone.model;

import cn.qtlplay.wcofone.model.enums.Role;
import cn.qtlplay.wcofone.model.enums.Status;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class User {

    @TableId
    private Integer uId;
    @NotNull
    private String userName;
    @NotNull
    private String password;
    private Role role;
    private Status status;
    private Date createTime;
    private Date updateTime;
}
