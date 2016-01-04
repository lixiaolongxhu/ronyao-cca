package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.Behavior;
import com.ronyao.cca.db.model.BehaviorExample;
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

public interface BehaviorMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@SelectProvider(type = BehaviorSqlProvider.class, method = "countByExample")
	int countByExample(BehaviorExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@DeleteProvider(type = BehaviorSqlProvider.class, method = "deleteByExample")
	int deleteByExample(BehaviorExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@Delete({ "delete from behavior", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@Insert({
			"insert into behavior (enterpriseId, year, ",
			"generalbadNum, seriousBadNum, ",
			"correction, createTime, ",
			"updateTime)",
			"values (#{enterpriseid,jdbcType=INTEGER}, #{year,jdbcType=INTEGER}, ",
			"#{generalbadnum,jdbcType=TINYINT}, #{seriousbadnum,jdbcType=TINYINT}, ",
			"#{correction,jdbcType=DECIMAL}, #{createtime,jdbcType=VARCHAR}, ",
			"#{updatetime,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(Behavior record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@InsertProvider(type = BehaviorSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(Behavior record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@SelectProvider(type = BehaviorSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "year", property = "year", jdbcType = JdbcType.INTEGER),
			@Result(column = "generalbadNum", property = "generalbadnum", jdbcType = JdbcType.TINYINT),
			@Result(column = "seriousBadNum", property = "seriousbadnum", jdbcType = JdbcType.TINYINT),
			@Result(column = "correction", property = "correction", jdbcType = JdbcType.DECIMAL),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<Behavior> selectByExampleWithRowbounds(BehaviorExample example,
			RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@SelectProvider(type = BehaviorSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "year", property = "year", jdbcType = JdbcType.INTEGER),
			@Result(column = "generalbadNum", property = "generalbadnum", jdbcType = JdbcType.TINYINT),
			@Result(column = "seriousBadNum", property = "seriousbadnum", jdbcType = JdbcType.TINYINT),
			@Result(column = "correction", property = "correction", jdbcType = JdbcType.DECIMAL),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<Behavior> selectByExample(BehaviorExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@Select({
			"select",
			"id, enterpriseId, year, generalbadNum, seriousBadNum, correction, createTime, ",
			"updateTime", "from behavior", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "year", property = "year", jdbcType = JdbcType.INTEGER),
			@Result(column = "generalbadNum", property = "generalbadnum", jdbcType = JdbcType.TINYINT),
			@Result(column = "seriousBadNum", property = "seriousbadnum", jdbcType = JdbcType.TINYINT),
			@Result(column = "correction", property = "correction", jdbcType = JdbcType.DECIMAL),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	Behavior selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@UpdateProvider(type = BehaviorSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Behavior record,
			@Param("example") BehaviorExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@UpdateProvider(type = BehaviorSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Behavior record,
			@Param("example") BehaviorExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@UpdateProvider(type = BehaviorSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Behavior record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior
	 * @mbggenerated  Mon Jan 04 10:04:47 CST 2016
	 */
	@Update({ "update behavior",
			"set enterpriseId = #{enterpriseid,jdbcType=INTEGER},",
			"year = #{year,jdbcType=INTEGER},",
			"generalbadNum = #{generalbadnum,jdbcType=TINYINT},",
			"seriousBadNum = #{seriousbadnum,jdbcType=TINYINT},",
			"correction = #{correction,jdbcType=DECIMAL},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Behavior record);
}