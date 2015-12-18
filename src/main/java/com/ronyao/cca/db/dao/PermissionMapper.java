package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.Permission;
import com.ronyao.cca.db.model.PermissionExample;
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

public interface PermissionMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table permission
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	@SelectProvider(type = PermissionSqlProvider.class, method = "countByExample")
	int countByExample(PermissionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table permission
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	@DeleteProvider(type = PermissionSqlProvider.class, method = "deleteByExample")
	int deleteByExample(PermissionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table permission
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	@Delete({ "delete from permission", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table permission
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	@Insert({
			"insert into permission (parentId, name, ",
			"url, type, description, ",
			"weight, status, ",
			"createTime, updateTime)",
			"values (#{parentid,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
			"#{url,jdbcType=VARCHAR}, #{type,jdbcType=TINYINT}, #{description,jdbcType=VARCHAR}, ",
			"#{weight,jdbcType=TINYINT}, #{status,jdbcType=TINYINT}, ",
			"#{createtime,jdbcType=VARCHAR}, #{updatetime,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(Permission record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table permission
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	@InsertProvider(type = PermissionSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(Permission record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table permission
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	@SelectProvider(type = PermissionSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "parentId", property = "parentid", jdbcType = JdbcType.INTEGER),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "url", property = "url", jdbcType = JdbcType.VARCHAR),
			@Result(column = "type", property = "type", jdbcType = JdbcType.TINYINT),
			@Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
			@Result(column = "weight", property = "weight", jdbcType = JdbcType.TINYINT),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<Permission> selectByExampleWithRowbounds(PermissionExample example,
			RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table permission
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	@SelectProvider(type = PermissionSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "parentId", property = "parentid", jdbcType = JdbcType.INTEGER),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "url", property = "url", jdbcType = JdbcType.VARCHAR),
			@Result(column = "type", property = "type", jdbcType = JdbcType.TINYINT),
			@Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
			@Result(column = "weight", property = "weight", jdbcType = JdbcType.TINYINT),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<Permission> selectByExample(PermissionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table permission
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	@Select({
			"select",
			"id, parentId, name, url, type, description, weight, status, createTime, updateTime",
			"from permission", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "parentId", property = "parentid", jdbcType = JdbcType.INTEGER),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "url", property = "url", jdbcType = JdbcType.VARCHAR),
			@Result(column = "type", property = "type", jdbcType = JdbcType.TINYINT),
			@Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
			@Result(column = "weight", property = "weight", jdbcType = JdbcType.TINYINT),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	Permission selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table permission
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	@UpdateProvider(type = PermissionSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Permission record,
			@Param("example") PermissionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table permission
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	@UpdateProvider(type = PermissionSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Permission record,
			@Param("example") PermissionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table permission
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	@UpdateProvider(type = PermissionSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Permission record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table permission
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	@Update({ "update permission",
			"set parentId = #{parentid,jdbcType=INTEGER},",
			"name = #{name,jdbcType=VARCHAR},",
			"url = #{url,jdbcType=VARCHAR},",
			"type = #{type,jdbcType=TINYINT},",
			"description = #{description,jdbcType=VARCHAR},",
			"weight = #{weight,jdbcType=TINYINT},",
			"status = #{status,jdbcType=TINYINT},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Permission record);
}