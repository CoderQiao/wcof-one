package cn.qtlplay.wcofone.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @description: OSS服务接口
 * @author: Qiao Tongliang
 * @create: 2021-02-20
 */
public interface OssService {

    /**
     * 图片上传到OSS服务器
     * @param multipartFile image
     * @return oss服务器图片url
     */
    public String uploadPic(MultipartFile multipartFile);
}
