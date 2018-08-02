package com.ngb.project.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.ngb.project.demo.vo.UserDetailVO;

@Component
@Mapper
public abstract interface IUserDao {
	@Select({ "SELECT * FROM USER_DETAIL " })
	@Results({ @org.apache.ibatis.annotations.Result(id = true, column = "UD_USER_ID", property = "userID"),
			@org.apache.ibatis.annotations.Result(column = "UD_USER_NAME", property = "userName"),
			@org.apache.ibatis.annotations.Result(column = "UD_USER_LOGIN_NAME", property = "userLoginName"),
			@org.apache.ibatis.annotations.Result(column = "UD_USER_LOGIN_PASSWORD", property = "userLoginPassword"),
			@org.apache.ibatis.annotations.Result(column = "UD_USER_STATUS", property = "userStatus"),
			@org.apache.ibatis.annotations.Result(column = "UD_USER_LOGIN_STATUS", property = "userLoginStatus"),
			@org.apache.ibatis.annotations.Result(column = "UD_USER_PURVIEW", property = "userPurView") })
	public abstract List<UserDetailVO> findAll();
	
	@Select({ "SELECT * FROM USER_DETAIL WHERE UD_USER_ID = #{0}" })
	@Results({ @org.apache.ibatis.annotations.Result(id = true, column = "UD_USER_ID", property = "userID"),
		@org.apache.ibatis.annotations.Result(column = "UD_USER_NAME", property = "userName"),
		@org.apache.ibatis.annotations.Result(column = "UD_USER_LOGIN_NAME", property = "userLoginName"),
		@org.apache.ibatis.annotations.Result(column = "UD_USER_LOGIN_PASSWORD", property = "userLoginPassword"),
		@org.apache.ibatis.annotations.Result(column = "UD_USER_STATUS", property = "userStatus"),
		@org.apache.ibatis.annotations.Result(column = "UD_USER_LOGIN_STATUS", property = "userLoginStatus"),
		@org.apache.ibatis.annotations.Result(column = "UD_USER_PURVIEW", property = "userPurView") })
	public abstract UserDetailVO findByID(String id);

	@Select({ "SELECT * FROM USER_DETAIL WHERE UD_USER_LOGIN_NAME=#{name} AND UD_USER_LOGIN_PASSWORD=#{password}" })
	@Results({ @org.apache.ibatis.annotations.Result(id = true, column = "UD_USER_ID", property = "userID"),
			@org.apache.ibatis.annotations.Result(column = "UD_USER_NAME", property = "userName"),
			@org.apache.ibatis.annotations.Result(column = "UD_USER_LOGIN_NAME", property = "userLoginName"),
			@org.apache.ibatis.annotations.Result(column = "UD_USER_LOGIN_PASSWORD", property = "userLoginPassword"),
			@org.apache.ibatis.annotations.Result(column = "UD_USER_STATUS", property = "userStatus"),
			@org.apache.ibatis.annotations.Result(column = "UD_USER_LOGIN_STATUS", property = "userLoginStatus"),
			@org.apache.ibatis.annotations.Result(column = "UD_USER_PURVIEW", property = "userPurView") })
	public abstract UserDetailVO checkLogin(@Param("name") String paramString1, @Param("password") String paramString2);
	
	@Insert({"INSERT INTO USER_DETAIL ",
				"(UD_USER_NAME,",
				"UD_USER_LOGIN_NAME,",
				"UD_USER_LOGIN_PASSWORD)",
				"VALUES",
				"(#{vo.userName},",
				"#{vo.userLoginName},",
				"#{vo.userLoginPassword})"
	})
	@Options(useGeneratedKeys = true, keyProperty = "vo.userID")
	public abstract int insert(@Param("vo") UserDetailVO vo);
	
	@Update({"<script>",
				"UPDATE USER_DETAIL SET ",
				"UD_USER_NAME=#{vo.userName},",
				"UD_USER_LOGIN_NAME=#{vo.userLoginPassword},",
				"UD_USER_LOGIN_PASSWORD=#{vo.userLoginPassword}",
				"<if test=\"vo.userStatus!=null and vo.userStatus != '' \">",
					",UD_USER_STATUS=#{vo.userStatus}",
				"</if>",
				"<if test=\"vo.userLoginStatus!=null and vo.userLoginStatus != '' \">",
					",UD_USER_LOGIN_STATUS=#{vo.userLoginStatus}",
				"</if>",
				"<if test=\"vo.userPurView!=null and vo.userPurView != '' \">",
					",UD_USER_PURVIEW=#{vo.userPurView}",
				"</if>",
				" WHERE UD_USER_ID=#{vo.userID}",
			"</script>"
	})
	@Options(useGeneratedKeys = true, keyProperty = "vo.userID")
	public abstract int update(@Param("vo") UserDetailVO vo);
	
	@Delete({
		"<script>",
			"DELETE FROM USER_DETAIL WHERE UD_USER_ID in (",
				"<foreach collection='ids' item='id' separator=','>",
				"#{id}",
				"</foreach>",
			")",
		"</script>"
	})
	public abstract int remove(@Param("ids") List<String> ids);
	
	
}