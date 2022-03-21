package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Sort;
import cn.edu.shu.xj.ser.mapper.SortMapper;
import cn.edu.shu.xj.ser.service.ISortService;
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
public class SortService extends ServiceImpl<SortMapper, Sort> implements ISortService {

    @Autowired
    SortMapper sortMapper;

}
