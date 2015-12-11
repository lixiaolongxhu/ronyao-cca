package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.EquipmentBear;
import com.ronyao.cca.db.model.EquipmentBearExample;
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

public interface EquipmentBearMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Fri Dec 11 13:17:30 CST 2015
	 */
	@SelectProvider(type = EquipmentBearSqlProvider.class, method = "countByExample")
	int countByExample(EquipmentBearExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Fri Dec 11 13:17:30 CST 2015
	 */
	@DeleteProvider(type = EquipmentBearSqlProvider.class, method = "deleteByExample")
	int deleteByExample(EquipmentBearExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Fri Dec 11 13:17:30 CST 2015
	 */
	@Delete({ "delete from equipment_bear", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Fri Dec 11 13:17:30 CST 2015
	 */
	@Insert({
			"insert into equipment_bear (name, voltageRankId, ",
			"lineType, linePlain, ",
			"lineBrae, explains, ",
			"createTime, updateTime)",
			"values (#{name,jdbcType=VARCHAR}, #{voltagerankid,jdbcType=TINYINT}, ",
			"#{linetype,jdbcType=TINYINT}, #{lineplain,jdbcType=TINYINT}, ",
			"#{linebrae,jdbcType=TINYINT}, #{explains,jdbcType=VARCHAR}, ",
			"#{createtime,jdbcType=VARCHAR}, #{updatetime,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(EquipmentBear record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Fri Dec 11 13:17:30 CST 2015
	 */
	@InsertProvider(type = EquipmentBearSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(EquipmentBear record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Fri Dec 11 13:17:30 CST 2015
	 */
	@SelectProvider(type = EquipmentBearSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "voltageRankId", property = "voltagerankid", jdbcType = JdbcType.TINYINT),
			@Result(column = "lineType", property = "linetype", jdbcType = JdbcType.TINYINT),
			@Result(column = "linePlain", property = "lineplain", jdbcType = JdbcType.TINYINT),
			@Result(column = "lineBrae", property = "linebrae", jdbcType = JdbcType.TINYINT),
			@Result(column = "explains", property = "explains", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<EquipmentBear> selectByExampleWithRowbounds(
			EquipmentBearExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Fri Dec 11 13:17:30 CST 2015
	 */
	@SelectProvider(type = EquipmentBearSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "voltageRankId", property = "voltagerankid", jdbcType = JdbcType.TINYINT),
			@Result(column = "lineType", property = "linetype", jdbcType = JdbcType.TINYINT),
			@Result(column = "linePlain", property = "lineplain", jdbcType = JdbcType.TINYINT),
			@Result(column = "lineBrae", property = "linebrae", jdbcType = JdbcType.TINYINT),
			@Result(column = "explains", property = "explains", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<EquipmentBear> selectByExample(EquipmentBearExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Fri Dec 11 13:17:30 CST 2015
	 */
	@Select({
			"select",
			"id, name, voltageRankId, lineType, linePlain, lineBrae, explains, createTime, ",
			"updateTime", "from equipment_bear",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "voltageRankId", property = "voltagerankid", jdbcType = JdbcType.TINYINT),
			@Result(column = "lineType", property = "linetype", jdbcType = JdbcType.TINYINT),
			@Result(column = "linePlain", property = "lineplain", jdbcType = JdbcType.TINYINT),
			@Result(column = "lineBrae", property = "linebrae", jdbcType = JdbcType.TINYINT),
			@Result(column = "explains", property = "explains", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	EquipmentBear selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Fri Dec 11 13:17:30 CST 2015
	 */
	@UpdateProvider(type = EquipmentBearSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") EquipmentBear record,
			@Param("example") EquipmentBearExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Fri Dec 11 13:17:30 CST 2015
	 */
	@UpdateProvider(type = EquipmentBearSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") EquipmentBear record,
			@Param("example") EquipmentBearExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Fri Dec 11 13:17:30 CST 2015
	 */
	@UpdateProvider(type = EquipmentBearSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(EquipmentBear record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Fri Dec 11 13:17:30 CST 2015
	 */
	@Update({ "update equipment_bear", "set name = #{name,jdbcType=VARCHAR},",
			"voltageRankId = #{voltagerankid,jdbcType=TINYINT},",
			"lineType = #{linetype,jdbcType=TINYINT},",
			"linePlain = #{lineplain,jdbcType=TINYINT},",
			"lineBrae = #{linebrae,jdbcType=TINYINT},",
			"explains = #{explains,jdbcType=VARCHAR},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(EquipmentBear record);
}