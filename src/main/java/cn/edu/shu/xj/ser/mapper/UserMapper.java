package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zhangjz
 * @since 2022-03-01
 */
@Component
public interface UserMapper extends BaseMapper<User> {

    User findUserById(Long userId);

    User searchUserByName(String name);
}
