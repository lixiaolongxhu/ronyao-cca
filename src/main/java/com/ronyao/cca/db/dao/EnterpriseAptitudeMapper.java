package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.EnterpriseAptitude;
import com.ronyao.cca.db.model.EnterpriseAptitudeExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.annotations.SelectKey;

public interface EnterpriseAptitudeMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	@SelectProvider(type = EnterpriseAptitudeSqlProvider.class, method = "countByExample")
	int countByExample(EnterpriseAptitudeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	@DeleteProvider(type = EnterpriseAptitudeSqlProvider.class, method = "deleteByExample")
	int deleteByExample(EnterpriseAptitudeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	@Delete({ "delete from enterprise_aptitude",
			"where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	@Insert({
			"insert into enterprise_aptitude (aptitudeId, aptitudeRank, ",
			"qualifications, practicing, ",
			"charge, technical, ",
			"skills, jobRange, ",
			"createTime, updateTime)",
			"values (#{aptitudeid,jdbcType=TINYINT}, #{aptituderank,jdbcType=TINYINT}, ",
			"#{qualifications,jdbcType=VARCHAR}, #{practicing,jdbcType=VARCHAR}, ",
			"#{charge,jdbcType=VARCHAR}, #{technical,jdbcType=VARCHAR}, ",
			"#{skills,jdbcType=VARCHAR}, #{jobrange,jdbcType=VARCHAR}, ",
			"#{createtime,jdbcType=VARCHAR}, #{updatetime,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(EnterpriseAptitude record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	@InsertProvider(type = EnterpriseAptitudeSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(EnterpriseAptitude record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	@SelectProvider(type = EnterpriseAptitudeSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "aptitudeId", property = "aptitudeid", jdbcType = JdbcType.TINYINT),
			@Result(column = "aptitudeRank", property = "aptituderank", jdbcType = JdbcType.TINYINT),
			@Result(column = "qualifications", property = "qualifications", jdbcType = JdbcType.VARCHAR),
			@Result(column = "practicing", property = "practicing", jdbcType = JdbcType.VARCHAR),
			@Result(column = "charge", property = "charge", jdbcType = JdbcType.VARCHAR),
			@Result(column = "technical", property = "technical", jdbcType = JdbcType.VARCHAR),
			@Result(column = "skills", property = "skills", jdbcType = JdbcType.VARCHAR),
			@Result(column = "jobRange", property = "jobrange", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<EnterpriseAptitude> selectByExampleWithRowbounds(
			EnterpriseAptitudeExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	@SelectProvider(type = EnterpriseAptitudeSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "aptitudeId", property = "aptitudeid", jdbcType = JdbcType.TINYINT),
			@Result(column = "aptitudeRank", property = "aptituderank", jdbcType = JdbcType.TINYINT),
			@Result(column = "qualifications", property = "qualifications", jdbcType = JdbcType.VARCHAR),
			@Result(column = "practicing", property = "practicing", jdbcType = JdbcType.VARCHAR),
			@Result(column = "charge", property = "charge", jdbcType = JdbcType.VARCHAR),
			@Result(column = "technical", property = "technical", jdbcType = JdbcType.VARCHAR),
			@Result(column = "skills", property = "skills", jdbcType = JdbcType.VARCHAR),
			@Result(column = "jobRange", property = "jobrange", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<EnterpriseAptitude> selectByExample(EnterpriseAptitudeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	@Select({
			"select",
			"id, aptitudeId, aptitudeRank, qualifications, practicing, charge, technical, ",
			"skills, jobRange, createTime, updateTime",
			"from enterprise_aptitude", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "aptitudeId", property = "aptitudeid", jdbcType = JdbcType.TINYINT),
			@Result(column = "aptitudeRank", property = "aptituderank", jdbcType = JdbcType.TINYINT),
			@Result(column = "qualifications", property = "qualifications", jdbcType = JdbcType.VARCHAR),
			@Result(column = "practicing", property = "practicing", jdbcType = JdbcType.VARCHAR),
			@Result(column = "charge", property = "charge", jdbcType = JdbcType.VARCHAR),
			@Result(column = "technical", property = "technical", jdbcType = JdbcType.VARCHAR),
			@Result(column = "skills", property = "skills", jdbcType = JdbcType.VARCHAR),
			@Result(column = "jobRange", property = "jobrange", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	EnterpriseAptitude selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	@UpdateProvider(type = EnterpriseAptitudeSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") EnterpriseAptitude record,
			@Param("example") EnterpriseAptitudeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	@UpdateProvider(type = EnterpriseAptitudeSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") EnterpriseAptitude record,
			@Param("example") EnterpriseAptitudeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	@UpdateProvider(type = EnterpriseAptitudeSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(EnterpriseAptitude record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	@Update({ "update enterprise_aptitude",
			"set aptitudeId = #{aptitudeid,jdbcType=TINYINT},",
			"aptitudeRank = #{aptituderank,jdbcType=TINYINT},",
			"qualifications = #{qualifications,jdbcType=VARCHAR},",
			"practicing = #{practicing,jdbcType=VARCHAR},",
			"charge = #{charge,jdbcType=VARCHAR},",
			"technical = #{technical,jdbcType=VARCHAR},",
			"skills = #{skills,jdbcType=VARCHAR},",
			"jobRange = #{jobrange,jdbcType=VARCHAR},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(EnterpriseAptitude record);
}