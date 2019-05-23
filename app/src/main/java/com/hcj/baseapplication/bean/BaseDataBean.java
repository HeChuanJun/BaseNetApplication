package com.hcj.baseapplication.bean;

public class BaseDataBean {
    /**
     * androidDownloadUrl : https://www.tepay.cc/yangtihuan
     * iosForcedUpgrade : 0
     * versionId : 4.0.2
     * androidVersionId : 4.0.2
     * iosDownloadUrl : https://www.tepay.cc/yangtihuan
     * resCode : 0
     * resMsg : 获取成功
     * androidForcedUpgrade : 0
     */

    private String androidDownloadUrl;
    private int iosForcedUpgrade;
    private String versionId;
    private String androidVersionId;
    private String iosDownloadUrl;
    private String resCode;
    private String resMsg;
    private int androidForcedUpgrade;

    public String getAndroidDownloadUrl() {
        return androidDownloadUrl;
    }

    public void setAndroidDownloadUrl(String androidDownloadUrl) {
        this.androidDownloadUrl = androidDownloadUrl;
    }

    public int getIosForcedUpgrade() {
        return iosForcedUpgrade;
    }

    public void setIosForcedUpgrade(int iosForcedUpgrade) {
        this.iosForcedUpgrade = iosForcedUpgrade;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getAndroidVersionId() {
        return androidVersionId;
    }

    public void setAndroidVersionId(String androidVersionId) {
        this.androidVersionId = androidVersionId;
    }

    public String getIosDownloadUrl() {
        return iosDownloadUrl;
    }

    public void setIosDownloadUrl(String iosDownloadUrl) {
        this.iosDownloadUrl = iosDownloadUrl;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public int getAndroidForcedUpgrade() {
        return androidForcedUpgrade;
    }

    public void setAndroidForcedUpgrade(int androidForcedUpgrade) {
        this.androidForcedUpgrade = androidForcedUpgrade;
    }
}
