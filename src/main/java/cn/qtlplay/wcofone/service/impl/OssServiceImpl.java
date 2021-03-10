package cn.qtlplay.wcofone.service.impl;

import cn.qtlplay.wcofone.config.oss.OssConfigurationProperties;
import cn.qtlplay.wcofone.exception.MyRuntimeException;
import cn.qtlplay.wcofone.service.OssService;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;

/**
 * @description: OssService接口实现类
 * @author: Qiao Tongliang
 * @create: 2021-02-20
 */
@Slf4j
@Service
public class OssServiceImpl implements OssService {

    @Resource
    @Lazy
    private OSSClient ossClient;

    @Resource
    @Lazy
    private OssConfigurationProperties ossConfigurationProperties;

    @Override
    public String uploadPic(MultipartFile multipartFile) {
        String picUrl = "";
        try {
            //2.生成oss服务器图片名称（这里用uuid拼接一个name，防止上传图片与其他图片重名而覆盖同名oss文件）
            String prefix = "wcof/food/image/";
            String fileName = prefix +UUID.randomUUID().toString().replace("-", "") + "_" + multipartFile.getOriginalFilename();
            //3.上传到oss服务器
            picUrl = uploadToOss(fileName, new ByteArrayInputStream(multipartFile.getBytes()));
            log.info("图片上传成功！");
        } catch (Exception e) {
            log.error("图片上传失败！"+e.getMessage());
            throw new MyRuntimeException("图片上传失败！");
        }
        return picUrl;
    }

    /**
     * 上传图片,返回预览图地址
     *
     * @param fileName 图片名称，图片名称包括文件夹名称和“/”
     * @param in 图片输入流
     */
    private String uploadToOss(String fileName, InputStream in) {
        // 上传Object.
        ossClient.putObject(ossConfigurationProperties.getBucket(), fileName, in);

        Date expiration = new Date(System.currentTimeMillis()+3600*10000);
        URL imageUrl = ossClient.generatePresignedUrl(ossConfigurationProperties.getBucket(),fileName,expiration);
        //返回oss服务器访问上传图片的url
        return imageUrl.toString();
    }

}
