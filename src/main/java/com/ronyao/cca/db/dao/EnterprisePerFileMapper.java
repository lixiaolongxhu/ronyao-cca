package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.EnterprisePerFile;
import com.ronyao.cca.db.model.EnterprisePerFileExample;
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

public interface EnterprisePerFileMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@SelectProvider(type = EnterprisePerFileSqlProvider.class, method = "countByExample")
	int countByExample(EnterprisePerFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@DeleteProvider(type = EnterprisePerFileSqlProvider.class, method = "deleteByExample")
	int deleteByExample(EnterprisePerFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@Delete({ "delete from enterprise_per_file",
			"where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@Insert({
			"insert into enterprise_per_file (enterpriseId, enterprisePerId, ",
			"classify, rank, ",
			"path, fileType, ",
			"createTime, updateTime)",
			"values (#{enterpriseid,jdbcType=INTEGER}, #{enterpriseperid,jdbcType=INTEGER}, ",
			"#{classify,jdbcType=VARCHAR}, #{rank,jdbcType=VARCHAR}, ",
			"#{path,jdbcType=VARCHAR}, #{filetype,jdbcType=TINYINT}, ",
			"#{createtime,jdbcType=VARCHAR}, #{updatetime,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(EnterprisePerFile record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@InsertProvider(type = EnterprisePerFileSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(EnterprisePerFile record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@SelectProvider(type = EnterprisePerFileSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "enterprisePerId", property = "enterpriseperid", jdbcType = JdbcType.INTEGER),
			@Result(column = "classify", property = "classify", jdbcType = JdbcType.VARCHAR),
			@Result(column = "rank", property = "rank", jdbcType = JdbcType.VARCHAR),
			@Result(column = "path", property = "path", jdbcType = JdbcType.VARCHAR),
			@Result(column = "fileType", property = "filetype", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<EnterprisePerFile> selectByExampleWithRowbounds(
			EnterprisePerFileExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@SelectProvider(type = EnterprisePerFileSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "enterprisePerId", property = "enterpriseperid", jdbcType = JdbcType.INTEGER),
			@Result(column = "classify", property = "classify", jdbcType = JdbcType.VARCHAR),
			@Result(column = "rank", property = "rank", jdbcType = JdbcType.VARCHAR),
			@Result(column = "path", property = "path", jdbcType = JdbcType.VARCHAR),
			@Result(column = "fileType", property = "filetype", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<EnterprisePerFile> selectByExample(EnterprisePerFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@Select({
			"select",
			"id, enterpriseId, enterprisePerId, classify, rank, path, fileType, createTime, ",
			"updateTime", "from enterprise_per_file",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "enterprisePerId", property = "enterpriseperid", jdbcType = JdbcType.INTEGER),
			@Result(column = "classify", property = "classify", jdbcType = JdbcType.VARCHAR),
			@Result(column = "rank", property = "rank", jdbcType = JdbcType.VARCHAR),
			@Result(column = "path", property = "path", jdbcType = JdbcType.VARCHAR),
			@Result(column = "fileType", property = "filetype", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	EnterprisePerFile selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@UpdateProvider(type = EnterprisePerFileSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") EnterprisePerFile record,
			@Param("example") EnterprisePerFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@UpdateProvider(type = EnterprisePerFileSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") EnterprisePerFile record,
			@Param("example") EnterprisePerFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@UpdateProvider(type = EnterprisePerFileSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(EnterprisePerFile record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_per_file
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	@Update({ "update enterprise_per_file",
			"set enterpriseId = #{enterpriseid,jdbcType=INTEGER},",
			"enterprisePerId = #{enterpriseperid,jdbcType=INTEGER},",
			"classify = #{classify,jdbcType=VARCHAR},",
			"rank = #{rank,jdbcType=VARCHAR},",
			"path = #{path,jdbcType=VARCHAR},",
			"fileType = #{filetype,jdbcType=TINYINT},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(EnterprisePerFile record);
}