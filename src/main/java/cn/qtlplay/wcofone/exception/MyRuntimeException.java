package cn.qtlplay.wcofone.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @description: 自定义运行时异常
 * @author: Qiao Tongliang
 * @create: 2021-02-19
 */
public class MyRuntimeException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public MyRuntimeException(String message){super(message);}
}
