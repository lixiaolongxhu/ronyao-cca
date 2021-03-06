package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.EnterprisePerManage;
import com.ronyao.cca.db.model.EnterprisePerManageExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface EnterprisePerManageMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@SelectProvider(type = EnterprisePerManageSqlProvider.class, method = "countByExample")
	int countByExample(EnterprisePerManageExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@DeleteProvider(type = EnterprisePerManageSqlProvider.class, method = "deleteByExample")
	int deleteByExample(EnterprisePerManageExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@Delete({ "delete from enterprise_per_manage",
			"where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@Insert({
			"insert into enterprise_per_manage (enterpriseId, professionType, ",
			"oneManager, twoManager, ",
			"oneChief, twoChief, ",
			"safetyOfficer, inspector, ",
			"technician, costMember, ",
			"documenter, integrator, ",
			"material, expeditor, ",
			"constructionTeam, plurality, ",
			"sum, createTime, ",
			"updateTime)",
			"values (#{enterpriseid,jdbcType=INTEGER}, #{professiontype,jdbcType=INTEGER}, ",
			"#{onemanager,jdbcType=INTEGER}, #{twomanager,jdbcType=INTEGER}, ",
			"#{onechief,jdbcType=INTEGER}, #{twochief,jdbcType=INTEGER}, ",
			"#{safetyofficer,jdbcType=INTEGER}, #{inspector,jdbcType=INTEGER}, ",
			"#{technician,jdbcType=INTEGER}, #{costmember,jdbcType=INTEGER}, ",
			"#{documenter,jdbcType=INTEGER}, #{integrator,jdbcType=INTEGER}, ",
			"#{material,jdbcType=INTEGER}, #{expeditor,jdbcType=INTEGER}, ",
			"#{constructionteam,jdbcType=INTEGER}, #{plurality,jdbcType=INTEGER}, ",
			"#{sum,jdbcType=INTEGER}, #{createtime,jdbcType=VARCHAR}, ",
			"#{updatetime,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(EnterprisePerManage record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@InsertProvider(type = EnterprisePerManageSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(EnterprisePerManage record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@SelectProvider(type = EnterprisePerManageSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "professionType", property = "professiontype", jdbcType = JdbcType.INTEGER),
			@Result(column = "oneManager", property = "onemanager", jdbcType = JdbcType.INTEGER),
			@Result(column = "twoManager", property = "twomanager", jdbcType = JdbcType.INTEGER),
			@Result(column = "oneChief", property = "onechief", jdbcType = JdbcType.INTEGER),
			@Result(column = "twoChief", property = "twochief", jdbcType = JdbcType.INTEGER),
			@Result(column = "safetyOfficer", property = "safetyofficer", jdbcType = JdbcType.INTEGER),
			@Result(column = "inspector", property = "inspector", jdbcType = JdbcType.INTEGER),
			@Result(column = "technician", property = "technician", jdbcType = JdbcType.INTEGER),
			@Result(column = "costMember", property = "costmember", jdbcType = JdbcType.INTEGER),
			@Result(column = "documenter", property = "documenter", jdbcType = JdbcType.INTEGER),
			@Result(column = "integrator", property = "integrator", jdbcType = JdbcType.INTEGER),
			@Result(column = "material", property = "material", jdbcType = JdbcType.INTEGER),
			@Result(column = "expeditor", property = "expeditor", jdbcType = JdbcType.INTEGER),
			@Result(column = "constructionTeam", property = "constructionteam", jdbcType = JdbcType.INTEGER),
			@Result(column = "plurality", property = "plurality", jdbcType = JdbcType.INTEGER),
			@Result(column = "sum", property = "sum", jdbcType = JdbcType.INTEGER),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<EnterprisePerManage> selectByExampleWithRowbounds(
			EnterprisePerManageExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@SelectProvider(type = EnterprisePerManageSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "professionType", property = "professiontype", jdbcType = JdbcType.INTEGER),
			@Result(column = "oneManager", property = "onemanager", jdbcType = JdbcType.INTEGER),
			@Result(column = "twoManager", property = "twomanager", jdbcType = JdbcType.INTEGER),
			@Result(column = "oneChief", property = "onechief", jdbcType = JdbcType.INTEGER),
			@Result(column = "twoChief", property = "twochief", jdbcType = JdbcType.INTEGER),
			@Result(column = "safetyOfficer", property = "safetyofficer", jdbcType = JdbcType.INTEGER),
			@Result(column = "inspector", property = "inspector", jdbcType = JdbcType.INTEGER),
			@Result(column = "technician", property = "technician", jdbcType = JdbcType.INTEGER),
			@Result(column = "costMember", property = "costmember", jdbcType = JdbcType.INTEGER),
			@Result(column = "documenter", property = "documenter", jdbcType = JdbcType.INTEGER),
			@Result(column = "integrator", property = "integrator", jdbcType = JdbcType.INTEGER),
			@Result(column = "material", property = "material", jdbcType = JdbcType.INTEGER),
			@Result(column = "expeditor", property = "expeditor", jdbcType = JdbcType.INTEGER),
			@Result(column = "constructionTeam", property = "constructionteam", jdbcType = JdbcType.INTEGER),
			@Result(column = "plurality", property = "plurality", jdbcType = JdbcType.INTEGER),
			@Result(column = "sum", property = "sum", jdbcType = JdbcType.INTEGER),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<EnterprisePerManage> selectByExample(EnterprisePerManageExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@Select({
			"select",
			"id, enterpriseId, professionType, oneManager, twoManager, oneChief, twoChief, ",
			"safetyOfficer, inspector, technician, costMember, documenter, integrator, material, ",
			"expeditor, constructionTeam, plurality, sum, createTime, updateTime",
			"from enterprise_per_manage", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "professionType", property = "professiontype", jdbcType = JdbcType.INTEGER),
			@Result(column = "oneManager", property = "onemanager", jdbcType = JdbcType.INTEGER),
			@Result(column = "twoManager", property = "twomanager", jdbcType = JdbcType.INTEGER),
			@Result(column = "oneChief", property = "onechief", jdbcType = JdbcType.INTEGER),
			@Result(column = "twoChief", property = "twochief", jdbcType = JdbcType.INTEGER),
			@Result(column = "safetyOfficer", property = "safetyofficer", jdbcType = JdbcType.INTEGER),
			@Result(column = "inspector", property = "inspector", jdbcType = JdbcType.INTEGER),
			@Result(column = "technician", property = "technician", jdbcType = JdbcType.INTEGER),
			@Result(column = "costMember", property = "costmember", jdbcType = JdbcType.INTEGER),
			@Result(column = "documenter", property = "documenter", jdbcType = JdbcType.INTEGER),
			@Result(column = "integrator", property = "integrator", jdbcType = JdbcType.INTEGER),
			@Result(column = "material", property = "material", jdbcType = JdbcType.INTEGER),
			@Result(column = "expeditor", property = "expeditor", jdbcType = JdbcType.INTEGER),
			@Result(column = "constructionTeam", property = "constructionteam", jdbcType = JdbcType.INTEGER),
			@Result(column = "plurality", property = "plurality", jdbcType = JdbcType.INTEGER),
			@Result(column = "sum", property = "sum", jdbcType = JdbcType.INTEGER),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	EnterprisePerManage selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@UpdateProvider(type = EnterprisePerManageSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") EnterprisePerManage record,
			@Param("example") EnterprisePerManageExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@UpdateProvider(type = EnterprisePerManageSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") EnterprisePerManage record,
			@Param("example") EnterprisePerManageExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@UpdateProvider(type = EnterprisePerManageSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(EnterprisePerManage record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_manage
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@Update({ "update enterprise_per_manage",
			"set enterpriseId = #{enterpriseid,jdbcType=INTEGER},",
			"professionType = #{professiontype,jdbcType=INTEGER},",
			"oneManager = #{onemanager,jdbcType=INTEGER},",
			"twoManager = #{twomanager,jdbcType=INTEGER},",
			"oneChief = #{onechief,jdbcType=INTEGER},",
			"twoChief = #{twochief,jdbcType=INTEGER},",
			"safetyOfficer = #{safetyofficer,jdbcType=INTEGER},",
			"inspector = #{inspector,jdbcType=INTEGER},",
			"technician = #{technician,jdbcType=INTEGER},",
			"costMember = #{costmember,jdbcType=INTEGER},",
			"documenter = #{documenter,jdbcType=INTEGER},",
			"integrator = #{integrator,jdbcType=INTEGER},",
			"material = #{material,jdbcType=INTEGER},",
			"expeditor = #{expeditor,jdbcType=INTEGER},",
			"constructionTeam = #{constructionteam,jdbcType=INTEGER},",
			"plurality = #{plurality,jdbcType=INTEGER},",
			"sum = #{sum,jdbcType=INTEGER},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(EnterprisePerManage record);
}