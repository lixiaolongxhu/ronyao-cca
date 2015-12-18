package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.EnterprisePerson;
import com.ronyao.cca.db.model.EnterprisePersonExample;
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

public interface EnterprisePersonMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@SelectProvider(type = EnterprisePersonSqlProvider.class, method = "countByExample")
	int countByExample(EnterprisePersonExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@DeleteProvider(type = EnterprisePersonSqlProvider.class, method = "deleteByExample")
	int deleteByExample(EnterprisePersonExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@Delete({ "delete from enterprise_person",
			"where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@Insert({
			"insert into enterprise_person (enterpriseId, constructorOne, ",
			"constructorTwo, constructorTotal, ",
			"staffMiddle, staffHigh, ",
			"staffTotal, skillMiddle, ",
			"skillHigh, skillTech, ",
			"skillTechHigh, skillTotal, ",
			"createTime, updateTime)",
			"values (#{enterpriseid,jdbcType=INTEGER}, #{constructorone,jdbcType=TINYINT}, ",
			"#{constructortwo,jdbcType=TINYINT}, #{constructortotal,jdbcType=TINYINT}, ",
			"#{staffmiddle,jdbcType=TINYINT}, #{staffhigh,jdbcType=TINYINT}, ",
			"#{stafftotal,jdbcType=TINYINT}, #{skillmiddle,jdbcType=TINYINT}, ",
			"#{skillhigh,jdbcType=TINYINT}, #{skilltech,jdbcType=TINYINT}, ",
			"#{skilltechhigh,jdbcType=TINYINT}, #{skilltotal,jdbcType=TINYINT}, ",
			"#{createtime,jdbcType=VARCHAR}, #{updatetime,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(EnterprisePerson record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@InsertProvider(type = EnterprisePersonSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(EnterprisePerson record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@SelectProvider(type = EnterprisePersonSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "constructorOne", property = "constructorone", jdbcType = JdbcType.TINYINT),
			@Result(column = "constructorTwo", property = "constructortwo", jdbcType = JdbcType.TINYINT),
			@Result(column = "constructorTotal", property = "constructortotal", jdbcType = JdbcType.TINYINT),
			@Result(column = "staffMiddle", property = "staffmiddle", jdbcType = JdbcType.TINYINT),
			@Result(column = "staffHigh", property = "staffhigh", jdbcType = JdbcType.TINYINT),
			@Result(column = "staffTotal", property = "stafftotal", jdbcType = JdbcType.TINYINT),
			@Result(column = "skillMiddle", property = "skillmiddle", jdbcType = JdbcType.TINYINT),
			@Result(column = "skillHigh", property = "skillhigh", jdbcType = JdbcType.TINYINT),
			@Result(column = "skillTech", property = "skilltech", jdbcType = JdbcType.TINYINT),
			@Result(column = "skillTechHigh", property = "skilltechhigh", jdbcType = JdbcType.TINYINT),
			@Result(column = "skillTotal", property = "skilltotal", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<EnterprisePerson> selectByExampleWithRowbounds(
			EnterprisePersonExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@SelectProvider(type = EnterprisePersonSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "constructorOne", property = "constructorone", jdbcType = JdbcType.TINYINT),
			@Result(column = "constructorTwo", property = "constructortwo", jdbcType = JdbcType.TINYINT),
			@Result(column = "constructorTotal", property = "constructortotal", jdbcType = JdbcType.TINYINT),
			@Result(column = "staffMiddle", property = "staffmiddle", jdbcType = JdbcType.TINYINT),
			@Result(column = "staffHigh", property = "staffhigh", jdbcType = JdbcType.TINYINT),
			@Result(column = "staffTotal", property = "stafftotal", jdbcType = JdbcType.TINYINT),
			@Result(column = "skillMiddle", property = "skillmiddle", jdbcType = JdbcType.TINYINT),
			@Result(column = "skillHigh", property = "skillhigh", jdbcType = JdbcType.TINYINT),
			@Result(column = "skillTech", property = "skilltech", jdbcType = JdbcType.TINYINT),
			@Result(column = "skillTechHigh", property = "skilltechhigh", jdbcType = JdbcType.TINYINT),
			@Result(column = "skillTotal", property = "skilltotal", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	List<EnterprisePerson> selectByExample(EnterprisePersonExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@Select({
			"select",
			"id, enterpriseId, constructorOne, constructorTwo, constructorTotal, staffMiddle, ",
			"staffHigh, staffTotal, skillMiddle, skillHigh, skillTech, skillTechHigh, skillTotal, ",
			"createTime, updateTime", "from enterprise_person",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "enterpriseId", property = "enterpriseid", jdbcType = JdbcType.INTEGER),
			@Result(column = "constructorOne", property = "constructorone", jdbcType = JdbcType.TINYINT),
			@Result(column = "constructorTwo", property = "constructortwo", jdbcType = JdbcType.TINYINT),
			@Result(column = "constructorTotal", property = "constructortotal", jdbcType = JdbcType.TINYINT),
			@Result(column = "staffMiddle", property = "staffmiddle", jdbcType = JdbcType.TINYINT),
			@Result(column = "staffHigh", property = "staffhigh", jdbcType = JdbcType.TINYINT),
			@Result(column = "staffTotal", property = "stafftotal", jdbcType = JdbcType.TINYINT),
			@Result(column = "skillMiddle", property = "skillmiddle", jdbcType = JdbcType.TINYINT),
			@Result(column = "skillHigh", property = "skillhigh", jdbcType = JdbcType.TINYINT),
			@Result(column = "skillTech", property = "skilltech", jdbcType = JdbcType.TINYINT),
			@Result(column = "skillTechHigh", property = "skilltechhigh", jdbcType = JdbcType.TINYINT),
			@Result(column = "skillTotal", property = "skilltotal", jdbcType = JdbcType.TINYINT),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateTime", property = "updatetime", jdbcType = JdbcType.VARCHAR) })
	EnterprisePerson selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@UpdateProvider(type = EnterprisePersonSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") EnterprisePerson record,
			@Param("example") EnterprisePersonExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@UpdateProvider(type = EnterprisePersonSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") EnterprisePerson record,
			@Param("example") EnterprisePersonExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@UpdateProvider(type = EnterprisePersonSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(EnterprisePerson record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	@Update({ "update enterprise_person",
			"set enterpriseId = #{enterpriseid,jdbcType=INTEGER},",
			"constructorOne = #{constructorone,jdbcType=TINYINT},",
			"constructorTwo = #{constructortwo,jdbcType=TINYINT},",
			"constructorTotal = #{constructortotal,jdbcType=TINYINT},",
			"staffMiddle = #{staffmiddle,jdbcType=TINYINT},",
			"staffHigh = #{staffhigh,jdbcType=TINYINT},",
			"staffTotal = #{stafftotal,jdbcType=TINYINT},",
			"skillMiddle = #{skillmiddle,jdbcType=TINYINT},",
			"skillHigh = #{skillhigh,jdbcType=TINYINT},",
			"skillTech = #{skilltech,jdbcType=TINYINT},",
			"skillTechHigh = #{skilltechhigh,jdbcType=TINYINT},",
			"skillTotal = #{skilltotal,jdbcType=TINYINT},",
			"createTime = #{createtime,jdbcType=VARCHAR},",
			"updateTime = #{updatetime,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(EnterprisePerson record);
}