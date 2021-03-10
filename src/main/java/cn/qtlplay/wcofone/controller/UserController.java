package cn.qtlplay.wcofone.controller;

import cn.qtlplay.wcofone.exception.MyRuntimeException;
import cn.qtlplay.wcofone.model.User;
import cn.qtlplay.wcofone.model.enums.Status;
import cn.qtlplay.wcofone.model.vo.Result;
import cn.qtlplay.wcofone.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 用户Controller
 * @author: Qiao Tongliang
 * @create: 2021-02-19
 */
@Api(tags = "用户处理接口",value = "用户处理接口")
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Resource
    @Lazy
    private UserService userService;

    @ApiOperation("添加用户")
    @PostMapping
    public Result<String> addUser(User user){
        //插入数据，默认返回受影响行数，若要uId,可用下面语句
        Integer count = userService.addUser(user);
        Integer id = user.getUId();
        log.info("插入{}行数据，用户ID：{}",count,id);
        return Result.OK("添加成功！");
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过ID删除用户信息")
    public Result<String> deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
        log.info("删除用户ID:"+id);
        return Result.OK("删除成功！ID:"+id);
    }

    @ApiOperation("更新用户")
    @PutMapping
    public Result<String> updateUserById(@RequestBody/*要求为json格式*/ User user){
        userService.updateUserById(user);
        log.info("更新用户成功！");
        return Result.OK("更新成功！");
    }


    @ApiOperation("通过用户ID，停用用户")
    @PutMapping("/{id}/stop")
    public Result<String> stopUser(@PathVariable Integer id){
        User user = new User();
        user.setUId(id);
        user.setStatus(Status.LOCKED);
        try {
            userService.updateUserById(user);
            log.info("停用用户成功！");
        }catch (Exception e){
            throw new MyRuntimeException("停用用户异常！"+e.getMessage());
        }
        return Result.OK("停用用户成功！");
    }

    @ApiOperation("通过用户ID，启用用户")
    @PutMapping("/{id}/start")
    public Result<String> startUser(@PathVariable Integer id){
        User user = new User();
        user.setUId(id);
        user.setStatus(Status.NORMAL);
        try {
            userService.updateUserById(user);
            log.info("启用用户成功！");
        }catch (Exception e){
            throw new MyRuntimeException("启用用户异常！"+e.getMessage());
        }
        return Result.OK("启用用户成功！");
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/list")
    public Result<?> listUserByDefault(@RequestParam String userName,@RequestParam int pageNum,@RequestParam int pageSize){
        List<User> users = userService.getAllUserOrByNameSearchWithPaginationInterceptor(userName,pageNum,pageSize);
        log.info("获取用户列表成功！");
        return Result.OK("获取用户列表成功！",users);
    }
}
