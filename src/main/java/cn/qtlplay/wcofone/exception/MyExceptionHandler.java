package cn.qtlplay.wcofone.exception;

import cn.qtlplay.wcofone.model.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

/**
 * @description: 自定义异常处理器
 * @author: Qiao Tongliang
 * @create: 2021-02-19
 */
@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(MyRuntimeException.class)
    public Result<?> runtimeExceptionHandler(MyRuntimeException myRuntimeException){
        log.error(myRuntimeException.getMessage());
        return Result.error(myRuntimeException.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Result<?> illegalArgumentException(IllegalArgumentException illegalArgumentException){
        return Result.error("不合法参数异常："+illegalArgumentException.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    public Result<?> authenticationExceptionHandler(AuthenticationException authenticationException){
        return Result.error("认证失败！"+authenticationException.getMessage());
    }

}
