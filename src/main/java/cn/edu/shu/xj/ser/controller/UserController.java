package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.Admin;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.handler.BusinessException;
import cn.edu.shu.xj.ser.response.ResultCode;
import cn.edu.shu.xj.ser.service.impl.AdminService;
import cn.edu.shu.xj.ser.service.impl.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import cn.edu.shu.xj.ser.response.Result;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhangjz
 * @since 2022-03-01
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户模块",tags = "用户接口")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     * @param name
     * @param password
     * @param password1
     * @return
     */
    @PostMapping("/register")
    @ApiOperation(value = "用户注册",notes = "用户注册")
    public Result register(@RequestParam("name") String name,
                           @RequestParam("password") String password,
                           @RequestParam("password1") String password1,
                           @RequestParam("phone") String phone,
                           @RequestParam("email") String email)
    {
        if(!password.equals(password1)){
            throw  new BusinessException(ResultCode.DIFFERENT_PASSWORD.getCode(),
                    ResultCode.DIFFERENT_PASSWORD.getMessage());
        }
        User user = userService.searchUserByName(name);
        if(user!=null){
            throw new BusinessException(ResultCode.USER_ACCOUNT_EXIST.getCode(),
                    ResultCode.USER_ACCOUNT_EXIST.getMessage());
        }else{
            User newUser = new User();
            newUser.setUserName(name);
            newUser.setUserPassword(password);
            newUser.setUserEmail(email);
            newUser.setUserPhone(phone);
            newUser.setUserLikeNumVideo(0);
            newUser.setUserNumVideo(0);
//            java.util.Date dt = new java.util.Date();
//            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String userRegisterTime = sdf.format(dt);
//            newUser.setUserCreatedTime(userRegisterTime);
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            newUser.setUserCreatedTime(new Date()); // new Date()为获取当前系统时间
            userService.save(newUser);
            return Result.ok().data("user",userService.searchUserByName(name));
        }
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录",notes = "用户登录")
    public Result login(@RequestParam("name") String name,
                           @RequestParam("password") String password)
    {
        User user = userService.searchUserByName(name);
        if(user ==null){
            throw new BusinessException(ResultCode.USER_NO_ACCOUNT_EXIST.getCode(),
                    ResultCode.USER_NO_ACCOUNT_EXIST.getMessage());
        }else{
            if (!user.getUserPassword().equals(password)){
                throw new BusinessException(ResultCode.USER_PASSWORD_ERROR.getCode(),
                        ResultCode.USER_PASSWORD_ERROR.getMessage());
            }
            else {
                userService.updateUserRecentTime(user,new Date());
                return Result.ok().data("user",user);
            }
        }
    }

    @PostMapping("/queryUserList")
    @ApiOperation(value = "获取所有用户信息",notes = "获取所有用户信息")
    public Result searchAllUserInformation(@RequestParam(required = true, defaultValue = "1") Integer current,
                                           @RequestParam(required = true, defaultValue = "8") Integer size,
                                           @RequestParam(required = true, defaultValue = "") String userName)
    {
        Page<User> UserPage = userService.searchAllUserInformation(current, size, userName);
        return Result.ok().data("total",UserPage.getTotal())
                .data("Users",UserPage.getRecords());
    }
}


