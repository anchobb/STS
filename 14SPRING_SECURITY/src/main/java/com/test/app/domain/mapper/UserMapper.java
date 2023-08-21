package com.test.app.domain.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.test.app.domain.dto.UserDto;

@Mapper
public interface UserMapper {
	@Insert("insert into tbl_user values (#{username},#{password},#{email},#{role})")
	public int insert(UserDto dto);
	
	@Select("select * from tbl_user where username=#{username}")
	public UserDto selectAt(@Param("username") String username);
	
}
