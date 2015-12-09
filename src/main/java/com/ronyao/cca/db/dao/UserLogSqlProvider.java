package com.ronyao.cca.db.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.ronyao.cca.db.model.UserLog;
import com.ronyao.cca.db.model.UserLogExample.Criteria;
import com.ronyao.cca.db.model.UserLogExample.Criterion;
import com.ronyao.cca.db.model.UserLogExample;
import java.util.List;
import java.util.Map;

public class UserLogSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    public String countByExample(UserLogExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("user_log");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    public String deleteByExample(UserLogExample example) {
        BEGIN();
        DELETE_FROM("user_log");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    public String insertSelective(UserLog record) {
        BEGIN();
        INSERT_INTO("user_log");
        
        if (record.getUid() != null) {
            VALUES("uid", "#{uid,jdbcType=INTEGER}");
        }
        
        if (record.getUserAction() != null) {
            VALUES("user_action", "#{userAction,jdbcType=VARCHAR}");
        }
        
        if (record.getOperateTime() != null) {
            VALUES("operate_time", "#{operateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIpAddress() != null) {
            VALUES("ip_address", "#{ipAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCommentInfo() != null) {
            VALUES("comment_info", "#{commentInfo,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    public String selectByExample(UserLogExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("uid");
        SELECT("user_action");
        SELECT("operate_time");
        SELECT("ip_address");
        SELECT("comment_info");
        FROM("user_log");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserLog record = (UserLog) parameter.get("record");
        UserLogExample example = (UserLogExample) parameter.get("example");
        
        BEGIN();
        UPDATE("user_log");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            SET("uid = #{record.uid,jdbcType=INTEGER}");
        }
        
        if (record.getUserAction() != null) {
            SET("user_action = #{record.userAction,jdbcType=VARCHAR}");
        }
        
        if (record.getOperateTime() != null) {
            SET("operate_time = #{record.operateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIpAddress() != null) {
            SET("ip_address = #{record.ipAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCommentInfo() != null) {
            SET("comment_info = #{record.commentInfo,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("user_log");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("uid = #{record.uid,jdbcType=INTEGER}");
        SET("user_action = #{record.userAction,jdbcType=VARCHAR}");
        SET("operate_time = #{record.operateTime,jdbcType=TIMESTAMP}");
        SET("ip_address = #{record.ipAddress,jdbcType=VARCHAR}");
        SET("comment_info = #{record.commentInfo,jdbcType=VARCHAR}");
        
        UserLogExample example = (UserLogExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    public String updateByPrimaryKeySelective(UserLog record) {
        BEGIN();
        UPDATE("user_log");
        
        if (record.getUid() != null) {
            SET("uid = #{uid,jdbcType=INTEGER}");
        }
        
        if (record.getUserAction() != null) {
            SET("user_action = #{userAction,jdbcType=VARCHAR}");
        }
        
        if (record.getOperateTime() != null) {
            SET("operate_time = #{operateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIpAddress() != null) {
            SET("ip_address = #{ipAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCommentInfo() != null) {
            SET("comment_info = #{commentInfo,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    protected void applyWhere(UserLogExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}