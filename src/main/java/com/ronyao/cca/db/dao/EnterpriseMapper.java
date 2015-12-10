package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.Enterprise;
import com.ronyao.cca.db.model.EnterpriseExample;
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

public interface EnterpriseMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Thu Dec 10 14:41:03 CST 2015
	 */
	@SelectProvider(type = EnterpriseSqlProvider.class, method = "countByExample")
	int countByExample(EnterpriseExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Thu Dec 10 14:41:03 CST 2015
	 */
	@DeleteProvider(type = EnterpriseSqlProvider.class, method = "deleteByExample")
	int deleteByExample(EnterpriseExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Thu Dec 10 14:41:03 CST 2015
	 */
	@Delete({ "delete from enterprise", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Thu Dec 10 14:41:03 CST 2015
	 */
	@Insert({
			"insert into enterprise (supervisorUnit, name, ",
			"fullName, property, ",
			"register, assets, ",
			"workers, overallRank, ",
			"professionRank, output, ",
			"project, createTime, ",
			"updateTime)",
			"values (#{supervisorunit,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
			"#{fullname,jdbcType=VARCHAR}, #{property,jdbcType=TINYINT}, ",
			"#{register,jdbcType=INTEGER}, #{assets,jdbcType=INTEGER}, ",
			"#{workers,jdbcType=INTEGER}, #{overallrank,jdbcType=TINYINT}, ",
			"#{professionrank,jdbcType=TINYINT}, #{output,jdbcType=INTEGER}, ",
			"#{project,jdbcType=TINYINT}, #{createtime,jdbcType=VARCHAR}, ",
			"#{updatetime,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(Enterprise record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Thu Dec 10 14:41:03 CST 2015
	 */
	@InsertProvider(type = EnterpriseSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(Enterprise record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Thu Dec 10 14:41:03 CST 2015
	 */
	@SelectProvider(type = EnterpriseSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "supervisorUnit", property = "supervisorunit", jdbcType = JdbcType.VARCHAR),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "fullName", property = "fullname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "property", property = "property", jdbcType = JdbcType.TINYINT),
			@Result(column = "register", property = "register", jdbcType = JdbcType.INTEGER),
			@Result(column = "assets", property = "assets", jdbcType = JdbcType.INTEGER),
			@Result(column = "workers", property = "workers", jdbcType = JdbcType.INTEGER),
			@Result(column = "overallRank", property = "overallrank", jdbcType = JdbcType.TINYINT),
			@Result(column = "professionRank", property = "professionrank", jdbcType = JdbcType.TINYINT),
			@Result(column = "output", property = "output", jdbcType = JdbcType.INTEGER),
			@Result(column = "project", property = "project", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<Enterprise> selectByExampleWithRowbounds(EnterpriseExample example,
			RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Thu Dec 10 14:41:03 CST 2015
	 */
	@SelectProvider(type = EnterpriseSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "supervisorUnit", property = "supervisorunit", jdbcType = JdbcType.VARCHAR),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "fullName", property = "fullname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "property", property = "property", jdbcType = JdbcType.TINYINT),
			@Result(column = "register", property = "register", jdbcType = JdbcType.INTEGER),
			@Result(column = "assets", property = "assets", jdbcType = JdbcType.INTEGER),
			@Result(column = "workers", property = "workers", jdbcType = JdbcType.INTEGER),
			@Result(column = "overallRank", property = "overallrank", jdbcType = JdbcType.TINYINT),
			@Result(column = "professionRank", property = "professionrank", jdbcType = JdbcType.TINYINT),
			@Result(column = "output", property = "output", jdbcType = JdbcType.INTEGER),
			@Result(column = "project", property = "project", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<Enterprise> selectByExample(EnterpriseExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Thu Dec 10 14:41:03 CST 2015
	 */
	@Select({
			"select",
			"id, supervisorUnit, name, fullName, property, register, assets, workers, overallRank, ",
			"professionRank, output, project, createTime, updateTime",
			"from enterprise", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "supervisorUnit", property = "supervisorunit", jdbcType = JdbcType.VARCHAR),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "fullName", property = "fullname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "property", property = "property", jdbcType = JdbcType.TINYINT),
			@Result(column = "register", property = "register", jdbcType = JdbcType.INTEGER),
			@Result(column = "assets", property = "assets", jdbcType = JdbcType.INTEGER),
			@Result(column = "workers", property = "workers", jdbcType = JdbcType.INTEGER),
			@Result(column = "overallRank", property = "overallrank", jdbcType = JdbcType.TINYINT),
			@Result(column = "professionRank", property = "professionrank", jdbcType = JdbcType.TINYINT),
			@Result(column = "output", property = "output", jdbcType = JdbcType.INTEGER),
			@Result(column = "project", property = "project", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	Enterprise selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Thu Dec 10 14:41:03 CST 2015
	 */
	@UpdateProvider(type = EnterpriseSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Enterprise record,
			@Param("example") EnterpriseExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Thu Dec 10 14:41:03 CST 2015
	 */
	@UpdateProvider(type = EnterpriseSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Enterprise record,
			@Param("example") EnterpriseExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Thu Dec 10 14:41:03 CST 2015
	 */
	@UpdateProvider(type = EnterpriseSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Enterprise record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise
	 * @mbggenerated  Thu Dec 10 14:41:03 CST 2015
	 */
	@Update({ "update enterprise",
			"set supervisorUnit = #{supervisorunit,jdbcType=VARCHAR},",
			"name = #{name,jdbcType=VARCHAR},",
			"fullName = #{fullname,jdbcType=VARCHAR},",
			"property = #{property,jdbcType=TINYINT},",
			"register = #{register,jdbcType=INTEGER},",
			"assets = #{assets,jdbcType=INTEGER},",
			"workers = #{workers,jdbcType=INTEGER},",
			"overallRank = #{overallrank,jdbcType=TINYINT},",
			"professionRank = #{professionrank,jdbcType=TINYINT},",
			"output = #{output,jdbcType=INTEGER},",
			"project = #{project,jdbcType=TINYINT},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Enterprise record);
}