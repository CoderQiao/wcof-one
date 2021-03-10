package cn.qtlplay.wcofone.mapper;

import cn.qtlplay.wcofone.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * @description: UserMapper
 * @author: Qiao Tongliang
 * @create: 2021-01-29
 */
public interface UserMapper extends BaseMapper<User> {

    User getUserByName(String userName);

    /**
     * 根据用户名查询用户信息或查询所有用户信息
     * @param page IPage
     * @param userName 用户名
     * @return list
     */
    @Select("<script>select * from t_user where 1=1 " +
            "<if test='userName!=null and userName!=\"\"'>userName=#{userName}</if>" +
            "</script>")
    IPage<User> getAllUserOrByNameSearchWithPaginationInterceptor(IPage<User> page, @Param("userName") String userName);

    /**
     * 通过用户名查询角色集合
     * @param userName userName
     * @return set
     */
    @Select("select role from t_user WHERE user_name=#{userName}")
    Set<String> queryRolesByUserName(String userName);

}
