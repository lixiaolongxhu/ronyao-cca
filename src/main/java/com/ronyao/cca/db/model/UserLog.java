package com.ronyao.cca.db.model;

import java.util.Date;

public class UserLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_log.id
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_log.uid
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_log.user_action
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    private String userAction;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_log.operate_time
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    private Date operateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_log.ip_address
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    private String ipAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_log.comment_info
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    private String commentInfo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_log.id
     *
     * @return the value of user_log.id
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_log.id
     *
     * @param id the value for user_log.id
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_log.uid
     *
     * @return the value of user_log.uid
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_log.uid
     *
     * @param uid the value for user_log.uid
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_log.user_action
     *
     * @return the value of user_log.user_action
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String getUserAction() {
        return userAction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_log.user_action
     *
     * @param userAction the value for user_log.user_action
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public void setUserAction(String userAction) {
        this.userAction = userAction == null ? null : userAction.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_log.operate_time
     *
     * @return the value of user_log.operate_time
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_log.operate_time
     *
     * @param operateTime the value for user_log.operate_time
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_log.ip_address
     *
     * @return the value of user_log.ip_address
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_log.ip_address
     *
     * @param ipAddress the value for user_log.ip_address
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_log.comment_info
     *
     * @return the value of user_log.comment_info
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String getCommentInfo() {
        return commentInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_log.comment_info
     *
     * @param commentInfo the value for user_log.comment_info
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo == null ? null : commentInfo.trim();
    }
}