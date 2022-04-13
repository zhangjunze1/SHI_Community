package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Sort;
import cn.edu.shu.xj.ser.entity.Video;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhangjz
 * @since 2022-03-01
 */
public interface IVideoService extends IService<Video> {

    /**
     *
     * @param current
     * @param size
     * @param sort
     * @param research
     * @return
     */
    Page<Video> searchVideoInformation(Integer current, Integer size,String sort, String research);

    /**
     * 搜索视频数量
     * @return
     */
    Long searchVideoTotal();
}
