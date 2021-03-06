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

import com.ronyao.cca.db.model.EnterprisePerson;
import com.ronyao.cca.db.model.EnterprisePersonExample.Criteria;
import com.ronyao.cca.db.model.EnterprisePersonExample.Criterion;
import com.ronyao.cca.db.model.EnterprisePersonExample;
import java.util.List;
import java.util.Map;

public class EnterprisePersonSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String countByExample(EnterprisePersonExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("enterprise_person");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String deleteByExample(EnterprisePersonExample example) {
		BEGIN();
		DELETE_FROM("enterprise_person");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String insertSelective(EnterprisePerson record) {
		BEGIN();
		INSERT_INTO("enterprise_person");
		if (record.getEnterpriseid() != null) {
			VALUES("enterpriseId", "#{enterpriseid,jdbcType=INTEGER}");
		}
		if (record.getConstructorone() != null) {
			VALUES("constructorOne", "#{constructorone,jdbcType=INTEGER}");
		}
		if (record.getConstructortwo() != null) {
			VALUES("constructorTwo", "#{constructortwo,jdbcType=INTEGER}");
		}
		if (record.getConstructortotal() != null) {
			VALUES("constructorTotal", "#{constructortotal,jdbcType=INTEGER}");
		}
		if (record.getStaffmiddle() != null) {
			VALUES("staffMiddle", "#{staffmiddle,jdbcType=INTEGER}");
		}
		if (record.getStaffhigh() != null) {
			VALUES("staffHigh", "#{staffhigh,jdbcType=INTEGER}");
		}
		if (record.getStafftotal() != null) {
			VALUES("staffTotal", "#{stafftotal,jdbcType=INTEGER}");
		}
		if (record.getSkillmiddle() != null) {
			VALUES("skillMiddle", "#{skillmiddle,jdbcType=INTEGER}");
		}
		if (record.getSkillhigh() != null) {
			VALUES("skillHigh", "#{skillhigh,jdbcType=INTEGER}");
		}
		if (record.getSkilltech() != null) {
			VALUES("skillTech", "#{skilltech,jdbcType=INTEGER}");
		}
		if (record.getSkilltechhigh() != null) {
			VALUES("skillTechHigh", "#{skilltechhigh,jdbcType=INTEGER}");
		}
		if (record.getSkilltotal() != null) {
			VALUES("skillTotal", "#{skilltotal,jdbcType=INTEGER}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String selectByExample(EnterprisePersonExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("enterpriseId");
		SELECT("constructorOne");
		SELECT("constructorTwo");
		SELECT("constructorTotal");
		SELECT("staffMiddle");
		SELECT("staffHigh");
		SELECT("staffTotal");
		SELECT("skillMiddle");
		SELECT("skillHigh");
		SELECT("skillTech");
		SELECT("skillTechHigh");
		SELECT("skillTotal");
		SELECT("createTime");
		SELECT("updateTime");
		FROM("enterprise_person");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		EnterprisePerson record = (EnterprisePerson) parameter.get("record");
		EnterprisePersonExample example = (EnterprisePersonExample) parameter
				.get("example");
		BEGIN();
		UPDATE("enterprise_person");
		if (record.getId() != null) {
			SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getEnterpriseid() != null) {
			SET("enterpriseId = #{record.enterpriseid,jdbcType=INTEGER}");
		}
		if (record.getConstructorone() != null) {
			SET("constructorOne = #{record.constructorone,jdbcType=INTEGER}");
		}
		if (record.getConstructortwo() != null) {
			SET("constructorTwo = #{record.constructortwo,jdbcType=INTEGER}");
		}
		if (record.getConstructortotal() != null) {
			SET("constructorTotal = #{record.constructortotal,jdbcType=INTEGER}");
		}
		if (record.getStaffmiddle() != null) {
			SET("staffMiddle = #{record.staffmiddle,jdbcType=INTEGER}");
		}
		if (record.getStaffhigh() != null) {
			SET("staffHigh = #{record.staffhigh,jdbcType=INTEGER}");
		}
		if (record.getStafftotal() != null) {
			SET("staffTotal = #{record.stafftotal,jdbcType=INTEGER}");
		}
		if (record.getSkillmiddle() != null) {
			SET("skillMiddle = #{record.skillmiddle,jdbcType=INTEGER}");
		}
		if (record.getSkillhigh() != null) {
			SET("skillHigh = #{record.skillhigh,jdbcType=INTEGER}");
		}
		if (record.getSkilltech() != null) {
			SET("skillTech = #{record.skilltech,jdbcType=INTEGER}");
		}
		if (record.getSkilltechhigh() != null) {
			SET("skillTechHigh = #{record.skilltechhigh,jdbcType=INTEGER}");
		}
		if (record.getSkilltotal() != null) {
			SET("skillTotal = #{record.skilltotal,jdbcType=INTEGER}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("enterprise_person");
		SET("id = #{record.id,jdbcType=INTEGER}");
		SET("enterpriseId = #{record.enterpriseid,jdbcType=INTEGER}");
		SET("constructorOne = #{record.constructorone,jdbcType=INTEGER}");
		SET("constructorTwo = #{record.constructortwo,jdbcType=INTEGER}");
		SET("constructorTotal = #{record.constructortotal,jdbcType=INTEGER}");
		SET("staffMiddle = #{record.staffmiddle,jdbcType=INTEGER}");
		SET("staffHigh = #{record.staffhigh,jdbcType=INTEGER}");
		SET("staffTotal = #{record.stafftotal,jdbcType=INTEGER}");
		SET("skillMiddle = #{record.skillmiddle,jdbcType=INTEGER}");
		SET("skillHigh = #{record.skillhigh,jdbcType=INTEGER}");
		SET("skillTech = #{record.skilltech,jdbcType=INTEGER}");
		SET("skillTechHigh = #{record.skilltechhigh,jdbcType=INTEGER}");
		SET("skillTotal = #{record.skilltotal,jdbcType=INTEGER}");
		SET("createTime = #{record.createtime,jdbcType=VARCHAR}");
		SET("updateTime = #{record.updatetime,jdbcType=VARCHAR}");
		EnterprisePersonExample example = (EnterprisePersonExample) parameter
				.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String updateByPrimaryKeySelective(EnterprisePerson record) {
		BEGIN();
		UPDATE("enterprise_person");
		if (record.getEnterpriseid() != null) {
			SET("enterpriseId = #{enterpriseid,jdbcType=INTEGER}");
		}
		if (record.getConstructorone() != null) {
			SET("constructorOne = #{constructorone,jdbcType=INTEGER}");
		}
		if (record.getConstructortwo() != null) {
			SET("constructorTwo = #{constructortwo,jdbcType=INTEGER}");
		}
		if (record.getConstructortotal() != null) {
			SET("constructorTotal = #{constructortotal,jdbcType=INTEGER}");
		}
		if (record.getStaffmiddle() != null) {
			SET("staffMiddle = #{staffmiddle,jdbcType=INTEGER}");
		}
		if (record.getStaffhigh() != null) {
			SET("staffHigh = #{staffhigh,jdbcType=INTEGER}");
		}
		if (record.getStafftotal() != null) {
			SET("staffTotal = #{stafftotal,jdbcType=INTEGER}");
		}
		if (record.getSkillmiddle() != null) {
			SET("skillMiddle = #{skillmiddle,jdbcType=INTEGER}");
		}
		if (record.getSkillhigh() != null) {
			SET("skillHigh = #{skillhigh,jdbcType=INTEGER}");
		}
		if (record.getSkilltech() != null) {
			SET("skillTech = #{skilltech,jdbcType=INTEGER}");
		}
		if (record.getSkilltechhigh() != null) {
			SET("skillTechHigh = #{skilltechhigh,jdbcType=INTEGER}");
		}
		if (record.getSkilltotal() != null) {
			SET("skillTotal = #{skilltotal,jdbcType=INTEGER}");
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	protected void applyWhere(EnterprisePersonExample example,
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