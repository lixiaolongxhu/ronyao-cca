package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.UserLog;
import com.ronyao.cca.db.model.UserLogExample;
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

public interface UserLogMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_log
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@SelectProvider(type = UserLogSqlProvider.class, method = "countByExample")
	int countByExample(UserLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_log
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@DeleteProvider(type = UserLogSqlProvider.class, method = "deleteByExample")
	int deleteByExample(UserLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_log
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@Delete({ "delete from user_log", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_log
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@Insert({
			"insert into user_log (uid, user_action, ",
			"operate_time, ip_address, ",
			"comment_info)",
			"values (#{uid,jdbcType=INTEGER}, #{userAction,jdbcType=VARCHAR}, ",
			"#{operateTime,jdbcType=TIMESTAMP}, #{ipAddress,jdbcType=VARCHAR}, ",
			"#{commentInfo,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(UserLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_log
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@InsertProvider(type = UserLogSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(UserLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_log
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@SelectProvider(type = UserLogSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "uid", property = "uid", jdbcType = JdbcType.INTEGER),
			@Result(column = "user_action", property = "userAction", jdbcType = JdbcType.VARCHAR),
			@Result(column = "operate_time", property = "operateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "ip_address", property = "ipAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "comment_info", property = "commentInfo", jdbcType = JdbcType.VARCHAR) })
	List<UserLog> selectByExampleWithRowbounds(UserLogExample example,
			RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_log
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@SelectProvider(type = UserLogSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "uid", property = "uid", jdbcType = JdbcType.INTEGER),
			@Result(column = "user_action", property = "userAction", jdbcType = JdbcType.VARCHAR),
			@Result(column = "operate_time", property = "operateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "ip_address", property = "ipAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "comment_info", property = "commentInfo", jdbcType = JdbcType.VARCHAR) })
	List<UserLog> selectByExample(UserLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_log
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@Select({ "select",
			"id, uid, user_action, operate_time, ip_address, comment_info",
			"from user_log", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "uid", property = "uid", jdbcType = JdbcType.INTEGER),
			@Result(column = "user_action", property = "userAction", jdbcType = JdbcType.VARCHAR),
			@Result(column = "operate_time", property = "operateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "ip_address", property = "ipAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "comment_info", property = "commentInfo", jdbcType = JdbcType.VARCHAR) })
	UserLog selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_log
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@UpdateProvider(type = UserLogSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") UserLog record,
			@Param("example") UserLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_log
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@UpdateProvider(type = UserLogSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") UserLog record,
			@Param("example") UserLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_log
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@UpdateProvider(type = UserLogSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(UserLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_log
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@Update({ "update user_log", "set uid = #{uid,jdbcType=INTEGER},",
			"user_action = #{userAction,jdbcType=VARCHAR},",
			"operate_time = #{operateTime,jdbcType=TIMESTAMP},",
			"ip_address = #{ipAddress,jdbcType=VARCHAR},",
			"comment_info = #{commentInfo,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(UserLog record);
}