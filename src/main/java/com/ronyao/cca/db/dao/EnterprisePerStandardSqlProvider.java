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

import com.ronyao.cca.db.model.EnterprisePerStandard;
import com.ronyao.cca.db.model.EnterprisePerStandardExample.Criteria;
import com.ronyao.cca.db.model.EnterprisePerStandardExample.Criterion;
import com.ronyao.cca.db.model.EnterprisePerStandardExample;
import java.util.List;
import java.util.Map;

public class EnterprisePerStandardSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_standard
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	public String countByExample(EnterprisePerStandardExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("enterprise_per_standard");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_standard
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	public String deleteByExample(EnterprisePerStandardExample example) {
		BEGIN();
		DELETE_FROM("enterprise_per_standard");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_standard
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	public String insertSelective(EnterprisePerStandard record) {
		BEGIN();
		INSERT_INTO("enterprise_per_standard");
		if (record.getPostclassifyid() != null) {
			VALUES("postClassifyId", "#{postclassifyid,jdbcType=INTEGER}");
		}
		if (record.getHolderrequire() != null) {
			VALUES("holderRequire", "#{holderrequire,jdbcType=VARCHAR}");
		}
		if (record.getLineflatnum() != null) {
			VALUES("lineFlatNum", "#{lineflatnum,jdbcType=TINYINT}");
		}
		if (record.getLinemountainnum() != null) {
			VALUES("lineMountainNum", "#{linemountainnum,jdbcType=TINYINT}");
		}
		if (record.getPowernum() != null) {
			VALUES("powerNum", "#{powernum,jdbcType=TINYINT}");
		}
		if (record.getJob() != null) {
			VALUES("job", "#{job,jdbcType=TINYINT}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_standard
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	public String selectByExample(EnterprisePerStandardExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("postClassifyId");
		SELECT("holderRequire");
		SELECT("lineFlatNum");
		SELECT("lineMountainNum");
		SELECT("powerNum");
		SELECT("job");
		SELECT("remark");
		SELECT("createTime");
		SELECT("updateTime");
		FROM("enterprise_per_standard");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_standard
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		EnterprisePerStandard record = (EnterprisePerStandard) parameter
				.get("record");
		EnterprisePerStandardExample example = (EnterprisePerStandardExample) parameter
				.get("example");
		BEGIN();
		UPDATE("enterprise_per_standard");
		if (record.getId() != null) {
			SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getPostclassifyid() != null) {
			SET("postClassifyId = #{record.postclassifyid,jdbcType=INTEGER}");
		}
		if (record.getHolderrequire() != null) {
			SET("holderRequire = #{record.holderrequire,jdbcType=VARCHAR}");
		}
		if (record.getLineflatnum() != null) {
			SET("lineFlatNum = #{record.lineflatnum,jdbcType=TINYINT}");
		}
		if (record.getLinemountainnum() != null) {
			SET("lineMountainNum = #{record.linemountainnum,jdbcType=TINYINT}");
		}
		if (record.getPowernum() != null) {
			SET("powerNum = #{record.powernum,jdbcType=TINYINT}");
		}
		if (record.getJob() != null) {
			SET("job = #{record.job,jdbcType=TINYINT}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_standard
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("enterprise_per_standard");
		SET("id = #{record.id,jdbcType=INTEGER}");
		SET("postClassifyId = #{record.postclassifyid,jdbcType=INTEGER}");
		SET("holderRequire = #{record.holderrequire,jdbcType=VARCHAR}");
		SET("lineFlatNum = #{record.lineflatnum,jdbcType=TINYINT}");
		SET("lineMountainNum = #{record.linemountainnum,jdbcType=TINYINT}");
		SET("powerNum = #{record.powernum,jdbcType=TINYINT}");
		SET("job = #{record.job,jdbcType=TINYINT}");
		SET("remark = #{record.remark,jdbcType=VARCHAR}");
		SET("createTime = #{record.createtime,jdbcType=VARCHAR}");
		SET("updateTime = #{record.updatetime,jdbcType=VARCHAR}");
		EnterprisePerStandardExample example = (EnterprisePerStandardExample) parameter
				.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_standard
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	public String updateByPrimaryKeySelective(EnterprisePerStandard record) {
		BEGIN();
		UPDATE("enterprise_per_standard");
		if (record.getPostclassifyid() != null) {
			SET("postClassifyId = #{postclassifyid,jdbcType=INTEGER}");
		}
		if (record.getHolderrequire() != null) {
			SET("holderRequire = #{holderrequire,jdbcType=VARCHAR}");
		}
		if (record.getLineflatnum() != null) {
			SET("lineFlatNum = #{lineflatnum,jdbcType=TINYINT}");
		}
		if (record.getLinemountainnum() != null) {
			SET("lineMountainNum = #{linemountainnum,jdbcType=TINYINT}");
		}
		if (record.getPowernum() != null) {
			SET("powerNum = #{powernum,jdbcType=TINYINT}");
		}
		if (record.getJob() != null) {
			SET("job = #{job,jdbcType=TINYINT}");
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
		WHERE("id = #{id,jdbcType=INTEGER}");
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_standard
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	protected void applyWhere(EnterprisePerStandardExample example,
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