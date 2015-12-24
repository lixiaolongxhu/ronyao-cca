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

import com.ronyao.cca.db.model.ProjectBuild;
import com.ronyao.cca.db.model.ProjectBuildExample.Criteria;
import com.ronyao.cca.db.model.ProjectBuildExample.Criterion;
import com.ronyao.cca.db.model.ProjectBuildExample;
import java.util.List;
import java.util.Map;

public class ProjectBuildSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public String countByExample(ProjectBuildExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("project_build");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public String deleteByExample(ProjectBuildExample example) {
		BEGIN();
		DELETE_FROM("project_build");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public String insertSelective(ProjectBuild record) {
		BEGIN();
		INSERT_INTO("project_build");
		if (record.getSupervisorunit() != null) {
			VALUES("supervisorUnit", "#{supervisorunit,jdbcType=VARCHAR}");
		}
		if (record.getEnterpriseid() != null) {
			VALUES("enterpriseId", "#{enterpriseid,jdbcType=INTEGER}");
		}
		if (record.getYear() != null) {
			VALUES("year", "#{year,jdbcType=INTEGER}");
		}
		if (record.getClassify() != null) {
			VALUES("classify", "#{classify,jdbcType=INTEGER}");
		}
		if (record.getLine110kv() != null) {
			VALUES("line110kv", "#{line110kv,jdbcType=INTEGER}");
		}
		if (record.getLine220kv() != null) {
			VALUES("line220kv", "#{line220kv,jdbcType=INTEGER}");
		}
		if (record.getLine500kv() != null) {
			VALUES("line500kv", "#{line500kv,jdbcType=INTEGER}");
		}
		if (record.getPower110kv() != null) {
			VALUES("power110kv", "#{power110kv,jdbcType=INTEGER}");
		}
		if (record.getPower220kv() != null) {
			VALUES("power220kv", "#{power220kv,jdbcType=INTEGER}");
		}
		if (record.getPower500kv() != null) {
			VALUES("power500kv", "#{power500kv,jdbcType=INTEGER}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public String selectByExample(ProjectBuildExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("supervisorUnit");
		SELECT("enterpriseId");
		SELECT("year");
		SELECT("classify");
		SELECT("line110kv");
		SELECT("line220kv");
		SELECT("line500kv");
		SELECT("power110kv");
		SELECT("power220kv");
		SELECT("power500kv");
		SELECT("createTime");
		SELECT("updateTime");
		FROM("project_build");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		ProjectBuild record = (ProjectBuild) parameter.get("record");
		ProjectBuildExample example = (ProjectBuildExample) parameter
				.get("example");
		BEGIN();
		UPDATE("project_build");
		if (record.getId() != null) {
			SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getSupervisorunit() != null) {
			SET("supervisorUnit = #{record.supervisorunit,jdbcType=VARCHAR}");
		}
		if (record.getEnterpriseid() != null) {
			SET("enterpriseId = #{record.enterpriseid,jdbcType=INTEGER}");
		}
		if (record.getYear() != null) {
			SET("year = #{record.year,jdbcType=INTEGER}");
		}
		if (record.getClassify() != null) {
			SET("classify = #{record.classify,jdbcType=INTEGER}");
		}
		if (record.getLine110kv() != null) {
			SET("line110kv = #{record.line110kv,jdbcType=INTEGER}");
		}
		if (record.getLine220kv() != null) {
			SET("line220kv = #{record.line220kv,jdbcType=INTEGER}");
		}
		if (record.getLine500kv() != null) {
			SET("line500kv = #{record.line500kv,jdbcType=INTEGER}");
		}
		if (record.getPower110kv() != null) {
			SET("power110kv = #{record.power110kv,jdbcType=INTEGER}");
		}
		if (record.getPower220kv() != null) {
			SET("power220kv = #{record.power220kv,jdbcType=INTEGER}");
		}
		if (record.getPower500kv() != null) {
			SET("power500kv = #{record.power500kv,jdbcType=INTEGER}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("project_build");
		SET("id = #{record.id,jdbcType=INTEGER}");
		SET("supervisorUnit = #{record.supervisorunit,jdbcType=VARCHAR}");
		SET("enterpriseId = #{record.enterpriseid,jdbcType=INTEGER}");
		SET("year = #{record.year,jdbcType=INTEGER}");
		SET("classify = #{record.classify,jdbcType=INTEGER}");
		SET("line110kv = #{record.line110kv,jdbcType=INTEGER}");
		SET("line220kv = #{record.line220kv,jdbcType=INTEGER}");
		SET("line500kv = #{record.line500kv,jdbcType=INTEGER}");
		SET("power110kv = #{record.power110kv,jdbcType=INTEGER}");
		SET("power220kv = #{record.power220kv,jdbcType=INTEGER}");
		SET("power500kv = #{record.power500kv,jdbcType=INTEGER}");
		SET("createTime = #{record.createtime,jdbcType=VARCHAR}");
		SET("updateTime = #{record.updatetime,jdbcType=VARCHAR}");
		ProjectBuildExample example = (ProjectBuildExample) parameter
				.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public String updateByPrimaryKeySelective(ProjectBuild record) {
		BEGIN();
		UPDATE("project_build");
		if (record.getSupervisorunit() != null) {
			SET("supervisorUnit = #{supervisorunit,jdbcType=VARCHAR}");
		}
		if (record.getEnterpriseid() != null) {
			SET("enterpriseId = #{enterpriseid,jdbcType=INTEGER}");
		}
		if (record.getYear() != null) {
			SET("year = #{year,jdbcType=INTEGER}");
		}
		if (record.getClassify() != null) {
			SET("classify = #{classify,jdbcType=INTEGER}");
		}
		if (record.getLine110kv() != null) {
			SET("line110kv = #{line110kv,jdbcType=INTEGER}");
		}
		if (record.getLine220kv() != null) {
			SET("line220kv = #{line220kv,jdbcType=INTEGER}");
		}
		if (record.getLine500kv() != null) {
			SET("line500kv = #{line500kv,jdbcType=INTEGER}");
		}
		if (record.getPower110kv() != null) {
			SET("power110kv = #{power110kv,jdbcType=INTEGER}");
		}
		if (record.getPower220kv() != null) {
			SET("power220kv = #{power220kv,jdbcType=INTEGER}");
		}
		if (record.getPower500kv() != null) {
			SET("power500kv = #{power500kv,jdbcType=INTEGER}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	protected void applyWhere(ProjectBuildExample example,
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