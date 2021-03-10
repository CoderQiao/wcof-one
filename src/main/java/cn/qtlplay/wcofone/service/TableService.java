package cn.qtlplay.wcofone.service;

import cn.qtlplay.wcofone.model.Table;

/**
 * @description: table服务类
 * @author: Qiao Tongliang
 * @create: 2021-02-20
 */
public interface TableService {

    /**
     * 通过ID更新table
     * @param table table
     */
    public void updateTableById(Table table);

}
