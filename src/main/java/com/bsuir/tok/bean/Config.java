package com.bsuir.tok.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySources({@PropertySource(value = "classpath:config.properties", ignoreResourceNotFound = true)})
public class Config {

    @Value("${version}")
    private String version;

    @Value("${author}")
    private String owner;

    @Value("${subject}")
    private String subject;

    @Value("${basic_info}")
    private String basicInfo;

    public String getVersion() {
        return version;
    }

    public String getOwner() {
        return owner;
    }

    public String getSubject() {
        return subject;
    }

    public String getBasicInfo() {
        return basicInfo;
    }

    @Override
    public String toString() {
        return "Configation{" + "version='" + version + '\'' + ", owner='" + owner + '\'' + ", subject='" + subject
            + '\'' + ", basicInfo='" + basicInfo + '\'' + '}';
    }
}
