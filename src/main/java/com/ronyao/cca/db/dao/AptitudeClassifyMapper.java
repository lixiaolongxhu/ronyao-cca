package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.AptitudeClassify;
import com.ronyao.cca.db.model.AptitudeClassifyExample;
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

public interface AptitudeClassifyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptitude_classify
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	@SelectProvider(type = AptitudeClassifySqlProvider.class, method = "countByExample")
	int countByExample(AptitudeClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptitude_classify
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	@DeleteProvider(type = AptitudeClassifySqlProvider.class, method = "deleteByExample")
	int deleteByExample(AptitudeClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptitude_classify
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	@Delete({ "delete from aptitude_classify",
			"where id = #{id,jdbcType=TINYINT}" })
	int deleteByPrimaryKey(Byte id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptitude_classify
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	@Insert({ "insert into aptitude_classify (id, name)",
			"values (#{id,jdbcType=TINYINT}, #{name,jdbcType=VARCHAR})" })
	int insert(AptitudeClassify record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptitude_classify
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	@InsertProvider(type = AptitudeClassifySqlProvider.class, method = "insertSelective")
	int insertSelective(AptitudeClassify record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptitude_classify
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	@SelectProvider(type = AptitudeClassifySqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.TINYINT, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR) })
	List<AptitudeClassify> selectByExampleWithRowbounds(
			AptitudeClassifyExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptitude_classify
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	@SelectProvider(type = AptitudeClassifySqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.TINYINT, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR) })
	List<AptitudeClassify> selectByExample(AptitudeClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptitude_classify
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	@Select({ "select", "id, name", "from aptitude_classify",
			"where id = #{id,jdbcType=TINYINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.TINYINT, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR) })
	AptitudeClassify selectByPrimaryKey(Byte id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptitude_classify
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	@UpdateProvider(type = AptitudeClassifySqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") AptitudeClassify record,
			@Param("example") AptitudeClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptitude_classify
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	@UpdateProvider(type = AptitudeClassifySqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") AptitudeClassify record,
			@Param("example") AptitudeClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptitude_classify
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	@UpdateProvider(type = AptitudeClassifySqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(AptitudeClassify record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptitude_classify
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	@Update({ "update aptitude_classify",
			"set name = #{name,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=TINYINT}" })
	int updateByPrimaryKey(AptitudeClassify record);
}