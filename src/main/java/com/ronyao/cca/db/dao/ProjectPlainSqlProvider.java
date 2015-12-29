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

import com.ronyao.cca.db.model.ProjectPlain;
import com.ronyao.cca.db.model.ProjectPlainExample.Criteria;
import com.ronyao.cca.db.model.ProjectPlainExample.Criterion;
import com.ronyao.cca.db.model.ProjectPlainExample;
import java.util.List;
import java.util.Map;

public class ProjectPlainSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_plain
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String countByExample(ProjectPlainExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("project_plain");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_plain
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String deleteByExample(ProjectPlainExample example) {
        BEGIN();
        DELETE_FROM("project_plain");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_plain
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String insertSelective(ProjectPlain record) {
        BEGIN();
        INSERT_INTO("project_plain");
        
        if (record.getVoltagerankclassifyid() != null) {
            VALUES("voltageRankClassifyId", "#{voltagerankclassifyid,jdbcType=INTEGER}");
        }
        
        if (record.getYear() != null) {
            VALUES("year", "#{year,jdbcType=INTEGER}");
        }
        
        if (record.getProjectnum() != null) {
            VALUES("projectNum", "#{projectnum,jdbcType=INTEGER}");
        }
        
        if (record.getLineproject() != null) {
            VALUES("lineProject", "#{lineproject,jdbcType=INTEGER}");
        }
        
        if (record.getPowerproject() != null) {
            VALUES("powerProject", "#{powerproject,jdbcType=INTEGER}");
        }
        
        if (record.getAssesslineproject() != null) {
            VALUES("assessLineProject", "#{assesslineproject,jdbcType=INTEGER}");
        }
        
        if (record.getAssesspowerproject() != null) {
            VALUES("assessPowerProject", "#{assesspowerproject,jdbcType=INTEGER}");
        }
        
        if (record.getLinelength() != null) {
            VALUES("lineLength", "#{linelength,jdbcType=INTEGER}");
        }
        
        if (record.getVolume() != null) {
            VALUES("volume", "#{volume,jdbcType=INTEGER}");
        }
        
        if (record.getInvestment() != null) {
            VALUES("investment", "#{investment,jdbcType=DECIMAL}");
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
     * This method corresponds to the database table project_plain
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String selectByExample(ProjectPlainExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("voltageRankClassifyId");
        SELECT("year");
        SELECT("projectNum");
        SELECT("lineProject");
        SELECT("powerProject");
        SELECT("assessLineProject");
        SELECT("assessPowerProject");
        SELECT("lineLength");
        SELECT("volume");
        SELECT("investment");
        SELECT("createTime");
        SELECT("updateTime");
        FROM("project_plain");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_plain
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        ProjectPlain record = (ProjectPlain) parameter.get("record");
        ProjectPlainExample example = (ProjectPlainExample) parameter.get("example");
        
        BEGIN();
        UPDATE("project_plain");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getVoltagerankclassifyid() != null) {
            SET("voltageRankClassifyId = #{record.voltagerankclassifyid,jdbcType=INTEGER}");
        }
        
        if (record.getYear() != null) {
            SET("year = #{record.year,jdbcType=INTEGER}");
        }
        
        if (record.getProjectnum() != null) {
            SET("projectNum = #{record.projectnum,jdbcType=INTEGER}");
        }
        
        if (record.getLineproject() != null) {
            SET("lineProject = #{record.lineproject,jdbcType=INTEGER}");
        }
        
        if (record.getPowerproject() != null) {
            SET("powerProject = #{record.powerproject,jdbcType=INTEGER}");
        }
        
        if (record.getAssesslineproject() != null) {
            SET("assessLineProject = #{record.assesslineproject,jdbcType=INTEGER}");
        }
        
        if (record.getAssesspowerproject() != null) {
            SET("assessPowerProject = #{record.assesspowerproject,jdbcType=INTEGER}");
        }
        
        if (record.getLinelength() != null) {
            SET("lineLength = #{record.linelength,jdbcType=INTEGER}");
        }
        
        if (record.getVolume() != null) {
            SET("volume = #{record.volume,jdbcType=INTEGER}");
        }
        
        if (record.getInvestment() != null) {
            SET("investment = #{record.investment,jdbcType=DECIMAL}");
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
     * This method corresponds to the database table project_plain
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("project_plain");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("voltageRankClassifyId = #{record.voltagerankclassifyid,jdbcType=INTEGER}");
        SET("year = #{record.year,jdbcType=INTEGER}");
        SET("projectNum = #{record.projectnum,jdbcType=INTEGER}");
        SET("lineProject = #{record.lineproject,jdbcType=INTEGER}");
        SET("powerProject = #{record.powerproject,jdbcType=INTEGER}");
        SET("assessLineProject = #{record.assesslineproject,jdbcType=INTEGER}");
        SET("assessPowerProject = #{record.assesspowerproject,jdbcType=INTEGER}");
        SET("lineLength = #{record.linelength,jdbcType=INTEGER}");
        SET("volume = #{record.volume,jdbcType=INTEGER}");
        SET("investment = #{record.investment,jdbcType=DECIMAL}");
        SET("createTime = #{record.createtime,jdbcType=VARCHAR}");
        SET("updateTime = #{record.updatetime,jdbcType=VARCHAR}");
        
        ProjectPlainExample example = (ProjectPlainExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_plain
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String updateByPrimaryKeySelective(ProjectPlain record) {
        BEGIN();
        UPDATE("project_plain");
        
        if (record.getVoltagerankclassifyid() != null) {
            SET("voltageRankClassifyId = #{voltagerankclassifyid,jdbcType=INTEGER}");
        }
        
        if (record.getYear() != null) {
            SET("year = #{year,jdbcType=INTEGER}");
        }
        
        if (record.getProjectnum() != null) {
            SET("projectNum = #{projectnum,jdbcType=INTEGER}");
        }
        
        if (record.getLineproject() != null) {
            SET("lineProject = #{lineproject,jdbcType=INTEGER}");
        }
        
        if (record.getPowerproject() != null) {
            SET("powerProject = #{powerproject,jdbcType=INTEGER}");
        }
        
        if (record.getAssesslineproject() != null) {
            SET("assessLineProject = #{assesslineproject,jdbcType=INTEGER}");
        }
        
        if (record.getAssesspowerproject() != null) {
            SET("assessPowerProject = #{assesspowerproject,jdbcType=INTEGER}");
        }
        
        if (record.getLinelength() != null) {
            SET("lineLength = #{linelength,jdbcType=INTEGER}");
        }
        
        if (record.getVolume() != null) {
            SET("volume = #{volume,jdbcType=INTEGER}");
        }
        
        if (record.getInvestment() != null) {
            SET("investment = #{investment,jdbcType=DECIMAL}");
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
     * This method corresponds to the database table project_plain
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    protected void applyWhere(ProjectPlainExample example, boolean includeExamplePhrase) {
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