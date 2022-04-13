package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.Sort;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.entity.Video;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.service.impl.UserService;
import cn.edu.shu.xj.ser.service.impl.VideoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhangjz
 * @since 2022-03-01
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @Resource
    private VideoService videoService;

    @GetMapping("/queryVideoList")
    @ApiOperation(value = "获取视频信息",notes = "获取视频信息")
    public Result searchAllUserInformation(@RequestParam(required = true, defaultValue = "1") Integer current,
                                           @RequestParam(required = true, defaultValue = "8") Integer size,
                                           @RequestParam(required = true, defaultValue = "") String sort,
                                           @RequestParam(required = true, defaultValue = "") String research)
    {
        Page<Video> VideoPage = videoService.searchVideoInformation(current, size, sort,research);
        return Result.ok().data("total",VideoPage.getTotal())
                .data("videoList",VideoPage.getRecords());
    }

    @PostMapping("/addNewVideo")
    @ApiOperation(value = "发布视频",notes = "发布视频")
    public Result addNewVideo(@RequestParam("videoSub") String videoSub,
                              @RequestParam("videoDescribe") String videoDescribe,
                              @RequestParam("mainSort") String sortList,
                              @RequestParam("videoUrl") String videoUrl,
                              @RequestParam("userName") String userName)
    {
        // 将最后一个空格去掉
        sortList = sortList.substring(0, sortList.length() - 1);
        Video video = new Video();
        video.setVideoSub(videoSub);
        video.setVideoDescribe(videoDescribe);
        video.setVideoSort(sortList);
        video.setVideoUserName(userName);
        video.setVideoState("已发布");
        video.setVideoAgree(0);
        video.setVideoComment(0);
        video.setVideoViewNum(0);
        video.setVideoUrl(videoUrl);
        video.setVideoTime(new Date()); // new Date()为获取当前系统时间
        videoService.save(video);
//        String[] sortItemList = sortList.split(" ");
//        for (String sortItem : sortItemList){ }
        return Result.ok();
    }

}

