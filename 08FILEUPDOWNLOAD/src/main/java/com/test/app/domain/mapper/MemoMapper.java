package com.test.app.domain.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.test.app.domain.dto.MemoDto;

@Mapper
public interface MemoMapper {
	
	@SelectKey(statement = "select max(id)+1 from tbl_memo", keyProperty = "id", before = false, resultType = int.class)
	@Insert("insert into tbl_memo values (#{id},#{text})")
	public int insert(MemoDto dto);
	
	@Update("update tbl_memo set text = #{text} where id = #{id}")
	public int update(MemoDto dto);
	
	@Delete("delete from tbl_memo where id = #{id}")
	public int delete(int id);
	
	@Select("select * from tbl_memo where id=#{id}")
	public MemoDto selectAt(int id);
	
	@Select("select * from tbl_memo")
	public List<MemoDto> selectAll();
	
	@Results(id="MemoResultMap", value={
			@Result(property="id", column="id"),
			@Result(property="text", column="text")
	})
	@Select("select * from tbl_memo")
	public List<Map<String, Object>> selectAllResultMap();
	
}
