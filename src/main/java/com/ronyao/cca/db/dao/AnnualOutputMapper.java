package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.AnnualOutput;
import com.ronyao.cca.db.model.AnnualOutputExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AnnualOutputMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@SelectProvider(type = AnnualOutputSqlProvider.class, method = "countByExample")
	int countByExample(AnnualOutputExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@DeleteProvider(type = AnnualOutputSqlProvider.class, method = "deleteByExample")
	int deleteByExample(AnnualOutputExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@Delete({ "delete from annual_output", "where id = #{id,jdbcType=TINYINT}" })
	int deleteByPrimaryKey(Byte id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@Insert({
			"insert into annual_output (voltageRankId, projectType, ",
			"timLlimit, projectNum, ",
			"annualOutPut, remark, ",
			"createTime, updateTime)",
			"values (#{voltagerankid,jdbcType=TINYINT}, #{projecttype,jdbcType=TINYINT}, ",
			"#{timllimit,jdbcType=TINYINT}, #{projectnum,jdbcType=DECIMAL}, ",
			"#{annualoutput,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
			"#{createtime,jdbcType=VARCHAR}, #{updatetime,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Byte.class)
	int insert(AnnualOutput record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@InsertProvider(type = AnnualOutputSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Byte.class)
	int insertSelective(AnnualOutput record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@SelectProvider(type = AnnualOutputSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.TINYINT, id = true),
			@Result(column = "voltageRankId", property = "voltagerankid", jdbcType = JdbcType.TINYINT),
			@Result(column = "projectType", property = "projecttype", jdbcType = JdbcType.TINYINT),
			@Result(column = "timLlimit", property = "timllimit", jdbcType = JdbcType.TINYINT),
			@Result(column = "projectNum", property = "projectnum", jdbcType = JdbcType.DECIMAL),
			@Result(column = "annualOutPut", property = "annualoutput", jdbcType = JdbcType.INTEGER),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<AnnualOutput> selectByExampleWithRowbounds(
			AnnualOutputExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@SelectProvider(type = AnnualOutputSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.TINYINT, id = true),
			@Result(column = "voltageRankId", property = "voltagerankid", jdbcType = JdbcType.TINYINT),
			@Result(column = "projectType", property = "projecttype", jdbcType = JdbcType.TINYINT),
			@Result(column = "timLlimit", property = "timllimit", jdbcType = JdbcType.TINYINT),
			@Result(column = "projectNum", property = "projectnum", jdbcType = JdbcType.DECIMAL),
			@Result(column = "annualOutPut", property = "annualoutput", jdbcType = JdbcType.INTEGER),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<AnnualOutput> selectByExample(AnnualOutputExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@Select({
			"select",
			"id, voltageRankId, projectType, timLlimit, projectNum, annualOutPut, remark, ",
			"createTime, updateTime", "from annual_output",
			"where id = #{id,jdbcType=TINYINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.TINYINT, id = true),
			@Result(column = "voltageRankId", property = "voltagerankid", jdbcType = JdbcType.TINYINT),
			@Result(column = "projectType", property = "projecttype", jdbcType = JdbcType.TINYINT),
			@Result(column = "timLlimit", property = "timllimit", jdbcType = JdbcType.TINYINT),
			@Result(column = "projectNum", property = "projectnum", jdbcType = JdbcType.DECIMAL),
			@Result(column = "annualOutPut", property = "annualoutput", jdbcType = JdbcType.INTEGER),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	AnnualOutput selectByPrimaryKey(Byte id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@UpdateProvider(type = AnnualOutputSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") AnnualOutput record,
			@Param("example") AnnualOutputExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@UpdateProvider(type = AnnualOutputSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") AnnualOutput record,
			@Param("example") AnnualOutputExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@UpdateProvider(type = AnnualOutputSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(AnnualOutput record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@Update({ "update annual_output",
			"set voltageRankId = #{voltagerankid,jdbcType=TINYINT},",
			"projectType = #{projecttype,jdbcType=TINYINT},",
			"timLlimit = #{timllimit,jdbcType=TINYINT},",
			"projectNum = #{projectnum,jdbcType=DECIMAL},",
			"annualOutPut = #{annualoutput,jdbcType=INTEGER},",
			"remark = #{remark,jdbcType=VARCHAR},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=TINYINT}" })
	int updateByPrimaryKey(AnnualOutput record);
}