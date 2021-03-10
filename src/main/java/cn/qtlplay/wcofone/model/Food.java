package cn.qtlplay.wcofone.model;

import cn.qtlplay.wcofone.model.enums.FoodType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

/**
 * @description: 菜品实体
 * @author: Qiao Tongliang
 * @create: 2021-02-22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
@TableName("t_food")
public class Food {
    @TableId(type = IdType.AUTO)
    private Integer tId;
    @NotNull
    private String tName;
    @NotNull
    private BigDecimal price;
    private String tDesc;
    private String image;
    private FoodType tType;
}
