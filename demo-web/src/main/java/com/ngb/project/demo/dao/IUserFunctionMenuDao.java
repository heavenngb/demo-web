package com.ngb.project.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.ngb.project.demo.vo.UserFunctionMenuVO;

@Component
@Mapper
public abstract interface IUserFunctionMenuDao {
	@Select({ "SELECT * FROM USER_FUNCTION_MENU WHERE UFM_PID IS NULL" })
	@Results({ @org.apache.ibatis.annotations.Result(id = true, column = "UFM_ID", property = "ufmID"),
			@org.apache.ibatis.annotations.Result(column = "UFM_PID", property = "ufmPID"),
			@org.apache.ibatis.annotations.Result(column = "UFM_URL", property = "ufmURL"),
			@org.apache.ibatis.annotations.Result(column = "UFM_DETAIL", property = "ufmDetail"),
			@org.apache.ibatis.annotations.Result(id = true, column = "UFM_ID", property = "id"),
			@org.apache.ibatis.annotations.Result(column = "UFM_DETAIL", property = "text") })
	public abstract List<UserFunctionMenuVO> findAll();

	@Select({ "SELECT * FROM USER_FUNCTION_MENU WHERE UFM_ID = #{id}" })
	@Results({ @org.apache.ibatis.annotations.Result(id = true, column = "UFM_ID", property = "ufmID"),
			@org.apache.ibatis.annotations.Result(column = "UFM_PID", property = "ufmPID"),
			@org.apache.ibatis.annotations.Result(column = "UFM_URL", property = "ufmURL"),
			@org.apache.ibatis.annotations.Result(column = "UFM_DETAIL", property = "ufmDetail"),
			@org.apache.ibatis.annotations.Result(id = true, column = "UFM_ID", property = "id"),
			@org.apache.ibatis.annotations.Result(column = "UFM_DETAIL", property = "text") })
	public abstract UserFunctionMenuVO findByID(@Param("id") String paramString);

	@Select({ "SELECT * FROM USER_FUNCTION_MENU WHERE UFM_PID = #{pid}" })
	@Results({ @org.apache.ibatis.annotations.Result(id = true, column = "UFM_ID", property = "ufmID"),
			@org.apache.ibatis.annotations.Result(column = "UFM_PID", property = "ufmPID"),
			@org.apache.ibatis.annotations.Result(column = "UFM_URL", property = "ufmURL"),
			@org.apache.ibatis.annotations.Result(column = "UFM_DETAIL", property = "ufmDetail"),
			@org.apache.ibatis.annotations.Result(id = true, column = "UFM_ID", property = "id"),
			@org.apache.ibatis.annotations.Result(column = "UFM_DETAIL", property = "text") })
	public abstract List<UserFunctionMenuVO> findByPID(@Param("pid") String paramString);
	
	@Insert({"<script>",
		"INSERT INTO USER_FUNCTION_MENU ",
		"(",
		"<if test=\"vo.ufmPID!=null and vo.ufmPID != '' \">",
			"UFM_PID,",
		"</if>",
		"UFM_URL,",
		"UFM_DETAIL)",
		"VALUES",
		"(",
		"<if test=\"vo.ufmPID!=null and vo.ufmPID != '' \">",
			"#{vo.ufmPID},",
		"</if>",
		"#{vo.ufmURL},",
		"#{vo.ufmDetail})",
		"</script>"
	})
	@Options(useGeneratedKeys = true, keyProperty = "vo.ufmID")
	public abstract int insert(@Param("vo") UserFunctionMenuVO vo);
	
	@Delete({
		"<script>",
			"DELETE FROM USER_FUNCTION_MENU WHERE UFM_ID in (",
				"<foreach collection='ids' item='id' separator=','>",
				"#{id}",
				"</foreach>",
			")",
		"</script>"
	})
	public abstract int remove(@Param("ids") String ...ids);
}