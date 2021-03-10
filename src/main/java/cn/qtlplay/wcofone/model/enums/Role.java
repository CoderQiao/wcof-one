package cn.qtlplay.wcofone.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * @description: 角色枚举类，只有admin,user两种角色
 * @author: Qiao Tongliang
 * @create: 2021-02-02
 */
@Getter
@ToString
@AllArgsConstructor
public enum Role {

    /**
     * 超级管理员
     */
    SUPER_ADMIN("超级管理员"),

    /**
     * 管理员
     */
    ADMIN("管理员");

    @EnumValue
    private String type;

}
