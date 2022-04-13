package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.Comment;
import cn.edu.shu.xj.ser.entity.Sort;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.service.impl.CommentService;
import cn.edu.shu.xj.ser.service.impl.SortService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhangjz
 * @since 2022-03-01
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @PostMapping("/findCommentList")
    @ApiOperation(value = "获取视频所有评论",notes = "获取视频所有评论")
    public Result findCommentList(@RequestParam(required = true, defaultValue = "1") Integer current,
                                  @RequestParam(required = true, defaultValue = "8") Integer size,
                                  @RequestParam("videoId") Long videoId)
    {
        Page<Comment> commentList = commentService.getCommentList(current, size, videoId);
        return Result.ok().data("total",commentList.getTotal())
                .data("commentList",commentList.getRecords());
    }

    @PostMapping("/addComment")
    @ApiOperation(value = "增加评论",notes = "增加评论")
    public Result addComment(@RequestParam("comment") String comment,
                             @RequestParam("userId") Long userId,
                             @RequestParam("videoId") Long videoId)
    {
        Comment comment1 = new Comment();
        comment1.setCommentContent(comment);
        comment1.setCommentUserId(userId);
        comment1.setCommentVideoId(videoId);
        comment1.setCommentTime(new Date());
        commentService.save(comment1);
        return Result.ok();
    }

}

