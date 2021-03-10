package cn.qtlplay.wcofone.service.impl;

import cn.qtlplay.wcofone.exception.MyRuntimeException;
import cn.qtlplay.wcofone.mapper.TableMapper;
import cn.qtlplay.wcofone.model.Table;
import cn.qtlplay.wcofone.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: tableservice实现类
 * @author: Qiao Tongliang
 * @create: 2021-02-20
 */
@Service
public class TableServiceImpl implements TableService {

    @Resource
    @Lazy
    private TableMapper tableMapper;

    @Override
    public void updateTableById(Table table) {
        try {
            tableMapper.updateById(table);
        }catch (Exception e){
            throw new MyRuntimeException("更新失败！"+e.getMessage());
        }

    }
}
