package com.ronyao.cca.db.dao;

import com.ronyao.cca.db.model.PostClassify;
import com.ronyao.cca.db.model.PostClassifyExample;
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

public interface PostClassifyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post_classify
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	@SelectProvider(type = PostClassifySqlProvider.class, method = "countByExample")
	int countByExample(PostClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post_classify
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	@DeleteProvider(type = PostClassifySqlProvider.class, method = "deleteByExample")
	int deleteByExample(PostClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post_classify
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	@Delete({ "delete from post_classify", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post_classify
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	@Insert({ "insert into post_classify (id, name)",
			"values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})" })
	int insert(PostClassify record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post_classify
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	@InsertProvider(type = PostClassifySqlProvider.class, method = "insertSelective")
	int insertSelective(PostClassify record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post_classify
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	@SelectProvider(type = PostClassifySqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR) })
	List<PostClassify> selectByExampleWithRowbounds(
			PostClassifyExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post_classify
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	@SelectProvider(type = PostClassifySqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR) })
	List<PostClassify> selectByExample(PostClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post_classify
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	@Select({ "select", "id, name", "from post_classify",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR) })
	PostClassify selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post_classify
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	@UpdateProvider(type = PostClassifySqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") PostClassify record,
			@Param("example") PostClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post_classify
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	@UpdateProvider(type = PostClassifySqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") PostClassify record,
			@Param("example") PostClassifyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post_classify
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	@UpdateProvider(type = PostClassifySqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(PostClassify record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table post_classify
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	@Update({ "update post_classify", "set name = #{name,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(PostClassify record);
}