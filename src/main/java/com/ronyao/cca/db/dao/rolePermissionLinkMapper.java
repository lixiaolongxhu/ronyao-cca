package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.rolePermissionLink;
import com.ronyao.cca.db.model.rolePermissionLinkExample;
import com.ronyao.cca.db.model.rolePermissionLinkKey;
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

public interface rolePermissionLinkMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@SelectProvider(type = rolePermissionLinkSqlProvider.class, method = "countByExample")
	int countByExample(rolePermissionLinkExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@DeleteProvider(type = rolePermissionLinkSqlProvider.class, method = "deleteByExample")
	int deleteByExample(rolePermissionLinkExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@Delete({ "delete from role_permission_link",
			"where roleId = #{roleid,jdbcType=INTEGER}",
			"and permissionId = #{permissionid,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(rolePermissionLinkKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@Insert({
			"insert into role_permission_link (roleId, permissionId, ",
			"status, createTime, ",
			"updateTime)",
			"values (#{roleid,jdbcType=INTEGER}, #{permissionid,jdbcType=INTEGER}, ",
			"#{status,jdbcType=TINYINT}, #{createtime,jdbcType=VARCHAR}, ",
			"#{updatetime,jdbcType=VARCHAR})" })
	int insert(rolePermissionLink record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@InsertProvider(type = rolePermissionLinkSqlProvider.class, method = "insertSelective")
	int insertSelective(rolePermissionLink record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@SelectProvider(type = rolePermissionLinkSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "roleId", property = "roleid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "permissionId", property = "permissionid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<rolePermissionLink> selectByExampleWithRowbounds(
			rolePermissionLinkExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@SelectProvider(type = rolePermissionLinkSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "roleId", property = "roleid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "permissionId", property = "permissionid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<rolePermissionLink> selectByExample(rolePermissionLinkExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@Select({ "select", "roleId, permissionId, status, createTime, updateTime",
			"from role_permission_link",
			"where roleId = #{roleid,jdbcType=INTEGER}",
			"and permissionId = #{permissionid,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "roleId", property = "roleid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "permissionId", property = "permissionid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	rolePermissionLink selectByPrimaryKey(rolePermissionLinkKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@UpdateProvider(type = rolePermissionLinkSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") rolePermissionLink record,
			@Param("example") rolePermissionLinkExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@UpdateProvider(type = rolePermissionLinkSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") rolePermissionLink record,
			@Param("example") rolePermissionLinkExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@UpdateProvider(type = rolePermissionLinkSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(rolePermissionLink record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_permission_link
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	@Update({ "update role_permission_link",
			"set status = #{status,jdbcType=TINYINT},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where roleId = #{roleid,jdbcType=INTEGER}",
			"and permissionId = #{permissionid,jdbcType=INTEGER}" })
	int updateByPrimaryKey(rolePermissionLink record);
}