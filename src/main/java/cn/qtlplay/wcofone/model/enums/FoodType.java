package cn.qtlplay.wcofone.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.*;

/**
 * @description: 类型
 * @author: Qiao Tongliang
 * @create: 2021-02-22
 */
@Getter
@ToString
@AllArgsConstructor
public enum FoodType {

    /**
     * 家常菜
     */
    HOME_COOKING("家常菜"),

    /**
     * 特色菜
     */
    SPECIALTY("特色菜"),

    /**
     * 饮料
     */
    DRINKING("饮料"),

    /**
     * 凉菜
     */
    COLD_DISHES("凉菜"),

    /**
     * 主食
     */
    MAIN_FOOD("主食"),

    /**
     * 推荐
     */
    RECOMMEND("推荐");

    @EnumValue
    public final String tType;

}
