package cn.qtlplay.wcofone.controller;

import cn.qtlplay.wcofone.mapper.UserMapper;
import cn.qtlplay.wcofone.model.User;
import cn.qtlplay.wcofone.model.vo.Result;
import cn.qtlplay.wcofone.util.JwtUtil;
import cn.qtlplay.wcofone.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: hello
 * @author: Qiao Tongliang
 * @create: 2021-01-30
 */
@RestController
@Api(tags = "hello controller")
@Slf4j
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    RedisUtil redisUtil;

    @ApiOperation(value = "hello operation")
    @GetMapping("/hello")
    public String hello(){return "hello";}

    @GetMapping("/login")
    public Result<String> login(User user){
        Result<String> result = new Result<>();
        User nUser = userMapper.selectById(2);
        String token = JwtUtil.sign(nUser.getUserName(),nUser.getPassword());
        log.info("token:"+token);
        boolean yes = redisUtil.set("qiao_token",token);
        String userName = JwtUtil.getUsername(token);
        if(yes){
            log.info("token发送redis成功！");
            log.info(userName);
        }
        result.setMessage("登录成功！");
        result.setCode(200);
        return result;
    }

}
