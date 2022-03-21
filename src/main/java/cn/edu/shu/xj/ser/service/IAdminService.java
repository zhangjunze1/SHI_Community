package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhangjz
 * @since 2022-03-01
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 根据名字查找管理员
     * @param name
     * @return
     */
    Admin searchAdminByName(String name);

}
