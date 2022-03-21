package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Video;
import cn.edu.shu.xj.ser.mapper.VideoMapper;
import cn.edu.shu.xj.ser.service.IVideoService;
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
public class VideoService extends ServiceImpl<VideoMapper, Video> implements IVideoService {

    @Autowired
    VideoMapper videoMapper;

}
