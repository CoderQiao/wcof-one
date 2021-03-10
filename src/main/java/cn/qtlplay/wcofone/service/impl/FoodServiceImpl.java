package cn.qtlplay.wcofone.service.impl;

import cn.qtlplay.wcofone.config.oss.OssConfigurationProperties;
import cn.qtlplay.wcofone.exception.MyRuntimeException;
import cn.qtlplay.wcofone.mapper.FoodMapper;
import cn.qtlplay.wcofone.model.Food;
import cn.qtlplay.wcofone.service.FoodService;
import cn.qtlplay.wcofone.service.OssService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @description: food service 实现类
 * @author: Qiao Tongliang
 * @create: 2021-02-22
 */
@Service
public class FoodServiceImpl implements FoodService {

    @Resource
    @Lazy
    private FoodMapper foodMapper;

    @Resource
    @Lazy
    private OssConfigurationProperties ossConfigurationProperties;

    @Resource
    @Lazy
    private OssService ossService;

    @Override
    public void addFood(Food food, MultipartFile file) {
        try {
            String image = ossService.uploadPic(file);
            //异常在ossService中抛出
            food.setImage(image);
            foodMapper.insert(food);
        }catch (Exception e){
            throw new MyRuntimeException("菜品插入失败"+e.getMessage());
        }
    }

    @Override
    public void deleteFoodById(Integer id) {
        try {
            foodMapper.deleteById(id);
        }catch (Exception e){
            throw new MyRuntimeException("菜品删除失败"+e.getMessage());
        }
    }

    @Override
    public void updateFoodById(Food food) {
        try {
            foodMapper.updateById(food);
        }catch (Exception e){
            throw new MyRuntimeException("菜品更新失败"+e.getMessage());
        }
    }
}
