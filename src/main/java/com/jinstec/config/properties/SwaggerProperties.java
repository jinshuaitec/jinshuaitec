package com.jinstec.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author jins
 */
@Component
public class SwaggerProperties {

    /**
     * 是否开启Swagger
     */
    @Value("${swagger.enable}")
    private boolean enable = false;

    /**
     * 要扫描的包
     */
    @Value("${swagger.packageScan}")
    private String packageScan;

    /**
     * 标题
     */
    @Value("${swagger.title}")
    private String title;

    /**
     * 描述
     */
    @Value("${swagger.description}")
    private String description;

    /**
     * 版本信息
     */
    @Value("${swagger.version}")
    private String version;

    /**
     * 联系人姓名
     */
    @Value("${swagger.contact.name}")
    private String contactName;

    /**
     * 联系人网站
     */
    @Value("${swagger.contact.url}")
    private String contactUrl;

    /**
     * 联系人邮箱
     */
    @Value("${swagger.contact.email}")
    private String contactEmail;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getPackageScan() {
        return packageScan;
    }

    public void setPackageScan(String packageScan) {
        this.packageScan = packageScan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactUrl() {
        return contactUrl;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
