package cn.qtlplay.wcofone;

import cn.qtlplay.wcofone.config.oss.OssConfigurationProperties;
import cn.qtlplay.wcofone.mapper.UserMapper;
import cn.qtlplay.wcofone.model.User;
import cn.qtlplay.wcofone.service.OssService;
import cn.qtlplay.wcofone.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
class WcofOneApplicationTests {

    @Resource
    @Lazy
    private UserMapper userMapper;

    @Lazy
    @Resource
    private UserService userService;

    @Resource
    @Lazy
    private OssConfigurationProperties ossConfigurationProperties;

    @Resource
    @Lazy
    private OssService ossService;

    @Value("${aliyun.oss.end-point}")
    private String end_point;
    @Test
    void contextLoads() {
//        userMapper.selectList(null).forEach(System.out::println);
        User user = userMapper.selectById(2);
        System.out.println(user.toString());
    }

    @Test
    void testGetUserByUserName(){
//        User user = userMapper.getUserByName("qiao");
//        System.out.println(user.toString());
    }

    @Test
    void testValueAnnotation(){
        System.out.println(end_point);
    }

    @Test
    void testPropertiesAnnotation(){
        System.out.println(ossConfigurationProperties.toString());
    }

//    @Test
//    void testFileUpload(){
//        String url = ossService.uploadPic(MultipartFile multipartFile);
//        System.out.println(url);
//    }

    @Test
    void testQueryRolesByUserName(){
        System.out.println(userService.queryRolesByUserName("qiao"));
    }

    @Test
    void testQueryMapper(){
        QueryWrapper<User> userQueryWrapper= new QueryWrapper<>();
//        userQueryWrapper.eq("user_name","qiao");
//        List<User> userList = userMapper.selectList(userQueryWrapper);
//        userList.forEach(user-> System.out.println(user.toString()));

//        IPage<User> userIPage = new Page<>(1,3);
//        userQueryWrapper.select("user_name","password","create_time")
//                .ge("DATE_FORMAT(create_time,'%Y-%m-%d')","2020-10-01")
//                .eq("status","正常").like("user_name","%q%");
//        userIPage = userMapper.selectPage(userIPage,userQueryWrapper);
//        List<User> users = userIPage.getRecords();
//        users.forEach(user -> System.out.println(user.toString()));

        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
    }
}
