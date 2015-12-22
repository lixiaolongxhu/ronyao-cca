package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.VoltageRankClassify;
import com.ronyao.cca.db.model.VoltageRankClassifyExample;
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

public interface VoltageRankClassifyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table voltage_rank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@SelectProvider(type = VoltageRankClassifySqlProvider.class, method = "countByExample")
	int countByExample(VoltageRankClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table voltage_rank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@DeleteProvider(type = VoltageRankClassifySqlProvider.class, method = "deleteByExample")
	int deleteByExample(VoltageRankClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table voltage_rank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@Delete({ "delete from voltage_rank_classify",
			"where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table voltage_rank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@Insert({ "insert into voltage_rank_classify (id, name, ",
			"value, bigEquipment)",
			"values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
			"#{value,jdbcType=INTEGER}, #{bigequipment,jdbcType=INTEGER})" })
	int insert(VoltageRankClassify record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table voltage_rank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@InsertProvider(type = VoltageRankClassifySqlProvider.class, method = "insertSelective")
	int insertSelective(VoltageRankClassify record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table voltage_rank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@SelectProvider(type = VoltageRankClassifySqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "value", property = "value", jdbcType = JdbcType.INTEGER),
			@Result(column = "bigEquipment", property = "bigequipment", jdbcType = JdbcType.INTEGER) })
	List<VoltageRankClassify> selectByExampleWithRowbounds(
			VoltageRankClassifyExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table voltage_rank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@SelectProvider(type = VoltageRankClassifySqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "value", property = "value", jdbcType = JdbcType.INTEGER),
			@Result(column = "bigEquipment", property = "bigequipment", jdbcType = JdbcType.INTEGER) })
	List<VoltageRankClassify> selectByExample(VoltageRankClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table voltage_rank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@Select({ "select", "id, name, value, bigEquipment",
			"from voltage_rank_classify", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "value", property = "value", jdbcType = JdbcType.INTEGER),
			@Result(column = "bigEquipment", property = "bigequipment", jdbcType = JdbcType.INTEGER) })
	VoltageRankClassify selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table voltage_rank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@UpdateProvider(type = VoltageRankClassifySqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") VoltageRankClassify record,
			@Param("example") VoltageRankClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table voltage_rank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@UpdateProvider(type = VoltageRankClassifySqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") VoltageRankClassify record,
			@Param("example") VoltageRankClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table voltage_rank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@UpdateProvider(type = VoltageRankClassifySqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(VoltageRankClassify record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table voltage_rank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@Update({ "update voltage_rank_classify",
			"set name = #{name,jdbcType=VARCHAR},",
			"value = #{value,jdbcType=INTEGER},",
			"bigEquipment = #{bigequipment,jdbcType=INTEGER}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(VoltageRankClassify record);
}