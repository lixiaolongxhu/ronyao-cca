package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.AptitudeRankClassify;
import com.ronyao.cca.db.model.AptitudeRankClassifyExample;
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

public interface AptitudeRankClassifyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptituderank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@SelectProvider(type = AptitudeRankClassifySqlProvider.class, method = "countByExample")
	int countByExample(AptitudeRankClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptituderank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@DeleteProvider(type = AptitudeRankClassifySqlProvider.class, method = "deleteByExample")
	int deleteByExample(AptitudeRankClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptituderank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@Delete({ "delete from aptituderank_classify",
			"where id = #{id,jdbcType=TINYINT}" })
	int deleteByPrimaryKey(Byte id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptituderank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@Insert({ "insert into aptituderank_classify (id, name)",
			"values (#{id,jdbcType=TINYINT}, #{name,jdbcType=VARCHAR})" })
	int insert(AptitudeRankClassify record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptituderank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@InsertProvider(type = AptitudeRankClassifySqlProvider.class, method = "insertSelective")
	int insertSelective(AptitudeRankClassify record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptituderank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@SelectProvider(type = AptitudeRankClassifySqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.TINYINT, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR) })
	List<AptitudeRankClassify> selectByExampleWithRowbounds(
			AptitudeRankClassifyExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptituderank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@SelectProvider(type = AptitudeRankClassifySqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.TINYINT, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR) })
	List<AptitudeRankClassify> selectByExample(
			AptitudeRankClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptituderank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@Select({ "select", "id, name", "from aptituderank_classify",
			"where id = #{id,jdbcType=TINYINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.TINYINT, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR) })
	AptitudeRankClassify selectByPrimaryKey(Byte id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptituderank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@UpdateProvider(type = AptitudeRankClassifySqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") AptitudeRankClassify record,
			@Param("example") AptitudeRankClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptituderank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@UpdateProvider(type = AptitudeRankClassifySqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") AptitudeRankClassify record,
			@Param("example") AptitudeRankClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptituderank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@UpdateProvider(type = AptitudeRankClassifySqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(AptitudeRankClassify record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aptituderank_classify
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	@Update({ "update aptituderank_classify",
			"set name = #{name,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=TINYINT}" })
	int updateByPrimaryKey(AptitudeRankClassify record);
}