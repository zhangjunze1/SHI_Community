package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Log;
import cn.edu.shu.xj.ser.mapper.LogMapper;
import cn.edu.shu.xj.ser.service.ILogService;
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
public class LogService extends ServiceImpl<LogMapper, Log> implements ILogService {

    @Autowired
    LogMapper logMapper;

}
