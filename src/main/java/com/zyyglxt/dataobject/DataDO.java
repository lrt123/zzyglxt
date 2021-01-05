package com.zyyglxt.dataobject;

import java.util.Date;

public class DataDO extends DataDOKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_culpro_data.DATA_TITLE
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    private String dataTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_culpro_data.DATA_LOCATION
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    private String dataLocation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_culpro_data.DATA_AUTHOR
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    private String dataAuthor;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_culpro_data.DATA_SOURCE
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    private String dataSource;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_culpro_data.DATA_FILE_TYPE
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    private String dataFileType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_culpro_data.DATA_DELAYED_RELEASE
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    private Date dataDelayedRelease;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_culpro_data.DATA_STATUS
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    private String dataStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_culpro_data.DATA_TYPE
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    private String dataType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_culpro_data.CREATER
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    private String creater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_culpro_data.itemCreateAt
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    private Date itemcreateat;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_culpro_data.UPDATER
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    private String updater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_culpro_data.itemUpdateAt
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    private Date itemupdateat;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_culpro_data.DATA_CONTENT
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    private String dataContent;

    //新增RELEASE_OR_NOT字段，注释是否发布到河北中医药网
    private String releaseOrNot;

    /**
     * 新增VISIT_SUM字段，注释浏览次数
     */
    private Integer visitNum;

    public String getReleaseOrNot() {
        return releaseOrNot;
    }

    public void setReleaseOrNot(String releaseOrNot) {
        this.releaseOrNot = releaseOrNot == null ? null : releaseOrNot.trim();
    }

    public Integer getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(Integer visitNum) {
        this.visitNum = visitNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_culpro_data.DATA_TITLE
     *
     * @return the value of tb_culpro_data.DATA_TITLE
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public String getDataTitle() {
        return dataTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_culpro_data.DATA_TITLE
     *
     * @param dataTitle the value for tb_culpro_data.DATA_TITLE
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public void setDataTitle(String dataTitle) {
        this.dataTitle = dataTitle == null ? null : dataTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_culpro_data.DATA_LOCATION
     *
     * @return the value of tb_culpro_data.DATA_LOCATION
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public String getDataLocation() {
        return dataLocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_culpro_data.DATA_LOCATION
     *
     * @param dataLocation the value for tb_culpro_data.DATA_LOCATION
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public void setDataLocation(String dataLocation) {
        this.dataLocation = dataLocation == null ? null : dataLocation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_culpro_data.DATA_AUTHOR
     *
     * @return the value of tb_culpro_data.DATA_AUTHOR
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public String getDataAuthor() {
        return dataAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_culpro_data.DATA_AUTHOR
     *
     * @param dataAuthor the value for tb_culpro_data.DATA_AUTHOR
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public void setDataAuthor(String dataAuthor) {
        this.dataAuthor = dataAuthor == null ? null : dataAuthor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_culpro_data.DATA_SOURCE
     *
     * @return the value of tb_culpro_data.DATA_SOURCE
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_culpro_data.DATA_SOURCE
     *
     * @param dataSource the value for tb_culpro_data.DATA_SOURCE
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_culpro_data.DATA_FILE_TYPE
     *
     * @return the value of tb_culpro_data.DATA_FILE_TYPE
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public String getDataFileType() {
        return dataFileType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_culpro_data.DATA_FILE_TYPE
     *
     * @param dataFileType the value for tb_culpro_data.DATA_FILE_TYPE
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public void setDataFileType(String dataFileType) {
        this.dataFileType = dataFileType == null ? null : dataFileType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_culpro_data.DATA_DELAYED_RELEASE
     *
     * @return the value of tb_culpro_data.DATA_DELAYED_RELEASE
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public Date getDataDelayedRelease() {
        return dataDelayedRelease;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_culpro_data.DATA_DELAYED_RELEASE
     *
     * @param dataDelayedRelease the value for tb_culpro_data.DATA_DELAYED_RELEASE
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public void setDataDelayedRelease(Date dataDelayedRelease) {
        this.dataDelayedRelease = dataDelayedRelease;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_culpro_data.DATA_STATUS
     *
     * @return the value of tb_culpro_data.DATA_STATUS
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public String getDataStatus() {
        return dataStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_culpro_data.DATA_STATUS
     *
     * @param dataStatus the value for tb_culpro_data.DATA_STATUS
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus == null ? null : dataStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_culpro_data.DATA_TYPE
     *
     * @return the value of tb_culpro_data.DATA_TYPE
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_culpro_data.DATA_TYPE
     *
     * @param dataType the value for tb_culpro_data.DATA_TYPE
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_culpro_data.CREATER
     *
     * @return the value of tb_culpro_data.CREATER
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public String getCreater() {
        return creater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_culpro_data.CREATER
     *
     * @param creater the value for tb_culpro_data.CREATER
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_culpro_data.itemCreateAt
     *
     * @return the value of tb_culpro_data.itemCreateAt
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public Date getItemcreateat() {
        return itemcreateat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_culpro_data.itemCreateAt
     *
     * @param itemcreateat the value for tb_culpro_data.itemCreateAt
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public void setItemcreateat(Date itemcreateat) {
        this.itemcreateat = itemcreateat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_culpro_data.UPDATER
     *
     * @return the value of tb_culpro_data.UPDATER
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_culpro_data.UPDATER
     *
     * @param updater the value for tb_culpro_data.UPDATER
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_culpro_data.itemUpdateAt
     *
     * @return the value of tb_culpro_data.itemUpdateAt
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public Date getItemupdateat() {
        return itemupdateat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_culpro_data.itemUpdateAt
     *
     * @param itemupdateat the value for tb_culpro_data.itemUpdateAt
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public void setItemupdateat(Date itemupdateat) {
        this.itemupdateat = itemupdateat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_culpro_data.DATA_CONTENT
     *
     * @return the value of tb_culpro_data.DATA_CONTENT
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public String getDataContent() {
        return dataContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_culpro_data.DATA_CONTENT
     *
     * @param dataContent the value for tb_culpro_data.DATA_CONTENT
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    public void setDataContent(String dataContent) {
        this.dataContent = dataContent == null ? null : dataContent.trim();
    }
}