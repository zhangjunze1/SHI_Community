package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;

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
     * 根据userId查找User实体类
     * @param userId
     * @return
     */
    User findUserById(Long userId);

    /**
     * 根据UserName查找User实体类
     * @param name
     * @return
     */
    User searchUserByName(String name);

    /**
     * 模糊查询用户信息分页
     * @param current
     * @param size
     * @param userName
     * @return
     */
    Page<User> searchAllUserInformation(Integer current, Integer size, String userName);

    /**
     * 更新登入时间
     * @param user
     * @param data
     * @return
     */
    User updateUserRecentTime(User user, Date data);

}
