package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.User;
import com.ronyao.cca.db.model.UserExample;
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

public interface UserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Dec 17 13:33:50 CST 2015
	 */
	@SelectProvider(type = UserSqlProvider.class, method = "countByExample")
	int countByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Dec 17 13:33:50 CST 2015
	 */
	@DeleteProvider(type = UserSqlProvider.class, method = "deleteByExample")
	int deleteByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Dec 17 13:33:50 CST 2015
	 */
	@Delete({ "delete from user", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Dec 17 13:33:50 CST 2015
	 */
	@Insert({
			"insert into user (loginName, password, ",
			"token, realName, ",
			"nickname, portraitPath, ",
			"status, createTime, ",
			"updateTime)",
			"values (#{loginname,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
			"#{token,jdbcType=VARCHAR}, #{realname,jdbcType=VARCHAR}, ",
			"#{nickname,jdbcType=VARCHAR}, #{portraitpath,jdbcType=VARCHAR}, ",
			"#{status,jdbcType=TINYINT}, #{createtime,jdbcType=VARCHAR}, ",
			"#{updatetime,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Dec 17 13:33:50 CST 2015
	 */
	@InsertProvider(type = UserSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Dec 17 13:33:50 CST 2015
	 */
	@SelectProvider(type = UserSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "loginName", property = "loginname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
			@Result(column = "token", property = "token", jdbcType = JdbcType.VARCHAR),
			@Result(column = "realName", property = "realname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nickname", property = "nickname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "portraitPath", property = "portraitpath", jdbcType = JdbcType.VARCHAR),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<User> selectByExampleWithRowbounds(UserExample example,
			RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Dec 17 13:33:50 CST 2015
	 */
	@SelectProvider(type = UserSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "loginName", property = "loginname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
			@Result(column = "token", property = "token", jdbcType = JdbcType.VARCHAR),
			@Result(column = "realName", property = "realname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nickname", property = "nickname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "portraitPath", property = "portraitpath", jdbcType = JdbcType.VARCHAR),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<User> selectByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Dec 17 13:33:50 CST 2015
	 */
	@Select({
			"select",
			"id, loginName, password, token, realName, nickname, portraitPath, status, createTime, ",
			"updateTime", "from user", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "loginName", property = "loginname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
			@Result(column = "token", property = "token", jdbcType = JdbcType.VARCHAR),
			@Result(column = "realName", property = "realname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nickname", property = "nickname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "portraitPath", property = "portraitpath", jdbcType = JdbcType.VARCHAR),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	User selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Dec 17 13:33:50 CST 2015
	 */
	@UpdateProvider(type = UserSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") User record,
			@Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Dec 17 13:33:50 CST 2015
	 */
	@UpdateProvider(type = UserSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") User record,
			@Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Dec 17 13:33:50 CST 2015
	 */
	@UpdateProvider(type = UserSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Thu Dec 17 13:33:50 CST 2015
	 */
	@Update({ "update user", "set loginName = #{loginname,jdbcType=VARCHAR},",
			"password = #{password,jdbcType=VARCHAR},",
			"token = #{token,jdbcType=VARCHAR},",
			"realName = #{realname,jdbcType=VARCHAR},",
			"nickname = #{nickname,jdbcType=VARCHAR},",
			"portraitPath = #{portraitpath,jdbcType=VARCHAR},",
			"status = #{status,jdbcType=TINYINT},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(User record);
}