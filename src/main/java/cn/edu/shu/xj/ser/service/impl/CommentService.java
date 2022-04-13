package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Comment;
import cn.edu.shu.xj.ser.entity.Sort;
import cn.edu.shu.xj.ser.mapper.CommentMapper;
import cn.edu.shu.xj.ser.service.ICommentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public class CommentService extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public Page<Comment> getCommentList(Integer current, Integer size, Long videoId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("commentVideoId",videoId);
        Page<Comment> commentPage  = new Page<>(current,size);
        Page page = commentMapper.selectPage(commentPage, queryWrapper);
        return page;
    }
}
