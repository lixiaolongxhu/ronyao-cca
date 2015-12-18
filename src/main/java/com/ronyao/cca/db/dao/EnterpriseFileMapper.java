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
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	@SelectProvider(type = EnterpriseFileSqlProvider.class, method = "countByExample")
	int countByExample(EnterpriseFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	@DeleteProvider(type = EnterpriseFileSqlProvider.class, method = "deleteByExample")
	int deleteByExample(EnterpriseFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	@Delete({ "delete from enterprise_file",
			"where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	@Insert({
			"insert into enterprise_file (enterpriseId, fileType, ",
			"aptitudeType, path, ",
			"createTime, updatTime)",
			"values (#{enterpriseid,jdbcType=INTEGER}, #{filetype,jdbcType=TINYINT}, ",
			"#{aptitudetype,jdbcType=TINYINT}, #{path,jdbcType=VARCHAR}, ",
			"#{createtime,jdbcType=VARCHAR}, #{updattime,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(EnterpriseFile record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	@InsertProvider(type = EnterpriseFileSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(EnterpriseFile record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	@SelectProvider(type = EnterpriseFileSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "fileType", property = "filetype", jdbcType = JdbcType.TINYINT),
			@Result(column = "aptitudeType", property = "aptitudetype", jdbcType = JdbcType.TINYINT),
			@Result(column = "path", property = "path", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updatTime", property = "updattime", jdbcType = JdbcType.VARCHAR) })
	List<EnterpriseFile> selectByExampleWithRowbounds(
			EnterpriseFileExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	@SelectProvider(type = EnterpriseFileSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "fileType", property = "filetype", jdbcType = JdbcType.TINYINT),
			@Result(column = "aptitudeType", property = "aptitudetype", jdbcType = JdbcType.TINYINT),
			@Result(column = "path", property = "path", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updatTime", property = "updattime", jdbcType = JdbcType.VARCHAR) })
	List<EnterpriseFile> selectByExample(EnterpriseFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	@Select({
			"select",
			"id, enterpriseId, fileType, aptitudeType, path, createTime, updatTime",
			"from enterprise_file", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "fileType", property = "filetype", jdbcType = JdbcType.TINYINT),
			@Result(column = "aptitudeType", property = "aptitudetype", jdbcType = JdbcType.TINYINT),
			@Result(column = "path", property = "path", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updatTime", property = "updattime", jdbcType = JdbcType.VARCHAR) })
	EnterpriseFile selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	@UpdateProvider(type = EnterpriseFileSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") EnterpriseFile record,
			@Param("example") EnterpriseFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	@UpdateProvider(type = EnterpriseFileSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") EnterpriseFile record,
			@Param("example") EnterpriseFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	@UpdateProvider(type = EnterpriseFileSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(EnterpriseFile record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 10:21:52 CST 2015
	 */
	@Update({ "update enterprise_file",
			"set enterpriseId = #{enterpriseid,jdbcType=INTEGER},",
			"fileType = #{filetype,jdbcType=TINYINT},",
			"aptitudeType = #{aptitudetype,jdbcType=TINYINT},",
			"path = #{path,jdbcType=VARCHAR},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updatTime = #{updattime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(EnterpriseFile record);
}