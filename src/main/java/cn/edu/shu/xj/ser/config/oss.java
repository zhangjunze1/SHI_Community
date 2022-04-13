package cn.edu.shu.xj.ser.config;


import cn.edu.shu.xj.ser.entity.Video;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.service.IUserService;
import cn.edu.shu.xj.ser.service.IVideoService;
import cn.edu.shu.xj.ser.service.impl.VideoService;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

@Api(tags = "文件上传")
@RestController
@Service
@RequestMapping("/oss")
public class oss {
    String endpoint = "oss-cn-hangzhou.aliyuncs.com";
    String accessKeyId = "LTAI5tBji2779oNNiitohXS7";
    String accessKeySecret = "UOM079PXLVttYZCeLTuKaUq5hRXT2w";
    String bucketName = "zhangjz-community-example";

    String subPath = "video/";
    OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    String picture_name = "";
    String video_name = "";
    long business_id;
    long shangping_id;


    @Autowired
    IUserService IUserService;

    @Autowired
    VideoService videoService;

    @ApiOperation(value = "上传视频文件", notes = "请记得上传时加上参数 file !")
    @PostMapping(value = "/uploadVideoFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result uploadVideoFile(@RequestParam("file") MultipartFile file ) throws IOException {
        //随机生成照片url
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<10;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        video_name=sb.toString()+".mp4";

        IdWorker.getIdStr();
        ossClient.putObject(bucketName, subPath + video_name, file.getInputStream());//上传服务器

        Date expiration = new Date(System.currentTimeMillis() +3600*24*365);//时差2000S左右
        String url = ossClient.generatePresignedUrl(bucketName, subPath + video_name, expiration).toString();//从服务器获取图片url
        OSSObject ossObject = ossClient.getObject(bucketName, subPath + video_name);
        ossObject.getObjectContent();

        return Result.ok().data("url",url);
    }

    @ApiOperation(value = "上传文件测试", notes = "请记得上传时加上参数 file !")
    @PostMapping(value = "/oss/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public PutObjectResult uploadTest(@RequestParam("file") MultipartFile file ) throws IOException {

        System.out.println("sdasda");
        IdWorker.getIdStr();
        return ossClient.putObject(bucketName, subPath +"123.mp4", file.getInputStream());
    }



//    @ApiOperation(value = "上传活动报名照片", notes = "请记得上传时加上参数 file !")
//    @PostMapping(value = "/activityPre/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public Result uploadActivityPic(@RequestParam("file") MultipartFile file ) throws IOException {
//        //随机生成照片url
//        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        Random random=new Random();
//        StringBuffer sb=new StringBuffer();
//        for(int i=0;i<10;i++){
//            int number=random.nextInt(62);
//            sb.append(str.charAt(number));
//        }
//        picture_name=sb.toString()+".jpg";
//
//        IdWorker.getIdStr();
//        ossClient.putObject(bucketName, activityPath + picture_name, file.getInputStream());//上传服务器
//
//        Date expiration = new Date(System.currentTimeMillis() +3600*24*365);//时差2000S左右
//        String url = ossClient.generatePresignedUrl(bucketName, activityPath + picture_name, expiration).toString();//从服务器获取图片url
//        OSSObject ossObject = ossClient.getObject(bucketName, activityPath + picture_name);
//        ossObject.getObjectContent();
//
//        return Result.ok().data("url",url);
//    }

//    @ApiOperation(value = "获取添加用户车辆", notes = "请记得上传时加上参数 file !")
//    @PostMapping(value = "/oss/addUserCars", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public Result addUserCars(@RequestParam(required = true)Long userId,
//                          @RequestParam(required = true)String carPlates,
//                          @RequestParam(required = true)String carStyle,
//                          @RequestParam(required = true)String carCity,
//                          @RequestParam("file") MultipartFile file) throws IOException {
//        this.picture_name = userId+carPlates+".jpg";
//        ossClient.putObject(bucketName, carPath + picture_name, file.getInputStream());//上传服务器
//        Date expiration = new Date(System.currentTimeMillis() +3600*24*365);//时差2000S左右
//        String url = ossClient.generatePresignedUrl(bucketName, carPath + picture_name, expiration).toString();//从服务器获取图片url
//        System.out.println(url);
//        OSSObject ossObject = ossClient.getObject(bucketName, carPath + picture_name);
//        ossObject.getObjectContent();
//
//        double userLongtitude = userService.findUserById(userId).getUserLongitude();
//        double userLatitude = userService.findUserById(userId).getUserLatitude();
//        carService.addUserCar(userId,carPlates,carStyle,carCity,url,userLongtitude,userLatitude);
//        return Result.ok();
//    }

    @PostMapping(value = "/oss/downloadFile")
    public String downloadTest(@RequestParam("fileName") String fileName) {

        Date expiration = new Date(System.currentTimeMillis() +3600*24*365);//时差2000S左右
        String url = ossClient.generatePresignedUrl(bucketName, subPath + fileName, expiration).toString();
        OSSObject ossObject = ossClient.getObject(bucketName, subPath + fileName);
        ossObject.getObjectContent();
        return url;
    }
/*try {

	$ossClient = new OssClient($accessKeyId, $accessKeySecret, $endpoint);

	// 生成一个带签名的URL，有效期是3600秒，可以直接使用浏览器访问。
	$timeout = 3600;

	// $options 可以参考https://www.alibabacloud.com/help/zh/doc-detail/47735.htm?spm=a2c63.p38356.b99.530.2b124f7cdGTn1g
	// $options = array(
	//     OssClient::OSS_FILE_DOWNLOAD => $download_file,
	//     OssClient::OSS_PROCESS => "image/resize,m_fixed,h_100,w_100",
	// );

	$signedUrl = $ossClient->signUrl($bucket, $object, $timeout, "GET", $options);

	print("rtmp url: \n" . $signedUrl);
} catch (OssException $e) {
	print $e->getMessage();
}*/
// 获取文件内容
/*try {
	$ossClient = new OssClient($accessKeyId, $accessKeySecret, $endpoint);
	$content = $ossClient->getObject($bucket, $object);
    print("object content: " . $content);
} catch (OssException $e) {
	print $e->getMessage();
}*/
}
