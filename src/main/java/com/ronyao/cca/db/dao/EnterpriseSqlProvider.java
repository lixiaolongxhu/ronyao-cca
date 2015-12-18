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

import com.ronyao.cca.db.model.Enterprise;
import com.ronyao.cca.db.model.EnterpriseExample.Criteria;
import com.ronyao.cca.db.model.EnterpriseExample.Criterion;
import com.ronyao.cca.db.model.EnterpriseExample;
import java.util.List;
import java.util.Map;

public class EnterpriseSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	public String countByExample(EnterpriseExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("enterprise");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	public String deleteByExample(EnterpriseExample example) {
		BEGIN();
		DELETE_FROM("enterprise");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	public String insertSelective(Enterprise record) {
		BEGIN();
		INSERT_INTO("enterprise");
		if (record.getSupervisorunit() != null) {
			VALUES("supervisorUnit", "#{supervisorunit,jdbcType=VARCHAR}");
		}
		if (record.getName() != null) {
			VALUES("name", "#{name,jdbcType=VARCHAR}");
		}
		if (record.getFullname() != null) {
			VALUES("fullName", "#{fullname,jdbcType=VARCHAR}");
		}
		if (record.getProperty() != null) {
			VALUES("property", "#{property,jdbcType=TINYINT}");
		}
		if (record.getRegister() != null) {
			VALUES("register", "#{register,jdbcType=INTEGER}");
		}
		if (record.getAssets() != null) {
			VALUES("assets", "#{assets,jdbcType=INTEGER}");
		}
		if (record.getWorkers() != null) {
			VALUES("workers", "#{workers,jdbcType=INTEGER}");
		}
		if (record.getOverallrank() != null) {
			VALUES("overallRank", "#{overallrank,jdbcType=TINYINT}");
		}
		if (record.getProfessionrank() != null) {
			VALUES("professionRank", "#{professionrank,jdbcType=TINYINT}");
		}
		if (record.getOutput() != null) {
			VALUES("output", "#{output,jdbcType=INTEGER}");
		}
		if (record.getProject() != null) {
			VALUES("project", "#{project,jdbcType=INTEGER}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	public String selectByExample(EnterpriseExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("supervisorUnit");
		SELECT("name");
		SELECT("fullName");
		SELECT("property");
		SELECT("register");
		SELECT("assets");
		SELECT("workers");
		SELECT("overallRank");
		SELECT("professionRank");
		SELECT("output");
		SELECT("project");
		SELECT("createTime");
		SELECT("updateTime");
		FROM("enterprise");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		Enterprise record = (Enterprise) parameter.get("record");
		EnterpriseExample example = (EnterpriseExample) parameter
				.get("example");
		BEGIN();
		UPDATE("enterprise");
		if (record.getId() != null) {
			SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getSupervisorunit() != null) {
			SET("supervisorUnit = #{record.supervisorunit,jdbcType=VARCHAR}");
		}
		if (record.getName() != null) {
			SET("name = #{record.name,jdbcType=VARCHAR}");
		}
		if (record.getFullname() != null) {
			SET("fullName = #{record.fullname,jdbcType=VARCHAR}");
		}
		if (record.getProperty() != null) {
			SET("property = #{record.property,jdbcType=TINYINT}");
		}
		if (record.getRegister() != null) {
			SET("register = #{record.register,jdbcType=INTEGER}");
		}
		if (record.getAssets() != null) {
			SET("assets = #{record.assets,jdbcType=INTEGER}");
		}
		if (record.getWorkers() != null) {
			SET("workers = #{record.workers,jdbcType=INTEGER}");
		}
		if (record.getOverallrank() != null) {
			SET("overallRank = #{record.overallrank,jdbcType=TINYINT}");
		}
		if (record.getProfessionrank() != null) {
			SET("professionRank = #{record.professionrank,jdbcType=TINYINT}");
		}
		if (record.getOutput() != null) {
			SET("output = #{record.output,jdbcType=INTEGER}");
		}
		if (record.getProject() != null) {
			SET("project = #{record.project,jdbcType=INTEGER}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("enterprise");
		SET("id = #{record.id,jdbcType=INTEGER}");
		SET("supervisorUnit = #{record.supervisorunit,jdbcType=VARCHAR}");
		SET("name = #{record.name,jdbcType=VARCHAR}");
		SET("fullName = #{record.fullname,jdbcType=VARCHAR}");
		SET("property = #{record.property,jdbcType=TINYINT}");
		SET("register = #{record.register,jdbcType=INTEGER}");
		SET("assets = #{record.assets,jdbcType=INTEGER}");
		SET("workers = #{record.workers,jdbcType=INTEGER}");
		SET("overallRank = #{record.overallrank,jdbcType=TINYINT}");
		SET("professionRank = #{record.professionrank,jdbcType=TINYINT}");
		SET("output = #{record.output,jdbcType=INTEGER}");
		SET("project = #{record.project,jdbcType=INTEGER}");
		SET("createTime = #{record.createtime,jdbcType=VARCHAR}");
		SET("updateTime = #{record.updatetime,jdbcType=VARCHAR}");
		EnterpriseExample example = (EnterpriseExample) parameter
				.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	public String updateByPrimaryKeySelective(Enterprise record) {
		BEGIN();
		UPDATE("enterprise");
		if (record.getSupervisorunit() != null) {
			SET("supervisorUnit = #{supervisorunit,jdbcType=VARCHAR}");
		}
		if (record.getName() != null) {
			SET("name = #{name,jdbcType=VARCHAR}");
		}
		if (record.getFullname() != null) {
			SET("fullName = #{fullname,jdbcType=VARCHAR}");
		}
		if (record.getProperty() != null) {
			SET("property = #{property,jdbcType=TINYINT}");
		}
		if (record.getRegister() != null) {
			SET("register = #{register,jdbcType=INTEGER}");
		}
		if (record.getAssets() != null) {
			SET("assets = #{assets,jdbcType=INTEGER}");
		}
		if (record.getWorkers() != null) {
			SET("workers = #{workers,jdbcType=INTEGER}");
		}
		if (record.getOverallrank() != null) {
			SET("overallRank = #{overallrank,jdbcType=TINYINT}");
		}
		if (record.getProfessionrank() != null) {
			SET("professionRank = #{professionrank,jdbcType=TINYINT}");
		}
		if (record.getOutput() != null) {
			SET("output = #{output,jdbcType=INTEGER}");
		}
		if (record.getProject() != null) {
			SET("project = #{project,jdbcType=INTEGER}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	protected void applyWhere(EnterpriseExample example,
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