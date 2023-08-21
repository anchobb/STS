package com.test.app;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.app.domain.dto.MemoDto;
import com.test.app.domain.mapper.MemoMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MybatisConfigTest {

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void test() {
		System.out.println("sqlSessionFactory : "+sqlSessionFactory);
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println("SqlSession :" +session);
		Connection conn = session.getConnection();
		System.out.println("Connection : " + conn);
	}
	
	@Autowired
	MemoMapper memoMapper;
	
	@Test
	 public void test2() { System.out.println("memoMapper : "+memoMapper);
	 
	 memoMapper.insert(new MemoDto(10, "HAHAHAHA")); 
	 }
	
	@Test
	public void test3() {
		memoMapper.update(new MemoDto(1,"ggggg"));
	}
	
	@Test
	public void test4() {
		memoMapper.delete(2);
	}

	@Test
	public void test5() {
		MemoDto dto = memoMapper.selectAt(3);
		System.out.println("SelectAt dto : " + dto);
	}
	
	@Test
	public void test6() {
		List<MemoDto> list = memoMapper.selectAll();
		list.forEach((dto)->{System.out.println(dto);});
	}

	@Test
	public void test7() {
		System.out.println("memoMapper : "+memoMapper);
		List< Map<String,Object> > list = memoMapper.selectAllResultMap();
		
		list.forEach((map)->{
//			System.out.println(map);
			for(String key : map.keySet()) {
				System.out.println(key + " : "+map.get(key));
			}
		});
	}
	
	@Test
	public void test8() {
		System.out.println("memoMapper : "+memoMapper);
		MemoDto dto = new MemoDto(16,"AAAAA");
		int cnt = memoMapper.insert(dto);
		System.out.println("증가된 행의 수는 : " + cnt);
		System.out.println("다음 Id 값 : " + dto.getId());
		
	}
	
	
}
