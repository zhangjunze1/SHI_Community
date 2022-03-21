package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.Admin;
import cn.edu.shu.xj.ser.handler.BusinessException;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.response.ResultCode;
import cn.edu.shu.xj.ser.service.impl.AdminService;
import cn.edu.shu.xj.ser.service.impl.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhangjz
 * @since 2022-03-01
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    /**
     * 管理员登录
     * @param name
     * @param password
     * @return
     */
    @PostMapping("/loginAdmin")
    @ApiOperation(value = "管理员登录",notes = "管理员登录")
    public Result loginSys(@RequestParam("name") String name,
                           @RequestParam("password") String password){
        Admin admin = adminService.searchAdminByName(name);
        if(admin==null){
            throw new BusinessException(ResultCode.ADMIN_ACCOUNT_NOT_EXIST.getCode(),
                    ResultCode.ADMIN_ACCOUNT_NOT_EXIST.getMessage());
        }else{
            String key = admin.getAdminPassword();
            if(password.equals(key)){
                return Result.ok().data("admin", admin);
            }else {
                throw  new BusinessException(ResultCode.ADMIN_PASSWORD_ERROR.getCode(),
                        ResultCode.ADMIN_PASSWORD_ERROR.getMessage());
            }
        }
    }
}

