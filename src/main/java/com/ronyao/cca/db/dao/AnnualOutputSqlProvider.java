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

import com.ronyao.cca.db.model.AnnualOutput;
import com.ronyao.cca.db.model.AnnualOutputExample.Criteria;
import com.ronyao.cca.db.model.AnnualOutputExample.Criterion;
import com.ronyao.cca.db.model.AnnualOutputExample;
import java.util.List;
import java.util.Map;

public class AnnualOutputSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String countByExample(AnnualOutputExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("annual_output");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String deleteByExample(AnnualOutputExample example) {
		BEGIN();
		DELETE_FROM("annual_output");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String insertSelective(AnnualOutput record) {
		BEGIN();
		INSERT_INTO("annual_output");
		if (record.getVoltagerankid() != null) {
			VALUES("voltageRankId", "#{voltagerankid,jdbcType=INTEGER}");
		}
		if (record.getProjecttype() != null) {
			VALUES("projectType", "#{projecttype,jdbcType=TINYINT}");
		}
		if (record.getTimelimit() != null) {
			VALUES("timeLimit", "#{timelimit,jdbcType=TINYINT}");
		}
		if (record.getProjectnum() != null) {
			VALUES("projectNum", "#{projectnum,jdbcType=DECIMAL}");
		}
		if (record.getAnnualoutput() != null) {
			VALUES("annualOutPut", "#{annualoutput,jdbcType=INTEGER}");
		}
		if (record.getRemark() != null) {
			VALUES("remark", "#{remark,jdbcType=VARCHAR}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String selectByExample(AnnualOutputExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("voltageRankId");
		SELECT("projectType");
		SELECT("timeLimit");
		SELECT("projectNum");
		SELECT("annualOutPut");
		SELECT("remark");
		SELECT("createTime");
		SELECT("updateTime");
		FROM("annual_output");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		AnnualOutput record = (AnnualOutput) parameter.get("record");
		AnnualOutputExample example = (AnnualOutputExample) parameter
				.get("example");
		BEGIN();
		UPDATE("annual_output");
		if (record.getId() != null) {
			SET("id = #{record.id,jdbcType=TINYINT}");
		}
		if (record.getVoltagerankid() != null) {
			SET("voltageRankId = #{record.voltagerankid,jdbcType=INTEGER}");
		}
		if (record.getProjecttype() != null) {
			SET("projectType = #{record.projecttype,jdbcType=TINYINT}");
		}
		if (record.getTimelimit() != null) {
			SET("timeLimit = #{record.timelimit,jdbcType=TINYINT}");
		}
		if (record.getProjectnum() != null) {
			SET("projectNum = #{record.projectnum,jdbcType=DECIMAL}");
		}
		if (record.getAnnualoutput() != null) {
			SET("annualOutPut = #{record.annualoutput,jdbcType=INTEGER}");
		}
		if (record.getRemark() != null) {
			SET("remark = #{record.remark,jdbcType=VARCHAR}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("annual_output");
		SET("id = #{record.id,jdbcType=TINYINT}");
		SET("voltageRankId = #{record.voltagerankid,jdbcType=INTEGER}");
		SET("projectType = #{record.projecttype,jdbcType=TINYINT}");
		SET("timeLimit = #{record.timelimit,jdbcType=TINYINT}");
		SET("projectNum = #{record.projectnum,jdbcType=DECIMAL}");
		SET("annualOutPut = #{record.annualoutput,jdbcType=INTEGER}");
		SET("remark = #{record.remark,jdbcType=VARCHAR}");
		SET("createTime = #{record.createtime,jdbcType=VARCHAR}");
		SET("updateTime = #{record.updatetime,jdbcType=VARCHAR}");
		AnnualOutputExample example = (AnnualOutputExample) parameter
				.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String updateByPrimaryKeySelective(AnnualOutput record) {
		BEGIN();
		UPDATE("annual_output");
		if (record.getVoltagerankid() != null) {
			SET("voltageRankId = #{voltagerankid,jdbcType=INTEGER}");
		}
		if (record.getProjecttype() != null) {
			SET("projectType = #{projecttype,jdbcType=TINYINT}");
		}
		if (record.getTimelimit() != null) {
			SET("timeLimit = #{timelimit,jdbcType=TINYINT}");
		}
		if (record.getProjectnum() != null) {
			SET("projectNum = #{projectnum,jdbcType=DECIMAL}");
		}
		if (record.getAnnualoutput() != null) {
			SET("annualOutPut = #{annualoutput,jdbcType=INTEGER}");
		}
		if (record.getRemark() != null) {
			SET("remark = #{remark,jdbcType=VARCHAR}");
		}
		if (record.getCreatetime() != null) {
			SET("createTime = #{createtime,jdbcType=VARCHAR}");
		}
		if (record.getUpdatetime() != null) {
			SET("updateTime = #{updatetime,jdbcType=VARCHAR}");
		}
		WHERE("id = #{id,jdbcType=TINYINT}");
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	protected void applyWhere(AnnualOutputExample example,
			boolean includeExamplePhrase) {
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
							sb.append(String.format(parmPhrase1,
									criterion.getCondition(), i, j));
						} else {
							sb.append(String.format(parmPhrase1_th,
									criterion.getCondition(), i, j,
									criterion.getTypeHandler()));
						}
					} else if (criterion.isBetweenValue()) {
						if (criterion.getTypeHandler() == null) {
							sb.append(String.format(parmPhrase2,
									criterion.getCondition(), i, j, i, j));
						} else {
							sb.append(String.format(parmPhrase2_th,
									criterion.getCondition(), i, j,
									criterion.getTypeHandler(), i, j,
									criterion.getTypeHandler()));
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
								sb.append(String.format(parmPhrase3_th, i, j,
										k, criterion.getTypeHandler()));
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