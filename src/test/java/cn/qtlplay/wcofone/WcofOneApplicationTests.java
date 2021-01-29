package cn.qtlplay.wcofone;

import cn.qtlplay.wcofone.mapper.UserTestMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class WcofOneApplicationTests {

    @Autowired
    private UserTestMapper userTestMapper;

    @Test
    void contextLoads() {
        userTestMapper.selectList(null).forEach(System.out::println);
    }

}
