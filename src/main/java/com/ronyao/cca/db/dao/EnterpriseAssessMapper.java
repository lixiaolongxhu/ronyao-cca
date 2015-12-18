package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.EnterpriseAssess;
import com.ronyao.cca.db.model.EnterpriseAssessExample;
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

public interface EnterpriseAssessMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@SelectProvider(type = EnterpriseAssessSqlProvider.class, method = "countByExample")
	int countByExample(EnterpriseAssessExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@DeleteProvider(type = EnterpriseAssessSqlProvider.class, method = "deleteByExample")
	int deleteByExample(EnterpriseAssessExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@Delete({ "delete from enterprise_assess",
			"where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@Insert({
			"insert into enterprise_assess (category, standard, ",
			"projectNumStart, projectNumEnd, ",
			"outputStart, outputEnd, ",
			"createTime, updateTime, ",
			"enterprise)",
			"values (#{category,jdbcType=VARCHAR}, #{standard,jdbcType=VARCHAR}, ",
			"#{projectnumstart,jdbcType=INTEGER}, #{projectnumend,jdbcType=INTEGER}, ",
			"#{outputstart,jdbcType=DECIMAL}, #{outputend,jdbcType=DECIMAL}, ",
			"#{createtime,jdbcType=VARCHAR}, #{updatetime,jdbcType=VARCHAR}, ",
			"#{enterprise,jdbcType=LONGVARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(EnterpriseAssess record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@InsertProvider(type = EnterpriseAssessSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(EnterpriseAssess record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@SelectProvider(type = EnterpriseAssessSqlProvider.class, method = "selectByExampleWithBLOBs")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "category", property = "category", jdbcType = JdbcType.VARCHAR),
			@Result(column = "standard", property = "standard", jdbcType = JdbcType.VARCHAR),
			@Result(column = "projectNumStart", property = "projectnumstart", jdbcType = JdbcType.INTEGER),
			@Result(column = "projectNumEnd", property = "projectnumend", jdbcType = JdbcType.INTEGER),
			@Result(column = "outputStart", property = "outputstart", jdbcType = JdbcType.DECIMAL),
			@Result(column = "outputEnd", property = "outputend", jdbcType = JdbcType.DECIMAL),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "enterprise", property = "enterprise", jdbcType = JdbcType.LONGVARCHAR) })
	List<EnterpriseAssess> selectByExampleWithBLOBsWithRowbounds(
			EnterpriseAssessExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@SelectProvider(type = EnterpriseAssessSqlProvider.class, method = "selectByExampleWithBLOBs")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "category", property = "category", jdbcType = JdbcType.VARCHAR),
			@Result(column = "standard", property = "standard", jdbcType = JdbcType.VARCHAR),
			@Result(column = "projectNumStart", property = "projectnumstart", jdbcType = JdbcType.INTEGER),
			@Result(column = "projectNumEnd", property = "projectnumend", jdbcType = JdbcType.INTEGER),
			@Result(column = "outputStart", property = "outputstart", jdbcType = JdbcType.DECIMAL),
			@Result(column = "outputEnd", property = "outputend", jdbcType = JdbcType.DECIMAL),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "enterprise", property = "enterprise", jdbcType = JdbcType.LONGVARCHAR) })
	List<EnterpriseAssess> selectByExampleWithBLOBs(
			EnterpriseAssessExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@SelectProvider(type = EnterpriseAssessSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "category", property = "category", jdbcType = JdbcType.VARCHAR),
			@Result(column = "standard", property = "standard", jdbcType = JdbcType.VARCHAR),
			@Result(column = "projectNumStart", property = "projectnumstart", jdbcType = JdbcType.INTEGER),
			@Result(column = "projectNumEnd", property = "projectnumend", jdbcType = JdbcType.INTEGER),
			@Result(column = "outputStart", property = "outputstart", jdbcType = JdbcType.DECIMAL),
			@Result(column = "outputEnd", property = "outputend", jdbcType = JdbcType.DECIMAL),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<EnterpriseAssess> selectByExampleWithRowbounds(
			EnterpriseAssessExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@SelectProvider(type = EnterpriseAssessSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "category", property = "category", jdbcType = JdbcType.VARCHAR),
			@Result(column = "standard", property = "standard", jdbcType = JdbcType.VARCHAR),
			@Result(column = "projectNumStart", property = "projectnumstart", jdbcType = JdbcType.INTEGER),
			@Result(column = "projectNumEnd", property = "projectnumend", jdbcType = JdbcType.INTEGER),
			@Result(column = "outputStart", property = "outputstart", jdbcType = JdbcType.DECIMAL),
			@Result(column = "outputEnd", property = "outputend", jdbcType = JdbcType.DECIMAL),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<EnterpriseAssess> selectByExample(EnterpriseAssessExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@Select({
			"select",
			"id, category, standard, projectNumStart, projectNumEnd, outputStart, outputEnd, ",
			"createTime, updateTime, enterprise", "from enterprise_assess",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "category", property = "category", jdbcType = JdbcType.VARCHAR),
			@Result(column = "standard", property = "standard", jdbcType = JdbcType.VARCHAR),
			@Result(column = "projectNumStart", property = "projectnumstart", jdbcType = JdbcType.INTEGER),
			@Result(column = "projectNumEnd", property = "projectnumend", jdbcType = JdbcType.INTEGER),
			@Result(column = "outputStart", property = "outputstart", jdbcType = JdbcType.DECIMAL),
			@Result(column = "outputEnd", property = "outputend", jdbcType = JdbcType.DECIMAL),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "enterprise", property = "enterprise", jdbcType = JdbcType.LONGVARCHAR) })
	EnterpriseAssess selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@UpdateProvider(type = EnterpriseAssessSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") EnterpriseAssess record,
			@Param("example") EnterpriseAssessExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@UpdateProvider(type = EnterpriseAssessSqlProvider.class, method = "updateByExampleWithBLOBs")
	int updateByExampleWithBLOBs(@Param("record") EnterpriseAssess record,
			@Param("example") EnterpriseAssessExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@UpdateProvider(type = EnterpriseAssessSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") EnterpriseAssess record,
			@Param("example") EnterpriseAssessExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@UpdateProvider(type = EnterpriseAssessSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(EnterpriseAssess record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@Update({ "update enterprise_assess",
			"set category = #{category,jdbcType=VARCHAR},",
			"standard = #{standard,jdbcType=VARCHAR},",
			"projectNumStart = #{projectnumstart,jdbcType=INTEGER},",
			"projectNumEnd = #{projectnumend,jdbcType=INTEGER},",
			"outputStart = #{outputstart,jdbcType=DECIMAL},",
			"outputEnd = #{outputend,jdbcType=DECIMAL},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR},",
			"enterprise = #{enterprise,jdbcType=LONGVARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKeyWithBLOBs(EnterpriseAssess record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@Update({ "update enterprise_assess",
			"set category = #{category,jdbcType=VARCHAR},",
			"standard = #{standard,jdbcType=VARCHAR},",
			"projectNumStart = #{projectnumstart,jdbcType=INTEGER},",
			"projectNumEnd = #{projectnumend,jdbcType=INTEGER},",
			"outputStart = #{outputstart,jdbcType=DECIMAL},",
			"outputEnd = #{outputend,jdbcType=DECIMAL},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(EnterpriseAssess record);
}