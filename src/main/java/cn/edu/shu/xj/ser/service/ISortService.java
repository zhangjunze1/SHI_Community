package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Sort;
import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
public interface ISortService extends IService<Sort> {

    /**
     * 搜索所有Level 1的分类
     * @param current
     * @param size
     * @return
     */
    Page<Sort> searchAllLevelOneSort(Integer current, Integer size);

    /**
     * 搜索所有Level 1的分类 无分页
     * @return
     */
    Page<Sort> searchAll();

    /**
     * 通过分类名字 搜索Level 1分类
     * @param sortName
     * @return
     */
    Sort searchSortByName(String sortName);

    /**
     * 通过第一分类的名字查询 对应第二分类
     * @param current
     * @param size
     * @param sortName
     * @return
     */
    Page<Sort> searchPartSecondSort(Integer current, Integer size,String sortName);

    /**
     * 通过第一分类的名字查询 对应第二分类 无分页
     * @param sortName
     * @return
     */
    Page<Sort> searchNoPagePartSecondSort(String sortName);

    /**
     * 搜索所有Level 2的分类
     * @return
     */
    Page<Sort> searchSortByLevel();

//    /**
//     * 通过分类名字 删除Level 1分类
//     * @param sortName
//     * @return
//     */
//    Sort deleteSort(String sortName);
}
