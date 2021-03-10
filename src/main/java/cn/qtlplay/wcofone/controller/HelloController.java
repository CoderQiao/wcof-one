package cn.qtlplay.wcofone.controller;

import cn.qtlplay.wcofone.exception.MyRuntimeException;
import cn.qtlplay.wcofone.model.User;
import cn.qtlplay.wcofone.model.vo.Result;
import cn.qtlplay.wcofone.service.OssService;
import cn.qtlplay.wcofone.service.UserService;
import cn.qtlplay.wcofone.util.CommonConstant;
import cn.qtlplay.wcofone.util.JwtUtil;
import cn.qtlplay.wcofone.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: hello
 * @author: Qiao Tongliang
 * @create: 2021-01-30
 */
@RestController
@Api(tags = "hello controller")
@Slf4j
public class HelloController {

    @Resource
    @Lazy
    private UserService userService;

    @Resource
    @Lazy
    RedisUtil redisUtil;

    @Resource
    @Lazy
    OssService ossService;

    @ApiOperation(value = "hello operation")
    @GetMapping("/hello")
    public String hello(){return "hello";}

    @GetMapping("/login")
    public Result<String> login(@RequestBody User user, HttpServletResponse response){
        Result<String> result = new Result<>();
        User nUser = userService.getUserByName(user.getUserName());
        if(nUser == null){
            log.error("用户不存在!");
            throw new MyRuntimeException("用户不存在!");
        }
        if(!nUser.getPassword().equals(user.getPassword())){
            log.error("用户名或密码不正确！");
            throw new MyRuntimeException("用户名或密码不正确！");
        }
        String token = JwtUtil.sign(nUser.getUserName(),nUser.getPassword());
        log.info("token:"+token);
        redisUtil.set(CommonConstant.PREFIX_USER_TOKEN,token);

        response.setHeader(CommonConstant.PREFIX_USER_TOKEN,token);
        return Result.OK("登录成功！");
    }

    @GetMapping("/unauthorized")
    public String unauthorized(){
        return "未认证！";
    }

    //存在问题
    //@RequiresRoles("admin")
    @GetMapping("/test")
    public String testUnauthorized(){

        return "测试成功！";
    }

    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("image")MultipartFile multipartFile){
        String url = ossService.uploadPic(multipartFile);
        return Result.OK("上传成功！URL:"+url);
    }

}
