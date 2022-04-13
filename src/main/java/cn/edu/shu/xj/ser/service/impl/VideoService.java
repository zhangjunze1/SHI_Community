package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Sort;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.entity.Video;
import cn.edu.shu.xj.ser.mapper.VideoMapper;
import cn.edu.shu.xj.ser.service.IVideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.tools.jconsole.JConsole;

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

    @Override
    public Page<Video> searchVideoInformation(Integer current, Integer size, String sort, String research) {
        QueryWrapper queryWrapper = new QueryWrapper();
        System.out.println(sort);
        System.out.println(research);
        queryWrapper.like("videoSort",sort);
        queryWrapper.like("videoDescribe",research);
        Page<Video> videoPage  = new Page<>(current,size);
        Page page = videoMapper.selectPage(videoPage, queryWrapper);
        return page;
    }

    @Override
    public Long searchVideoTotal() {
        QueryWrapper queryWrapper = new QueryWrapper();
        Page<Video> videoPage  = new Page<>();
        Page page = videoMapper.selectPage(videoPage,queryWrapper);
        return page.getTotal();
    }
}
