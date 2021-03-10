package cn.qtlplay.wcofone.controller;

import cn.qtlplay.wcofone.model.Food;
import cn.qtlplay.wcofone.model.vo.Result;
import cn.qtlplay.wcofone.service.FoodService;
import cn.qtlplay.wcofone.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @description: food controller
 * @author: Qiao Tongliang
 * @create: 2021-02-22
 */
@RestController
@Api("菜品接口")
@Slf4j
@RequestMapping("/food")
public class FoodController {

    @Resource
    @Lazy
    private FoodService foodService;

    @Resource
    @Lazy
    private OssService ossService;

    @ApiOperation("添加菜品操作")
    @PostMapping
    public Result<String> addFood(Food food, MultipartFile file){
        //枚举类型直接传输具体类名就行，比如，SPECIALTY
        foodService.addFood(food,file);
        log.info("菜品添加成功！");
        return Result.OK("菜品添加成功！");
    }

    @ApiOperation("删除菜品操作")
    @DeleteMapping("/{id}")
    public Result<String> deleteFood(@PathVariable Integer id){
        foodService.deleteFoodById(id);
        log.info("菜品删除成功！");
        return Result.OK("菜品删除成功！");
    }

    @ApiOperation("更新菜品操作")
    @PutMapping
    public Result<String> updateFoodByFood(Food food,MultipartFile file){
        if (file!=null&&!file.isEmpty()){
            String image = ossService.uploadPic(file);
            food.setImage(image);
        }
        foodService.updateFoodById(food);
        log.info("更新菜品信息成功！");
        return Result.OK("更新菜品信息成功！");
    }

}
