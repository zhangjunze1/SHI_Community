package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Sort;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.mapper.SortMapper;
import cn.edu.shu.xj.ser.service.ISortService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.QueryResult;
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

    @Override
    public Page<Sort> searchAllLevelOneSort(Integer current, Integer size) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("sortLevel","1");
        Page<Sort> sortpage  = new Page<>(current,size);
        Page page = sortMapper.selectPage(sortpage, queryWrapper);
        return page;
    }

    @Override
    public Page<Sort> searchAll() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("sortLevel","1");
        Page<Sort> sortpage  = new Page<>();
        Page page = sortMapper.selectPage(sortpage, queryWrapper);
        return page;
    }

    @Override
    public Sort searchSortByName(String sortname) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("sortName",sortname);
        Sort sort = sortMapper.selectOne(queryWrapper);
        return sort;
    }

    @Override
    public Page<Sort> searchPartSecondSort(Integer current, Integer size, String sortName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("sortLevel","2");
        queryWrapper.eq("sortPre",sortName);
        Page<Sort> sortpage  = new Page<>(current,size);
        Page page = sortMapper.selectPage(sortpage, queryWrapper);
        return page;
    }

    @Override
    public Page<Sort> searchNoPagePartSecondSort(String sortName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("sortLevel","2");
        queryWrapper.eq("sortPre",sortName);
        Page<Sort> sortpage  = new Page<>();
        Page page = sortMapper.selectPage(sortpage, queryWrapper);
        return page;
    }

    @Override
    public Page<Sort> searchSortByLevel() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("sortLevel","2");
        Page<Sort> sortpage  = new Page<>();
        Page page = sortMapper.selectPage(sortpage, queryWrapper);
        return page;
    }

}
