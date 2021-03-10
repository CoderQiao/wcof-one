package cn.qtlplay.wcofone.service;

import cn.qtlplay.wcofone.model.User;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Set;

/**
 * @description: User服务
 * @author: Qiao Tongliang
 * @create: 2021-02-19
 */
public interface UserService {

    /**
     * 通过用户名查询
     * @param userName
     * @return
     */
    public User getUserByName(String userName);

    /**
     * 通过用户名查询或者查询所用
     * @param userName userName
     * @return userList
     */
    public List<User> getAllUserOrByNameSearchWithPaginationInterceptor(String userName,Integer pageNum,Integer pageSize);

    /**
     * 添加用户
     * @param user
     * @return 返回ID
     */
    public Integer addUser(User user);

    /**
     * 通过用户ID，删除用户
     * @param id
     */
    public void deleteUserById(Integer id);

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUserById(User user);


    /**
     * 通过用户名查询用户角色
     * @param userName 用户名
     * @return
     */
    public Set<String> queryRolesByUserName(String userName);
}
