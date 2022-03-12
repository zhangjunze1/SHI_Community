package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Comment;
import cn.edu.shu.xj.ser.mapper.CommentMapper;
import cn.edu.shu.xj.ser.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
