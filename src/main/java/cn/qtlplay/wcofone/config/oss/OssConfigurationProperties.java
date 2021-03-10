package cn.qtlplay.wcofone.config.oss;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: OSS配置常量
 * @author: Qiao Tongliang
 * @create: 2021-02-20
 */
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
@Data
public class OssConfigurationProperties {

    /**
     * 外网访问oss服务器的域名
     */
    private String endPoint;

    /**
     * 访问KEY_ID
     */
    private String accessKeyId;

    /**
     * 访问密钥
     */
    private String accessKeySecret;

    /**
     * 文件存储空间
     */
    private String bucket;

}


