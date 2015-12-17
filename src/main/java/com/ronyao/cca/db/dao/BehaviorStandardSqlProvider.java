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

import com.ronyao.cca.db.model.BehaviorStandardExample.Criteria;
import com.ronyao.cca.db.model.BehaviorStandardExample.Criterion;
import com.ronyao.cca.db.model.BehaviorStandardExample;
import com.ronyao.cca.db.model.BehaviorStandardWithBLOBs;
import java.util.List;
import java.util.Map;

public class BehaviorStandardSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String countByExample(BehaviorStandardExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("behavior_standard");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String deleteByExample(BehaviorStandardExample example) {
		BEGIN();
		DELETE_FROM("behavior_standard");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String insertSelective(BehaviorStandardWithBLOBs record) {
		BEGIN();
		INSERT_INTO("behavior_standard");
		if (record.getRanktype() != null) {
			VALUES("rankType", "#{ranktype,jdbcType=TINYINT}");
		}
		if (record.getCreatetime() != null) {
			VALUES("createTime", "#{createtime,jdbcType=VARCHAR}");
		}
		if (record.getUpdatetime() != null) {
			VALUES("updateTime", "#{updatetime,jdbcType=VARCHAR}");
		}
		if (record.getSincerity() != null) {
			VALUES("sincerity", "#{sincerity,jdbcType=LONGVARCHAR}");
		}
		if (record.getSave() != null) {
			VALUES("save", "#{save,jdbcType=LONGVARCHAR}");
		}
		if (record.getProgress() != null) {
			VALUES("progress", "#{progress,jdbcType=LONGVARCHAR}");
		}
		if (record.getService() != null) {
			VALUES("service", "#{service,jdbcType=LONGVARCHAR}");
		}
		if (record.getOther() != null) {
			VALUES("other", "#{other,jdbcType=LONGVARCHAR}");
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String selectByExampleWithBLOBs(BehaviorStandardExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("rankType");
		SELECT("createTime");
		SELECT("updateTime");
		SELECT("sincerity");
		SELECT("save");
		SELECT("progress");
		SELECT("service");
		SELECT("other");
		FROM("behavior_standard");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String selectByExample(BehaviorStandardExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("rankType");
		SELECT("createTime");
		SELECT("updateTime");
		FROM("behavior_standard");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		BehaviorStandardWithBLOBs record = (BehaviorStandardWithBLOBs) parameter
				.get("record");
		BehaviorStandardExample example = (BehaviorStandardExample) parameter
				.get("example");
		BEGIN();
		UPDATE("behavior_standard");
		if (record.getId() != null) {
			SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getRanktype() != null) {
			SET("rankType = #{record.ranktype,jdbcType=TINYINT}");
		}
		if (record.getCreatetime() != null) {
			SET("createTime = #{record.createtime,jdbcType=VARCHAR}");
		}
		if (record.getUpdatetime() != null) {
			SET("updateTime = #{record.updatetime,jdbcType=VARCHAR}");
		}
		if (record.getSincerity() != null) {
			SET("sincerity = #{record.sincerity,jdbcType=LONGVARCHAR}");
		}
		if (record.getSave() != null) {
			SET("save = #{record.save,jdbcType=LONGVARCHAR}");
		}
		if (record.getProgress() != null) {
			SET("progress = #{record.progress,jdbcType=LONGVARCHAR}");
		}
		if (record.getService() != null) {
			SET("service = #{record.service,jdbcType=LONGVARCHAR}");
		}
		if (record.getOther() != null) {
			SET("other = #{record.other,jdbcType=LONGVARCHAR}");
		}
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("behavior_standard");
		SET("id = #{record.id,jdbcType=INTEGER}");
		SET("rankType = #{record.ranktype,jdbcType=TINYINT}");
		SET("createTime = #{record.createtime,jdbcType=VARCHAR}");
		SET("updateTime = #{record.updatetime,jdbcType=VARCHAR}");
		SET("sincerity = #{record.sincerity,jdbcType=LONGVARCHAR}");
		SET("save = #{record.save,jdbcType=LONGVARCHAR}");
		SET("progress = #{record.progress,jdbcType=LONGVARCHAR}");
		SET("service = #{record.service,jdbcType=LONGVARCHAR}");
		SET("other = #{record.other,jdbcType=LONGVARCHAR}");
		BehaviorStandardExample example = (BehaviorStandardExample) parameter
				.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("behavior_standard");
		SET("id = #{record.id,jdbcType=INTEGER}");
		SET("rankType = #{record.ranktype,jdbcType=TINYINT}");
		SET("createTime = #{record.createtime,jdbcType=VARCHAR}");
		SET("updateTime = #{record.updatetime,jdbcType=VARCHAR}");
		BehaviorStandardExample example = (BehaviorStandardExample) parameter
				.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String updateByPrimaryKeySelective(BehaviorStandardWithBLOBs record) {
		BEGIN();
		UPDATE("behavior_standard");
		if (record.getRanktype() != null) {
			SET("rankType = #{ranktype,jdbcType=TINYINT}");
		}
		if (record.getCreatetime() != null) {
			SET("createTime = #{createtime,jdbcType=VARCHAR}");
		}
		if (record.getUpdatetime() != null) {
			SET("updateTime = #{updatetime,jdbcType=VARCHAR}");
		}
		if (record.getSincerity() != null) {
			SET("sincerity = #{sincerity,jdbcType=LONGVARCHAR}");
		}
		if (record.getSave() != null) {
			SET("save = #{save,jdbcType=LONGVARCHAR}");
		}
		if (record.getProgress() != null) {
			SET("progress = #{progress,jdbcType=LONGVARCHAR}");
		}
		if (record.getService() != null) {
			SET("service = #{service,jdbcType=LONGVARCHAR}");
		}
		if (record.getOther() != null) {
			SET("other = #{other,jdbcType=LONGVARCHAR}");
		}
		WHERE("id = #{id,jdbcType=INTEGER}");
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	protected void applyWhere(BehaviorStandardExample example,
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