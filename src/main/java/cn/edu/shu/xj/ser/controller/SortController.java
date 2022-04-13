package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.Sort;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.handler.BusinessException;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.response.ResultCode;
import cn.edu.shu.xj.ser.service.impl.SortService;
import cn.edu.shu.xj.ser.service.impl.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.ArrayList;
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
@RequestMapping("/sort")
public class SortController {

    @Resource
    private SortService sortService;

    @PostMapping("/findSortList")
    @ApiOperation(value = "获取分类Level 1 的所有分类",notes = "获取分类Level 1 的所有分类")
    public Result searchAllFirstSortInformation(@RequestParam(required = true, defaultValue = "1") Integer current,
                                           @RequestParam(required = true, defaultValue = "8") Integer size)
    {
        Page<Sort> SortLevelOnePage = sortService.searchAllLevelOneSort(current, size);
        return Result.ok().data("total",SortLevelOnePage.getTotal())
                .data("SortLevelOne",SortLevelOnePage.getRecords());
    }

    @PostMapping("/findSortListNoPage")
    @ApiOperation(value = "获取分类Level 1 的所有分类",notes = "获取分类Level 1 的所有分类")
    public Result searchNoPageAllFirstSortInformation()
    {
        Page<Sort> SortLevelOnePage = sortService.searchAll();
        return Result.ok().data("total",SortLevelOnePage.getTotal())
                .data("SortLevelOne",SortLevelOnePage.getRecords());
    }

    @PostMapping("/addSortOne")
    @ApiOperation(value = "获取分类Level 1 的所有分类",notes = "获取分类Level 1 的所有分类")
    public Result addNewSort(@RequestParam("sortname") String sortname)
    {
        Sort sort = sortService.searchSortByName(sortname);
        if(sort!=null){
            throw new BusinessException(ResultCode.SORT_EXIST.getCode(),
                    ResultCode.SORT_EXIST.getMessage());
        }else{
            Sort sort1 = new Sort();
            sort1.setSortLevel("1");
            sort1.setSortName(sortname);
            sortService.save(sort1);
            return Result.ok().data("sort",sortService.searchSortByName(sortname));
        }
    }

    @PostMapping("/deleteSort")
    @ApiOperation(value = "删除Level 1 的一个分类",notes = "删除Level 1 的一个分类")
    public Result deleteSort(@RequestParam("sortName") String sortName)
    {
        sortService.remove(Wrappers.<Sort>query().lambda().eq(Sort::getSortName,sortName));
        return Result.ok();
    }

    @PostMapping("/findSecondSortList")
    @ApiOperation(value = "获取分类Level 1 的所有子分类",notes = "获取分类Level 1 的所有子分类")
    public Result searchPartSecondSortInformation(@RequestParam(required = true, defaultValue = "1") Integer current,
                                                  @RequestParam(required = true, defaultValue = "8") Integer size,
                                                  @RequestParam("sortName") String sortName)
    {
        Sort sort = new Sort();
        sort = sortService.searchSortByName(sortName);
        if (sort == null){
            return Result.ok();
        } else {
            Page<Sort> SortLevelTwoPage = sortService.searchPartSecondSort(current, size, sort.getSortName());
            return Result.ok().data("total",SortLevelTwoPage.getTotal())
                    .data("SortLevelTwo",SortLevelTwoPage.getRecords());
        }
    }

    @PostMapping("/findSecondSortListNoPage")
    @ApiOperation(value = "获取分类Level 1 的所有子分类 无分页",notes = "获取分类Level 1 的所有子分类 无分页")
    public Result searchPartSecondSortInformationNoPage(@RequestParam("sortName") String sortName)
    {
        Sort sort = new Sort();
        sort = sortService.searchSortByName(sortName);
        if (sort == null){
            return Result.ok();
        } else {
            Page<Sort> SortLevelTwoPage = sortService.searchNoPagePartSecondSort(sort.getSortName());
            return Result.ok().data("total",SortLevelTwoPage.getTotal())
                    .data("SortLevelTwo",SortLevelTwoPage.getRecords());
        }
    }


    @PostMapping("/addNewSecondSort")
    @ApiOperation(value = "获取分类Level 1 的所有分类",notes = "获取分类Level 1 的所有分类")
    public Result addNewSecondSort(@RequestParam("sortName") String sortName,
                                   @RequestParam("preSortName") String preSortName)
    {
        Sort sort = sortService.searchSortByName(sortName);
        if(sort!=null){
            throw new BusinessException(ResultCode.SORT_EXIST.getCode(),
                    ResultCode.SORT_EXIST.getMessage());
        }else{
            Sort sort1 = new Sort();
            sort1.setSortLevel("2");
            sort1.setSortName(sortName);
            sort1.setSortPre(preSortName);
            sortService.save(sort1);
            return Result.ok().data("sort",sortService.searchSortByName(sortName));
        }
    }

    @PostMapping("/deleteSecondSort")
    @ApiOperation(value = "删除Level 2 的一个分类",notes = "删除Level 2 的一个分类")
    public Result deleteSecondSort(@RequestParam("sortName") String sortName,
                                   @RequestParam("preSortName") String preSortName)
    {
        sortService.remove(Wrappers.<Sort>query().lambda().eq(Sort::getSortName,sortName).eq(Sort::getSortPre,preSortName));
        return Result.ok();
    }

    @PostMapping("/findSecondSortListAll")
    @ApiOperation(value = "获取所有Level 2的分类",notes = "获取所有Level 2的分类")
    public Result findSecondSortListAll()
    {
        Page<Sort> sortLevelOneList = sortService.searchAll();
        ArrayList<Sort> sortList = new ArrayList<Sort>();
        for ( Sort sort : sortLevelOneList.getRecords()) {
            Page<Sort> sortListPart = sortService.searchNoPagePartSecondSort(sort.getSortName());
            for (Sort sort1 : sortListPart.getRecords()){
                sortList.add(sort1);
            }
        }
        return Result.ok().data("SortLevelSec",sortList);
    }

}


