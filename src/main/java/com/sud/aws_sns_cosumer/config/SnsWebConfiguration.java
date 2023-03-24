package com.sud.aws_sns_cosumer.config;

import com.amazonaws.services.sns.AmazonSNS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.context.annotation.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static org.springframework.cloud.aws.messaging.endpoint.config.NotificationHandlerMethodArgumentResolverConfigurationUtils.getNotificationHandlerMethodArgumentResolver;

@Configuration
@ConditionalOnClass("org.springframework.web.servlet.config.annotation.WebMvcConfigurer")
public class SnsWebConfiguration implements WebMvcConfigurer {

    @Autowired
    private AmazonSNS amazonSns;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(getNotificationHandlerMethodArgumentResolver(this.amazonSns));
    }

}