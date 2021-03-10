package cn.qtlplay.wcofone.controller;

import cn.qtlplay.wcofone.exception.MyRuntimeException;
import cn.qtlplay.wcofone.model.Table;
import cn.qtlplay.wcofone.model.enums.Status;
import cn.qtlplay.wcofone.model.vo.Result;
import cn.qtlplay.wcofone.service.TableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: tablecontroller
 * @author: Qiao Tongliang
 * @create: 2021-02-20
 */
@RestController
@Api("Table接口")
@Slf4j
public class TableController {

    @Resource
    @Lazy
    private TableService tableService;

    @ApiOperation("设置桌子状态为正常")
    @PutMapping("/table/{id}/status/normal")
    public Result<String> setTableStatusNormal(@PathVariable Integer id){
        Table table = new Table();
        table.setTId(id);
        table.setStatus(Status.NORMAL);
        try {
            tableService.updateTableById(table);
            log.info("设置桌子状态为正常");
        }catch (Exception e){
            throw new MyRuntimeException("设置桌子状态为正常操作异常！"+e.getMessage());
        }
        return Result.OK("设置桌子状态为正常！");
    }

    @ApiOperation("设置桌子状态为锁定")
    @PutMapping("/table/{id}/status/locked")
    public Result<String> setTableStatusLocked(@PathVariable Integer id){
        Table table = new Table();
        table.setTId(id);
        table.setStatus(Status.LOCKED);
        try {
            tableService.updateTableById(table);
            log.info("设置桌子状态为锁定");
        }catch (Exception e){
            throw new MyRuntimeException("设置桌子状态为锁定操作异常！"+e.getMessage());
        }
        return Result.OK("设置桌子状态为锁定！");
    }

}
