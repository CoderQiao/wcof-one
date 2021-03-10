package cn.qtlplay.wcofone.service.impl;

import cn.qtlplay.wcofone.exception.MyRuntimeException;
import cn.qtlplay.wcofone.mapper.UserMapper;
import cn.qtlplay.wcofone.model.User;
import cn.qtlplay.wcofone.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @description: 用户服务实现类
 * @author: Qiao Tongliang
 * @create: 2021-02-19
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    @Lazy
    private UserMapper userMapper;

    @Override
    public User getUserByName(String userName) {
        try {
            return userMapper.getUserByName(userName);
        }catch (Exception e){
            throw new MyRuntimeException("查询失败"+e.getMessage());
        }
    }

    @Override
    public List<User> getAllUserOrByNameSearchWithPaginationInterceptor(String userName,Integer pageNum,Integer pageSize) {
        try {
            IPage<User> userPage = new Page<>(pageNum,pageSize);
            userPage = userMapper.getAllUserOrByNameSearchWithPaginationInterceptor(userPage,userName);
            return userPage.getRecords();
        }catch (Exception e){
            throw new MyRuntimeException("查询失败！"+e.getMessage());
        }
    }


    @Override
    public Integer addUser(User user) {
        try{
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            return userMapper.insert(user);
        }catch (Exception e){
            throw new MyRuntimeException("添加用户失败！"+e.getMessage());
        }
    }

    @Override
    public void deleteUserById(Integer id) {
        try {
            userMapper.deleteById(id);
        }catch (Exception e){
            throw new MyRuntimeException("删除用户异常！"+e.getMessage());
        }
    }

    @Override
    public void updateUserById(User user) {
        try {
            userMapper.updateById(user);
        }catch (Exception e){
            throw new MyRuntimeException("更新用户异常！"+e.getMessage());
        }
    }

    @Override
    public Set<String> queryRolesByUserName(String userName) {
        try {
            return userMapper.queryRolesByUserName(userName);
        }catch (Exception e){
            throw new MyRuntimeException("查询用户角色失败！"+e.getMessage());
        }
    }
}
