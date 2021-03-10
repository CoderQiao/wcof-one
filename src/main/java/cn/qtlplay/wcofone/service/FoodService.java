package cn.qtlplay.wcofone.service;

import cn.qtlplay.wcofone.model.Food;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description: food service
 * @author: Qiao Tongliang
 * @create: 2021-02-22
 */
public interface FoodService {

    /**
     * 添加菜品
     * @param food 菜品实体
     */
    public void addFood(Food food, MultipartFile file);

    /**
     * 通过ID删除菜品
     * @param id id
     */
    public void deleteFoodById(Integer id);

    /**
     * 通过ID更新菜品
     * @param food 菜品实体
     */
    public void updateFoodById(Food food);

}
