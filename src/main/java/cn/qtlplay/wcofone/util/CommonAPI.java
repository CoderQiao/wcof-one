package cn.qtlplay.wcofone.util;



import cn.qtlplay.wcofone.model.User;

import java.util.Set;

public interface CommonAPI {

    /**
     * 1查询用户角色信息
     * @param username
     * @return
     */
    Set<String> queryUserRoles(String username);


    /**
     * 2查询用户权限信息
     * @param username
     * @return
     */
    Set<String> queryUserAuths(String username);


    /**
     * 5根据用户账号查询用户信息
     * @param username
     * @return
     */
    public User getUserByName(String username);

}
