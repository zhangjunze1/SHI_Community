package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Agree;
import cn.edu.shu.xj.ser.mapper.AgreeMapper;
import cn.edu.shu.xj.ser.service.IAgreeService;
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
public class AgreeService extends ServiceImpl<AgreeMapper, Agree> implements IAgreeService {

    @Autowired
    AgreeMapper agreeMapper;

}
