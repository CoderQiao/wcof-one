package cn.qtlplay.wcofone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @description: swagger2配置类
 * @author: Qiao Tongliang
 * @create: 2021-01-29
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("微信点餐系统API接口")
                        .description("单体架构 后台API接口")
                        .termsOfServiceUrl("www.qtlplay.cn")
                        .contact(new Contact("乔同良","www.qtlplay.cn","2324805058@qq.com"))
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("单体架构")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("cn.qtlplay.wcofone"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
