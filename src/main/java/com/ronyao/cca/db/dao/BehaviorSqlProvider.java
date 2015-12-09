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

import com.ronyao.cca.db.model.Behavior;
import com.ronyao.cca.db.model.BehaviorExample.Criteria;
import com.ronyao.cca.db.model.BehaviorExample.Criterion;
import com.ronyao.cca.db.model.BehaviorExample;
import java.util.List;
import java.util.Map;

public class BehaviorSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    public String countByExample(BehaviorExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("behavior");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    public String deleteByExample(BehaviorExample example) {
        BEGIN();
        DELETE_FROM("behavior");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    public String insertSelective(Behavior record) {
        BEGIN();
        INSERT_INTO("behavior");
        
        if (record.getEnterpriseid() != null) {
            VALUES("enterpriseId", "#{enterpriseid,jdbcType=INTEGER}");
        }
        
        if (record.getYear() != null) {
            VALUES("year", "#{year,jdbcType=INTEGER}");
        }
        
        if (record.getGeneralbadnum() != null) {
            VALUES("generalbadNum", "#{generalbadnum,jdbcType=TINYINT}");
        }
        
        if (record.getSeriousbadnum() != null) {
            VALUES("seriousBadNum", "#{seriousbadnum,jdbcType=TINYINT}");
        }
        
        if (record.getCreatetime() != null) {
            VALUES("createTime", "#{createtime,jdbcType=TINYINT}");
        }
        
        if (record.getUpdatetime() != null) {
            VALUES("updateTime", "#{updatetime,jdbcType=TINYINT}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    public String selectByExample(BehaviorExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("enterpriseId");
        SELECT("year");
        SELECT("generalbadNum");
        SELECT("seriousBadNum");
        SELECT("createTime");
        SELECT("updateTime");
        FROM("behavior");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Behavior record = (Behavior) parameter.get("record");
        BehaviorExample example = (BehaviorExample) parameter.get("example");
        
        BEGIN();
        UPDATE("behavior");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getEnterpriseid() != null) {
            SET("enterpriseId = #{record.enterpriseid,jdbcType=INTEGER}");
        }
        
        if (record.getYear() != null) {
            SET("year = #{record.year,jdbcType=INTEGER}");
        }
        
        if (record.getGeneralbadnum() != null) {
            SET("generalbadNum = #{record.generalbadnum,jdbcType=TINYINT}");
        }
        
        if (record.getSeriousbadnum() != null) {
            SET("seriousBadNum = #{record.seriousbadnum,jdbcType=TINYINT}");
        }
        
        if (record.getCreatetime() != null) {
            SET("createTime = #{record.createtime,jdbcType=TINYINT}");
        }
        
        if (record.getUpdatetime() != null) {
            SET("updateTime = #{record.updatetime,jdbcType=TINYINT}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("behavior");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("enterpriseId = #{record.enterpriseid,jdbcType=INTEGER}");
        SET("year = #{record.year,jdbcType=INTEGER}");
        SET("generalbadNum = #{record.generalbadnum,jdbcType=TINYINT}");
        SET("seriousBadNum = #{record.seriousbadnum,jdbcType=TINYINT}");
        SET("createTime = #{record.createtime,jdbcType=TINYINT}");
        SET("updateTime = #{record.updatetime,jdbcType=TINYINT}");
        
        BehaviorExample example = (BehaviorExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    public String updateByPrimaryKeySelective(Behavior record) {
        BEGIN();
        UPDATE("behavior");
        
        if (record.getEnterpriseid() != null) {
            SET("enterpriseId = #{enterpriseid,jdbcType=INTEGER}");
        }
        
        if (record.getYear() != null) {
            SET("year = #{year,jdbcType=INTEGER}");
        }
        
        if (record.getGeneralbadnum() != null) {
            SET("generalbadNum = #{generalbadnum,jdbcType=TINYINT}");
        }
        
        if (record.getSeriousbadnum() != null) {
            SET("seriousBadNum = #{seriousbadnum,jdbcType=TINYINT}");
        }
        
        if (record.getCreatetime() != null) {
            SET("createTime = #{createtime,jdbcType=TINYINT}");
        }
        
        if (record.getUpdatetime() != null) {
            SET("updateTime = #{updatetime,jdbcType=TINYINT}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior
     *
     * @mbggenerated Wed Dec 09 15:42:41 CST 2015
     */
    protected void applyWhere(BehaviorExample example, boolean includeExamplePhrase) {
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