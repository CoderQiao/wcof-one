package cn.qtlplay.wcofone.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @description: 表示使用情况，已用或未用
 * @author: Qiao Tongliang
 * @create: 2021-02-20
 */
@Getter
@ToString
@AllArgsConstructor
public enum Used {

    /**
     * 已用
     */
    USED("已用"),

    /**
     * 未用
     */
    UNUSED("未用");

    @EnumValue
    private final String used;

}
