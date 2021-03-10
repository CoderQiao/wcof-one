package cn.qtlplay.wcofone.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @description: 状态枚举类
 * @author: Qiao Tongliang
 * @create: 2021-02-02
 */
@Getter
@ToString
@AllArgsConstructor
public enum Status {

    /**
     * 正常使用
     */
    NORMAL("正常"),

    /**
     * 被锁定，不能正常使用
     */
    LOCKED("锁定");

    @EnumValue
    private final String status;

}
