package com.test.app.Domain.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.app.Domain.Dto.MemberDto;

@Mapper
public interface MemberMapper {
	
	@Insert("insert into tbl_member values(#{id},#{pw},#{name},#{addr},#{phone},#{role})")
	public int insert(MemberDto dto);
	
	@Update("update tbl_member set pw=#{pw},name=#{name},addr=#{addr},phone=#{phone} where id=#{id}")
	public int update(MemberDto dto);
	
	@Delete("delete from tbl_member where id=#{id}")
	public String delete(String id);
	
	@Select("select * from tbl_member")
	public List<MemberDto> membersearchAll();
	
	@Select("select * from tbl_member where=#{id}")
	public MemberDto selectAt(String id);
	
}
