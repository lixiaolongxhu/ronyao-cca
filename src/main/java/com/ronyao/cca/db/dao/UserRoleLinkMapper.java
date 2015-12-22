package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.UserRoleLink;
import com.ronyao.cca.db.model.UserRoleLinkExample;
import com.ronyao.cca.db.model.UserRoleLinkKey;
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

public interface UserRoleLinkMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_role_link
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	@SelectProvider(type = UserRoleLinkSqlProvider.class, method = "countByExample")
	int countByExample(UserRoleLinkExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_role_link
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	@DeleteProvider(type = UserRoleLinkSqlProvider.class, method = "deleteByExample")
	int deleteByExample(UserRoleLinkExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_role_link
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	@Delete({ "delete from user_role_link",
			"where userId = #{userid,jdbcType=INTEGER}",
			"and roleId = #{roleid,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(UserRoleLinkKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_role_link
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	@Insert({ "insert into user_role_link (userId, roleId, ",
			"status, createTime, ", "updateTime)",
			"values (#{userid,jdbcType=INTEGER}, #{roleid,jdbcType=INTEGER}, ",
			"#{status,jdbcType=TINYINT}, #{createtime,jdbcType=VARCHAR}, ",
			"#{updatetime,jdbcType=VARCHAR})" })
	int insert(UserRoleLink record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_role_link
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	@InsertProvider(type = UserRoleLinkSqlProvider.class, method = "insertSelective")
	int insertSelective(UserRoleLink record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_role_link
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	@SelectProvider(type = UserRoleLinkSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "userId", property = "userid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "roleId", property = "roleid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<UserRoleLink> selectByExampleWithRowbounds(
			UserRoleLinkExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_role_link
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	@SelectProvider(type = UserRoleLinkSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "userId", property = "userid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "roleId", property = "roleid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<UserRoleLink> selectByExample(UserRoleLinkExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_role_link
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	@Select({ "select", "userId, roleId, status, createTime, updateTime",
			"from user_role_link", "where userId = #{userid,jdbcType=INTEGER}",
			"and roleId = #{roleid,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "userId", property = "userid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "roleId", property = "roleid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	UserRoleLink selectByPrimaryKey(UserRoleLinkKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_role_link
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	@UpdateProvider(type = UserRoleLinkSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") UserRoleLink record,
			@Param("example") UserRoleLinkExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_role_link
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	@UpdateProvider(type = UserRoleLinkSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") UserRoleLink record,
			@Param("example") UserRoleLinkExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_role_link
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	@UpdateProvider(type = UserRoleLinkSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(UserRoleLink record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_role_link
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	@Update({ "update user_role_link",
			"set status = #{status,jdbcType=TINYINT},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where userId = #{userid,jdbcType=INTEGER}",
			"and roleId = #{roleid,jdbcType=INTEGER}" })
	int updateByPrimaryKey(UserRoleLink record);
}