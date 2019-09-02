package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Role;
import org.sang.bean.User;

import java.util.List;
import java.util.Set;

/**
 * Created by mazhao on 2019/08/28.
 */
@Mapper
public interface UserMapper {

    User loadUserByUsername(@Param("username") String username);

    long reg(User user);

    int updateUserEmail(@Param("email") String email, @Param("id") Long id);

    List<User> getUserByPage(@Param("keywords") String keywords, @Param("currentindex") Integer currentIndex, @Param("pagesize") Integer pageSize);

    List<Role> getAllRole();

    List<Role> findRoles(@Param("id") Integer id);

    int updateUserEnabled(@Param("enabled") Boolean enabled, @Param("uid") Long uid);

    int deleteUserById(Long uid);

    int deleteUserRolesByUid(Long id);

    int setUserRoles(@Param("rids") Long[] rids, @Param("id") Long id);

    User getUserById(@Param("id") Long id);

    List<User> getUserByKeywords(@Param("keywords") String keywords);

    List<Role> selectAllRoles(@Param("keywords") String keywords);

    Integer getUserCount(@Param("keywords")String keywords);
}
