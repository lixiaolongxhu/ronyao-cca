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

import com.ronyao.cca.db.model.EnterpriseAptitude;
import com.ronyao.cca.db.model.EnterpriseAptitudeExample.Criteria;
import com.ronyao.cca.db.model.EnterpriseAptitudeExample.Criterion;
import com.ronyao.cca.db.model.EnterpriseAptitudeExample;
import java.util.List;
import java.util.Map;

public class EnterpriseAptitudeSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_aptitude
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String countByExample(EnterpriseAptitudeExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("enterprise_aptitude");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_aptitude
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String deleteByExample(EnterpriseAptitudeExample example) {
        BEGIN();
        DELETE_FROM("enterprise_aptitude");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_aptitude
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String insertSelective(EnterpriseAptitude record) {
        BEGIN();
        INSERT_INTO("enterprise_aptitude");
        
        if (record.getAptitudeid() != null) {
            VALUES("aptitudeId", "#{aptitudeid,jdbcType=TINYINT}");
        }
        
        if (record.getAptituderank() != null) {
            VALUES("aptitudeRank", "#{aptituderank,jdbcType=TINYINT}");
        }
        
        if (record.getQualifications() != null) {
            VALUES("qualifications", "#{qualifications,jdbcType=VARCHAR}");
        }
        
        if (record.getPracticing() != null) {
            VALUES("practicing", "#{practicing,jdbcType=VARCHAR}");
        }
        
        if (record.getCharge() != null) {
            VALUES("charge", "#{charge,jdbcType=VARCHAR}");
        }
        
        if (record.getTechnical() != null) {
            VALUES("technical", "#{technical,jdbcType=VARCHAR}");
        }
        
        if (record.getSkills() != null) {
            VALUES("skills", "#{skills,jdbcType=VARCHAR}");
        }
        
        if (record.getJobrange() != null) {
            VALUES("jobRange", "#{jobrange,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            VALUES("createTime", "#{createtime,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdatetime() != null) {
            VALUES("updateTime", "#{updatetime,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_aptitude
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String selectByExample(EnterpriseAptitudeExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("aptitudeId");
        SELECT("aptitudeRank");
        SELECT("qualifications");
        SELECT("practicing");
        SELECT("charge");
        SELECT("technical");
        SELECT("skills");
        SELECT("jobRange");
        SELECT("createTime");
        SELECT("updateTime");
        FROM("enterprise_aptitude");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_aptitude
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        EnterpriseAptitude record = (EnterpriseAptitude) parameter.get("record");
        EnterpriseAptitudeExample example = (EnterpriseAptitudeExample) parameter.get("example");
        
        BEGIN();
        UPDATE("enterprise_aptitude");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getAptitudeid() != null) {
            SET("aptitudeId = #{record.aptitudeid,jdbcType=TINYINT}");
        }
        
        if (record.getAptituderank() != null) {
            SET("aptitudeRank = #{record.aptituderank,jdbcType=TINYINT}");
        }
        
        if (record.getQualifications() != null) {
            SET("qualifications = #{record.qualifications,jdbcType=VARCHAR}");
        }
        
        if (record.getPracticing() != null) {
            SET("practicing = #{record.practicing,jdbcType=VARCHAR}");
        }
        
        if (record.getCharge() != null) {
            SET("charge = #{record.charge,jdbcType=VARCHAR}");
        }
        
        if (record.getTechnical() != null) {
            SET("technical = #{record.technical,jdbcType=VARCHAR}");
        }
        
        if (record.getSkills() != null) {
            SET("skills = #{record.skills,jdbcType=VARCHAR}");
        }
        
        if (record.getJobrange() != null) {
            SET("jobRange = #{record.jobrange,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            SET("createTime = #{record.createtime,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdatetime() != null) {
            SET("updateTime = #{record.updatetime,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_aptitude
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("enterprise_aptitude");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("aptitudeId = #{record.aptitudeid,jdbcType=TINYINT}");
        SET("aptitudeRank = #{record.aptituderank,jdbcType=TINYINT}");
        SET("qualifications = #{record.qualifications,jdbcType=VARCHAR}");
        SET("practicing = #{record.practicing,jdbcType=VARCHAR}");
        SET("charge = #{record.charge,jdbcType=VARCHAR}");
        SET("technical = #{record.technical,jdbcType=VARCHAR}");
        SET("skills = #{record.skills,jdbcType=VARCHAR}");
        SET("jobRange = #{record.jobrange,jdbcType=VARCHAR}");
        SET("createTime = #{record.createtime,jdbcType=VARCHAR}");
        SET("updateTime = #{record.updatetime,jdbcType=VARCHAR}");
        
        EnterpriseAptitudeExample example = (EnterpriseAptitudeExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_aptitude
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String updateByPrimaryKeySelective(EnterpriseAptitude record) {
        BEGIN();
        UPDATE("enterprise_aptitude");
        
        if (record.getAptitudeid() != null) {
            SET("aptitudeId = #{aptitudeid,jdbcType=TINYINT}");
        }
        
        if (record.getAptituderank() != null) {
            SET("aptitudeRank = #{aptituderank,jdbcType=TINYINT}");
        }
        
        if (record.getQualifications() != null) {
            SET("qualifications = #{qualifications,jdbcType=VARCHAR}");
        }
        
        if (record.getPracticing() != null) {
            SET("practicing = #{practicing,jdbcType=VARCHAR}");
        }
        
        if (record.getCharge() != null) {
            SET("charge = #{charge,jdbcType=VARCHAR}");
        }
        
        if (record.getTechnical() != null) {
            SET("technical = #{technical,jdbcType=VARCHAR}");
        }
        
        if (record.getSkills() != null) {
            SET("skills = #{skills,jdbcType=VARCHAR}");
        }
        
        if (record.getJobrange() != null) {
            SET("jobRange = #{jobrange,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            SET("createTime = #{createtime,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdatetime() != null) {
            SET("updateTime = #{updatetime,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_aptitude
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    protected void applyWhere(EnterpriseAptitudeExample example, boolean includeExamplePhrase) {
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