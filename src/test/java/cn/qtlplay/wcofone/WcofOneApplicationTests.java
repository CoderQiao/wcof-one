package cn.qtlplay.wcofone;

import cn.qtlplay.wcofone.mapper.UserMapper;
import cn.qtlplay.wcofone.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class WcofOneApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
//        userMapper.selectList(null).forEach(System.out::println);
        User user = userMapper.selectById(2);
        System.out.println(user.toString());
    }

}
