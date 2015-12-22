package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.BehaviorStandard;
import com.ronyao.cca.db.model.BehaviorStandardExample;
import com.ronyao.cca.db.model.BehaviorStandardWithBLOBs;
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

public interface BehaviorStandardMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@SelectProvider(type = BehaviorStandardSqlProvider.class, method = "countByExample")
	int countByExample(BehaviorStandardExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@DeleteProvider(type = BehaviorStandardSqlProvider.class, method = "deleteByExample")
	int deleteByExample(BehaviorStandardExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@Delete({ "delete from behavior_standard",
			"where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@Insert({
			"insert into behavior_standard (rankType, createTime, ",
			"updateTime, sincerity, ",
			"save, progress, ",
			"service, other)",
			"values (#{ranktype,jdbcType=TINYINT}, #{createtime,jdbcType=VARCHAR}, ",
			"#{updatetime,jdbcType=VARCHAR}, #{sincerity,jdbcType=LONGVARCHAR}, ",
			"#{save,jdbcType=LONGVARCHAR}, #{progress,jdbcType=LONGVARCHAR}, ",
			"#{service,jdbcType=LONGVARCHAR}, #{other,jdbcType=LONGVARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(BehaviorStandardWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@InsertProvider(type = BehaviorStandardSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(BehaviorStandardWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@SelectProvider(type = BehaviorStandardSqlProvider.class, method = "selectByExampleWithBLOBs")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "rankType", property = "ranktype", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sincerity", property = "sincerity", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "save", property = "save", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "progress", property = "progress", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "service", property = "service", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "other", property = "other", jdbcType = JdbcType.LONGVARCHAR) })
	List<BehaviorStandardWithBLOBs> selectByExampleWithBLOBsWithRowbounds(
			BehaviorStandardExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@SelectProvider(type = BehaviorStandardSqlProvider.class, method = "selectByExampleWithBLOBs")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "rankType", property = "ranktype", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sincerity", property = "sincerity", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "save", property = "save", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "progress", property = "progress", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "service", property = "service", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "other", property = "other", jdbcType = JdbcType.LONGVARCHAR) })
	List<BehaviorStandardWithBLOBs> selectByExampleWithBLOBs(
			BehaviorStandardExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@SelectProvider(type = BehaviorStandardSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "rankType", property = "ranktype", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<BehaviorStandard> selectByExampleWithRowbounds(
			BehaviorStandardExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@SelectProvider(type = BehaviorStandardSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "rankType", property = "ranktype", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<BehaviorStandard> selectByExample(BehaviorStandardExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@Select({
			"select",
			"id, rankType, createTime, updateTime, sincerity, save, progress, service, other",
			"from behavior_standard", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "rankType", property = "ranktype", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sincerity", property = "sincerity", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "save", property = "save", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "progress", property = "progress", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "service", property = "service", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "other", property = "other", jdbcType = JdbcType.LONGVARCHAR) })
	BehaviorStandardWithBLOBs selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@UpdateProvider(type = BehaviorStandardSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(
			@Param("record") BehaviorStandardWithBLOBs record,
			@Param("example") BehaviorStandardExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@UpdateProvider(type = BehaviorStandardSqlProvider.class, method = "updateByExampleWithBLOBs")
	int updateByExampleWithBLOBs(
			@Param("record") BehaviorStandardWithBLOBs record,
			@Param("example") BehaviorStandardExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@UpdateProvider(type = BehaviorStandardSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") BehaviorStandard record,
			@Param("example") BehaviorStandardExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@UpdateProvider(type = BehaviorStandardSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(BehaviorStandardWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@Update({ "update behavior_standard",
			"set rankType = #{ranktype,jdbcType=TINYINT},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR},",
			"sincerity = #{sincerity,jdbcType=LONGVARCHAR},",
			"save = #{save,jdbcType=LONGVARCHAR},",
			"progress = #{progress,jdbcType=LONGVARCHAR},",
			"service = #{service,jdbcType=LONGVARCHAR},",
			"other = #{other,jdbcType=LONGVARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKeyWithBLOBs(BehaviorStandardWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table behavior_standard
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@Update({ "update behavior_standard",
			"set rankType = #{ranktype,jdbcType=TINYINT},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(BehaviorStandard record);
}