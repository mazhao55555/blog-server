package org.sang.controller.admin;

import org.sang.bean.RespBean;
import org.sang.bean.Role;
import org.sang.bean.User;
import org.sang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by mazhao on 2019/08/28.
 */
@RestController
@RequestMapping("/admin")
public class UserManaController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public  Map<String,Object> getUserByPage(String keywords, @RequestParam( value = "currentPage",defaultValue = "1") Integer currentPage,@RequestParam( value = "pageSize",defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        List<User> users = userService.getUserByPage(keywords, (currentPage - 1) * pageSize, pageSize);
        List<User> result = new ArrayList<>(users);
        for(User user : users){
            System.out.println(user + "--------------------");
        }
        Integer userCount =  userService.getUserCount(keywords);
        map.put("users",result);
        map.put("userCount",userCount);
        return map;
    }
    @RequestMapping(value = "/user_keywords", method = RequestMethod.GET)
    public Map<String,Object>  getUserByKeywords(String keywords) {
        Map<String, Object> map = new HashMap<>();
        List<User>  users =  userService.getUserByKeywords(keywords);
        List<User> result = new ArrayList<>(users);
        Integer userCount =  userService.getUserCount(keywords);
        map.put("users",result);
        map.put("userCount",userCount);
        return map;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public List<Role> getAllRole() {
        return userService.getAllRole();
    }

    @RequestMapping(value = "/user/enabled", method = RequestMethod.PUT)
    public RespBean updateUserEnabled(Boolean enabled, Long uid) {
        if (userService.updateUserEnabled(enabled, uid) == 1) {
            return new RespBean("success", "更新成功!");
        } else {
            return new RespBean("error", "更新失败!");
        }
    }

    @RequestMapping(value = "/user/{uid}", method = RequestMethod.DELETE)
    public RespBean deleteUserById(@PathVariable Long uid) {
        if (userService.deleteUserById(uid) == 1) {
            return new RespBean("success", "删除成功!");
        } else {
            return new RespBean("error", "删除失败!");
        }
    }

    @RequestMapping(value = "/user/role", method = RequestMethod.PUT)
    public RespBean updateUserRoles(Long[] rids, Long id) {
        if (userService.updateUserRoles(rids, id) == rids.length) {
            return new RespBean("success", "更新成功!");
        } else {
            return new RespBean("error", "更新失败!");
        }
    }
}
