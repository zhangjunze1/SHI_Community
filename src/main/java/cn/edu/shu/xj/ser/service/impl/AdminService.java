package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Admin;
import cn.edu.shu.xj.ser.mapper.AdminMapper;
import cn.edu.shu.xj.ser.mapper.UserMapper;
import cn.edu.shu.xj.ser.service.IAdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhangjz
 * @since 2022-03-01
 */
@Service
public class AdminService extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Autowired
    AdminMapper adminMapper;


    /**
     * 根据名字查找管理员
     * @param name
     * @return
     */
    @Override
    public Admin searchAdminByName(String name) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("adminName",name);
        Admin admin = adminMapper.selectOne(queryWrapper);
        return admin;
    }
}
