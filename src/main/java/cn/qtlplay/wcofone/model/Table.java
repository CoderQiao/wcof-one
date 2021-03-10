package cn.qtlplay.wcofone.model;

import cn.qtlplay.wcofone.model.enums.Status;
import cn.qtlplay.wcofone.model.enums.Used;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

/**
 * @description: 桌子
 * @author: Qiao Tongliang
 * @create: 2021-02-20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
@TableName("t_table")
public class Table {
    @TableId(type = IdType.AUTO)
    private Integer tId;
    @NotNull
    private String tName;
    private Status status;
    private Used used;
    private Date createTime;
    private Date updateTime;
}
