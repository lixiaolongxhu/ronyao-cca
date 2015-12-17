package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.ProjectPlain;
import com.ronyao.cca.db.model.ProjectPlainExample;
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

public interface ProjectPlainMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_plain
	 * @mbggenerated  Thu Dec 17 15:44:44 CST 2015
	 */
	@SelectProvider(type = ProjectPlainSqlProvider.class, method = "countByExample")
	int countByExample(ProjectPlainExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_plain
	 * @mbggenerated  Thu Dec 17 15:44:44 CST 2015
	 */
	@DeleteProvider(type = ProjectPlainSqlProvider.class, method = "deleteByExample")
	int deleteByExample(ProjectPlainExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_plain
	 * @mbggenerated  Thu Dec 17 15:44:44 CST 2015
	 */
	@Delete({ "delete from project_plain", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_plain
	 * @mbggenerated  Thu Dec 17 15:44:44 CST 2015
	 */
	@Insert({
			"insert into project_plain (voltageRankClassifyId, year, ",
			"projectNum, lineProject, ",
			"powerProject, assessLineProject, ",
			"assessPowerProject, length, ",
			"volume, investment, ",
			"createTime, updateTime)",
			"values (#{voltagerankclassifyid,jdbcType=INTEGER}, #{year,jdbcType=INTEGER}, ",
			"#{projectnum,jdbcType=INTEGER}, #{lineproject,jdbcType=INTEGER}, ",
			"#{powerproject,jdbcType=INTEGER}, #{assesslineproject,jdbcType=INTEGER}, ",
			"#{assesspowerproject,jdbcType=INTEGER}, #{length,jdbcType=INTEGER}, ",
			"#{volume,jdbcType=INTEGER}, #{investment,jdbcType=DECIMAL}, ",
			"#{createtime,jdbcType=VARCHAR}, #{updatetime,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(ProjectPlain record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_plain
	 * @mbggenerated  Thu Dec 17 15:44:44 CST 2015
	 */
	@InsertProvider(type = ProjectPlainSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(ProjectPlain record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_plain
	 * @mbggenerated  Thu Dec 17 15:44:44 CST 2015
	 */
	@SelectProvider(type = ProjectPlainSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "voltageRankClassifyId", property = "voltagerankclassifyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "year", property = "year", jdbcType = JdbcType.INTEGER),
			@Result(column = "projectNum", property = "projectnum", jdbcType = JdbcType.INTEGER),
			@Result(column = "lineProject", property = "lineproject", jdbcType = JdbcType.INTEGER),
			@Result(column = "powerProject", property = "powerproject", jdbcType = JdbcType.INTEGER),
			@Result(column = "assessLineProject", property = "assesslineproject", jdbcType = JdbcType.INTEGER),
			@Result(column = "assessPowerProject", property = "assesspowerproject", jdbcType = JdbcType.INTEGER),
			@Result(column = "length", property = "length", jdbcType = JdbcType.INTEGER),
			@Result(column = "volume", property = "volume", jdbcType = JdbcType.INTEGER),
			@Result(column = "investment", property = "investment", jdbcType = JdbcType.DECIMAL),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<ProjectPlain> selectByExampleWithRowbounds(
			ProjectPlainExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_plain
	 * @mbggenerated  Thu Dec 17 15:44:44 CST 2015
	 */
	@SelectProvider(type = ProjectPlainSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "voltageRankClassifyId", property = "voltagerankclassifyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "year", property = "year", jdbcType = JdbcType.INTEGER),
			@Result(column = "projectNum", property = "projectnum", jdbcType = JdbcType.INTEGER),
			@Result(column = "lineProject", property = "lineproject", jdbcType = JdbcType.INTEGER),
			@Result(column = "powerProject", property = "powerproject", jdbcType = JdbcType.INTEGER),
			@Result(column = "assessLineProject", property = "assesslineproject", jdbcType = JdbcType.INTEGER),
			@Result(column = "assessPowerProject", property = "assesspowerproject", jdbcType = JdbcType.INTEGER),
			@Result(column = "length", property = "length", jdbcType = JdbcType.INTEGER),
			@Result(column = "volume", property = "volume", jdbcType = JdbcType.INTEGER),
			@Result(column = "investment", property = "investment", jdbcType = JdbcType.DECIMAL),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<ProjectPlain> selectByExample(ProjectPlainExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_plain
	 * @mbggenerated  Thu Dec 17 15:44:44 CST 2015
	 */
	@Select({
			"select",
			"id, voltageRankClassifyId, year, projectNum, lineProject, powerProject, assessLineProject, ",
			"assessPowerProject, length, volume, investment, createTime, updateTime",
			"from project_plain", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "voltageRankClassifyId", property = "voltagerankclassifyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "year", property = "year", jdbcType = JdbcType.INTEGER),
			@Result(column = "projectNum", property = "projectnum", jdbcType = JdbcType.INTEGER),
			@Result(column = "lineProject", property = "lineproject", jdbcType = JdbcType.INTEGER),
			@Result(column = "powerProject", property = "powerproject", jdbcType = JdbcType.INTEGER),
			@Result(column = "assessLineProject", property = "assesslineproject", jdbcType = JdbcType.INTEGER),
			@Result(column = "assessPowerProject", property = "assesspowerproject", jdbcType = JdbcType.INTEGER),
			@Result(column = "length", property = "length", jdbcType = JdbcType.INTEGER),
			@Result(column = "volume", property = "volume", jdbcType = JdbcType.INTEGER),
			@Result(column = "investment", property = "investment", jdbcType = JdbcType.DECIMAL),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	ProjectPlain selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_plain
	 * @mbggenerated  Thu Dec 17 15:44:44 CST 2015
	 */
	@UpdateProvider(type = ProjectPlainSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") ProjectPlain record,
			@Param("example") ProjectPlainExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_plain
	 * @mbggenerated  Thu Dec 17 15:44:44 CST 2015
	 */
	@UpdateProvider(type = ProjectPlainSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") ProjectPlain record,
			@Param("example") ProjectPlainExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_plain
	 * @mbggenerated  Thu Dec 17 15:44:44 CST 2015
	 */
	@UpdateProvider(type = ProjectPlainSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(ProjectPlain record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_plain
	 * @mbggenerated  Thu Dec 17 15:44:44 CST 2015
	 */
	@Update({
			"update project_plain",
			"set voltageRankClassifyId = #{voltagerankclassifyid,jdbcType=INTEGER},",
			"year = #{year,jdbcType=INTEGER},",
			"projectNum = #{projectnum,jdbcType=INTEGER},",
			"lineProject = #{lineproject,jdbcType=INTEGER},",
			"powerProject = #{powerproject,jdbcType=INTEGER},",
			"assessLineProject = #{assesslineproject,jdbcType=INTEGER},",
			"assessPowerProject = #{assesspowerproject,jdbcType=INTEGER},",
			"length = #{length,jdbcType=INTEGER},",
			"volume = #{volume,jdbcType=INTEGER},",
			"investment = #{investment,jdbcType=DECIMAL},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(ProjectPlain record);
}