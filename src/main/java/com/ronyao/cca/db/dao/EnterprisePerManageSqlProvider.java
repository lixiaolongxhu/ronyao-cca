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

import com.ronyao.cca.db.model.EnterprisePerManage;
import com.ronyao.cca.db.model.EnterprisePerManageExample.Criteria;
import com.ronyao.cca.db.model.EnterprisePerManageExample.Criterion;
import com.ronyao.cca.db.model.EnterprisePerManageExample;
import java.util.List;
import java.util.Map;

public class EnterprisePerManageSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String countByExample(EnterprisePerManageExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("enterprise_per_manage");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String deleteByExample(EnterprisePerManageExample example) {
		BEGIN();
		DELETE_FROM("enterprise_per_manage");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String insertSelective(EnterprisePerManage record) {
		BEGIN();
		INSERT_INTO("enterprise_per_manage");
		if (record.getEnterpriseid() != null) {
			VALUES("enterpriseId", "#{enterpriseid,jdbcType=INTEGER}");
		}
		if (record.getProfessiontype() != null) {
			VALUES("professionType", "#{professiontype,jdbcType=INTEGER}");
		}
		if (record.getOnemanager() != null) {
			VALUES("oneManager", "#{onemanager,jdbcType=INTEGER}");
		}
		if (record.getTwomanager() != null) {
			VALUES("twoManager", "#{twomanager,jdbcType=INTEGER}");
		}
		if (record.getOnechief() != null) {
			VALUES("oneChief", "#{onechief,jdbcType=INTEGER}");
		}
		if (record.getTwochief() != null) {
			VALUES("twoChief", "#{twochief,jdbcType=INTEGER}");
		}
		if (record.getSafetyofficer() != null) {
			VALUES("safetyOfficer", "#{safetyofficer,jdbcType=INTEGER}");
		}
		if (record.getInspector() != null) {
			VALUES("inspector", "#{inspector,jdbcType=INTEGER}");
		}
		if (record.getTechnician() != null) {
			VALUES("technician", "#{technician,jdbcType=INTEGER}");
		}
		if (record.getCostmember() != null) {
			VALUES("costMember", "#{costmember,jdbcType=INTEGER}");
		}
		if (record.getDocumenter() != null) {
			VALUES("documenter", "#{documenter,jdbcType=INTEGER}");
		}
		if (record.getIntegrator() != null) {
			VALUES("integrator", "#{integrator,jdbcType=INTEGER}");
		}
		if (record.getMaterial() != null) {
			VALUES("material", "#{material,jdbcType=INTEGER}");
		}
		if (record.getExpeditor() != null) {
			VALUES("expeditor", "#{expeditor,jdbcType=INTEGER}");
		}
		if (record.getConstructionteam() != null) {
			VALUES("constructionTeam", "#{constructionteam,jdbcType=INTEGER}");
		}
		if (record.getPlurality() != null) {
			VALUES("plurality", "#{plurality,jdbcType=INTEGER}");
		}
		if (record.getSum() != null) {
			VALUES("sum", "#{sum,jdbcType=INTEGER}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String selectByExample(EnterprisePerManageExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("enterpriseId");
		SELECT("professionType");
		SELECT("oneManager");
		SELECT("twoManager");
		SELECT("oneChief");
		SELECT("twoChief");
		SELECT("safetyOfficer");
		SELECT("inspector");
		SELECT("technician");
		SELECT("costMember");
		SELECT("documenter");
		SELECT("integrator");
		SELECT("material");
		SELECT("expeditor");
		SELECT("constructionTeam");
		SELECT("plurality");
		SELECT("sum");
		SELECT("createTime");
		SELECT("updateTime");
		FROM("enterprise_per_manage");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		EnterprisePerManage record = (EnterprisePerManage) parameter
				.get("record");
		EnterprisePerManageExample example = (EnterprisePerManageExample) parameter
				.get("example");
		BEGIN();
		UPDATE("enterprise_per_manage");
		if (record.getId() != null) {
			SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getEnterpriseid() != null) {
			SET("enterpriseId = #{record.enterpriseid,jdbcType=INTEGER}");
		}
		if (record.getProfessiontype() != null) {
			SET("professionType = #{record.professiontype,jdbcType=INTEGER}");
		}
		if (record.getOnemanager() != null) {
			SET("oneManager = #{record.onemanager,jdbcType=INTEGER}");
		}
		if (record.getTwomanager() != null) {
			SET("twoManager = #{record.twomanager,jdbcType=INTEGER}");
		}
		if (record.getOnechief() != null) {
			SET("oneChief = #{record.onechief,jdbcType=INTEGER}");
		}
		if (record.getTwochief() != null) {
			SET("twoChief = #{record.twochief,jdbcType=INTEGER}");
		}
		if (record.getSafetyofficer() != null) {
			SET("safetyOfficer = #{record.safetyofficer,jdbcType=INTEGER}");
		}
		if (record.getInspector() != null) {
			SET("inspector = #{record.inspector,jdbcType=INTEGER}");
		}
		if (record.getTechnician() != null) {
			SET("technician = #{record.technician,jdbcType=INTEGER}");
		}
		if (record.getCostmember() != null) {
			SET("costMember = #{record.costmember,jdbcType=INTEGER}");
		}
		if (record.getDocumenter() != null) {
			SET("documenter = #{record.documenter,jdbcType=INTEGER}");
		}
		if (record.getIntegrator() != null) {
			SET("integrator = #{record.integrator,jdbcType=INTEGER}");
		}
		if (record.getMaterial() != null) {
			SET("material = #{record.material,jdbcType=INTEGER}");
		}
		if (record.getExpeditor() != null) {
			SET("expeditor = #{record.expeditor,jdbcType=INTEGER}");
		}
		if (record.getConstructionteam() != null) {
			SET("constructionTeam = #{record.constructionteam,jdbcType=INTEGER}");
		}
		if (record.getPlurality() != null) {
			SET("plurality = #{record.plurality,jdbcType=INTEGER}");
		}
		if (record.getSum() != null) {
			SET("sum = #{record.sum,jdbcType=INTEGER}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("enterprise_per_manage");
		SET("id = #{record.id,jdbcType=INTEGER}");
		SET("enterpriseId = #{record.enterpriseid,jdbcType=INTEGER}");
		SET("professionType = #{record.professiontype,jdbcType=INTEGER}");
		SET("oneManager = #{record.onemanager,jdbcType=INTEGER}");
		SET("twoManager = #{record.twomanager,jdbcType=INTEGER}");
		SET("oneChief = #{record.onechief,jdbcType=INTEGER}");
		SET("twoChief = #{record.twochief,jdbcType=INTEGER}");
		SET("safetyOfficer = #{record.safetyofficer,jdbcType=INTEGER}");
		SET("inspector = #{record.inspector,jdbcType=INTEGER}");
		SET("technician = #{record.technician,jdbcType=INTEGER}");
		SET("costMember = #{record.costmember,jdbcType=INTEGER}");
		SET("documenter = #{record.documenter,jdbcType=INTEGER}");
		SET("integrator = #{record.integrator,jdbcType=INTEGER}");
		SET("material = #{record.material,jdbcType=INTEGER}");
		SET("expeditor = #{record.expeditor,jdbcType=INTEGER}");
		SET("constructionTeam = #{record.constructionteam,jdbcType=INTEGER}");
		SET("plurality = #{record.plurality,jdbcType=INTEGER}");
		SET("sum = #{record.sum,jdbcType=INTEGER}");
		SET("createTime = #{record.createtime,jdbcType=VARCHAR}");
		SET("updateTime = #{record.updatetime,jdbcType=VARCHAR}");
		EnterprisePerManageExample example = (EnterprisePerManageExample) parameter
				.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String updateByPrimaryKeySelective(EnterprisePerManage record) {
		BEGIN();
		UPDATE("enterprise_per_manage");
		if (record.getEnterpriseid() != null) {
			SET("enterpriseId = #{enterpriseid,jdbcType=INTEGER}");
		}
		if (record.getProfessiontype() != null) {
			SET("professionType = #{professiontype,jdbcType=INTEGER}");
		}
		if (record.getOnemanager() != null) {
			SET("oneManager = #{onemanager,jdbcType=INTEGER}");
		}
		if (record.getTwomanager() != null) {
			SET("twoManager = #{twomanager,jdbcType=INTEGER}");
		}
		if (record.getOnechief() != null) {
			SET("oneChief = #{onechief,jdbcType=INTEGER}");
		}
		if (record.getTwochief() != null) {
			SET("twoChief = #{twochief,jdbcType=INTEGER}");
		}
		if (record.getSafetyofficer() != null) {
			SET("safetyOfficer = #{safetyofficer,jdbcType=INTEGER}");
		}
		if (record.getInspector() != null) {
			SET("inspector = #{inspector,jdbcType=INTEGER}");
		}
		if (record.getTechnician() != null) {
			SET("technician = #{technician,jdbcType=INTEGER}");
		}
		if (record.getCostmember() != null) {
			SET("costMember = #{costmember,jdbcType=INTEGER}");
		}
		if (record.getDocumenter() != null) {
			SET("documenter = #{documenter,jdbcType=INTEGER}");
		}
		if (record.getIntegrator() != null) {
			SET("integrator = #{integrator,jdbcType=INTEGER}");
		}
		if (record.getMaterial() != null) {
			SET("material = #{material,jdbcType=INTEGER}");
		}
		if (record.getExpeditor() != null) {
			SET("expeditor = #{expeditor,jdbcType=INTEGER}");
		}
		if (record.getConstructionteam() != null) {
			SET("constructionTeam = #{constructionteam,jdbcType=INTEGER}");
		}
		if (record.getPlurality() != null) {
			SET("plurality = #{plurality,jdbcType=INTEGER}");
		}
		if (record.getSum() != null) {
			SET("sum = #{sum,jdbcType=INTEGER}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	protected void applyWhere(EnterprisePerManageExample example,
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