package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhangjz
 * @since 2022-03-01
 */
public interface IUserService extends IService<User> {

    /**
     * 根据user_id查找User实体类
     * @param userId
     * @return
     */
    User findUserById(Long userId);

}
