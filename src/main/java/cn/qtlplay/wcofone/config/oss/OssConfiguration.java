package cn.qtlplay.wcofone.config.oss;

import com.aliyun.oss.OSSClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @description: OSS配置类
 * @author: Qiao Tongliang
 * @create: 2021-02-20
 */
@Configuration
public class OssConfiguration {

    @Resource
    private OssConfigurationProperties ossConfigurationProperties;

    @Bean
    public OSSClient ossClient(){
        return new OSSClient(ossConfigurationProperties.getEndPoint(),
                                ossConfigurationProperties.getAccessKeyId(),
                                ossConfigurationProperties.getAccessKeySecret());
    }

}
