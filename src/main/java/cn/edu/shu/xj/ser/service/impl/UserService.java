package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.mapper.UserMapper;
import cn.edu.shu.xj.ser.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhangjz
 * @since 2022-03-01
 */
@Service("userService")
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserById(Long userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public User searchUserByName(String name) {
        return userMapper.searchUserByName(name);
    }

    @Override
    public Page<User> searchAllUserInformation(Integer current, Integer size, String userName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("userName",userName);
        Page<User> userPage  = new Page<>(current,size);
        Page page = userMapper.selectPage(userPage, queryWrapper);
//        ArrayList<User> Users = new ArrayList<>();
//        List<User> records = page.getRecords();
//        for (SysUser sysUser : records){
//            String[] strings = sysUser.getProvince().split(",");
//            List<String> auth = Arrays.asList(strings);
//            String province = "";
//            for (String s : auth){
//                province += ProvinceChinese.getChineseNameByName(s) + " ";
//            }
//            sysUser.setProvince(province);
//            sysUsers.add(sysUser);
//        }
//        page.setRecords(Users);
        return page;
    }

    @Override
    public User updateUserRecentTime(User user, Date data) {
        user.setUserRecentTime(data);
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("userId",user.getUserId());
        userMapper.update(user,updateWrapper);
        return userMapper.searchUserByName(user.getUserName());
    }

}
