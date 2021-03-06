package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.EnterpriseFile;
import com.ronyao.cca.db.model.EnterpriseFileExample;
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

public interface EnterpriseFileMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@SelectProvider(type = EnterpriseFileSqlProvider.class, method = "countByExample")
	int countByExample(EnterpriseFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@DeleteProvider(type = EnterpriseFileSqlProvider.class, method = "deleteByExample")
	int deleteByExample(EnterpriseFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@Delete({ "delete from enterprise_file",
			"where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@Insert({
			"insert into enterprise_file (enterpriseId, fileType, ",
			"aptitudeRankId, aptitudeId, ",
			"path, createTime, ",
			"updateTime)",
			"values (#{enterpriseid,jdbcType=INTEGER}, #{filetype,jdbcType=TINYINT}, ",
			"#{aptituderankid,jdbcType=TINYINT}, #{aptitudeid,jdbcType=TINYINT}, ",
			"#{path,jdbcType=VARCHAR}, #{createtime,jdbcType=VARCHAR}, ",
			"#{updatetime,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(EnterpriseFile record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@InsertProvider(type = EnterpriseFileSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(EnterpriseFile record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@SelectProvider(type = EnterpriseFileSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "fileType", property = "filetype", jdbcType = JdbcType.TINYINT),
			@Result(column = "aptitudeRankId", property = "aptituderankid", jdbcType = JdbcType.TINYINT),
			@Result(column = "aptitudeId", property = "aptitudeid", jdbcType = JdbcType.TINYINT),
			@Result(column = "path", property = "path", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<EnterpriseFile> selectByExampleWithRowbounds(
			EnterpriseFileExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@SelectProvider(type = EnterpriseFileSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "fileType", property = "filetype", jdbcType = JdbcType.TINYINT),
			@Result(column = "aptitudeRankId", property = "aptituderankid", jdbcType = JdbcType.TINYINT),
			@Result(column = "aptitudeId", property = "aptitudeid", jdbcType = JdbcType.TINYINT),
			@Result(column = "path", property = "path", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<EnterpriseFile> selectByExample(EnterpriseFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@Select({
			"select",
			"id, enterpriseId, fileType, aptitudeRankId, aptitudeId, path, createTime, updateTime",
			"from enterprise_file", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "fileType", property = "filetype", jdbcType = JdbcType.TINYINT),
			@Result(column = "aptitudeRankId", property = "aptituderankid", jdbcType = JdbcType.TINYINT),
			@Result(column = "aptitudeId", property = "aptitudeid", jdbcType = JdbcType.TINYINT),
			@Result(column = "path", property = "path", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	EnterpriseFile selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@UpdateProvider(type = EnterpriseFileSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") EnterpriseFile record,
			@Param("example") EnterpriseFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@UpdateProvider(type = EnterpriseFileSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") EnterpriseFile record,
			@Param("example") EnterpriseFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@UpdateProvider(type = EnterpriseFileSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(EnterpriseFile record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@Update({ "update enterprise_file",
			"set enterpriseId = #{enterpriseid,jdbcType=INTEGER},",
			"fileType = #{filetype,jdbcType=TINYINT},",
			"aptitudeRankId = #{aptituderankid,jdbcType=TINYINT},",
			"aptitudeId = #{aptitudeid,jdbcType=TINYINT},",
			"path = #{path,jdbcType=VARCHAR},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(EnterpriseFile record);
}