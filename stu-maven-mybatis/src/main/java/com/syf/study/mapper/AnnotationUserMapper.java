package com.syf.study.mapper;

import java.util.List;

import java.util.Map;

import javax.swing.text.AbstractDocument.Content;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;

import com.syf.study.bean.MybatisStudent;
import com.syf.study.bean.User;

public interface AnnotationUserMapper {
	@Select("select * from user")
	@Results({//如果返回字段和类属性名不一致，可以通过此方式修改，
			  //如果一致，可改可不改
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name")
		
	})
	List<User> queryAll();
	
	@Insert("INSERT INTO USER ( name, age, birthday, createtime, updatetime, createby, updateby)" + 
			"	VALUES (#{name},#{age}, #{birthday}, #{createTime}, #{updateTime}, #{createBy},#{updateBy})")
	@Options(useGeneratedKeys=true,keyColumn="id" ,keyProperty="id")
	int addUser(User user);
	
	@Update("update USER set name=#{name},age=#{age},birthday=#{birthday},updatetime=now() where id=#{id}")
	int updateUser(User user);
	
	@Delete("delete from  user where id=#{0}")
	int deleteUser(Integer id);
	
	@Select("select ${col} from ${tab} where ${where1} like ${param1}")
	List<User> queryContent(Map<String, String> queryMap);
	
	@Select("select id,name, age, birthday, createtime, updatetime, createby, updateby from user where id=#{id}")
	User queryByPrimaryKey(Integer id);
	
	
	

	@SelectProvider(type=AnnotationUserProvider.class,method="selectWithUserParams")
	List<User> queryWithProvider(User u);

	@SelectProvider(type=AnnotationUserProvider.class,method="queryWithProviderId")
	@Results(
		{
			@Result(id=true,column="id",property="id"),
			@Result(column="name",property="name")
		}
	)
	User queryWithProviderId(@Param("userId")Integer id);
	

	@InsertProvider(type=AnnotationUserProvider.class,method="addWithProvider")
	@Options(useGeneratedKeys=true,keyColumn="id" ,keyProperty="id")
	int addWithProvider(User u);
	
	@InsertProvider(type=AnnotationUserProvider.class,method="addWithProviderMap")
	@Options(useGeneratedKeys=true,keyColumn="id" ,keyProperty="id")
	int addWithProviderMap(Map<String , Object> m);

	@UpdateProvider(type=AnnotationUserProvider.class,method="updateWithProvider")
	int updateWithProvider(User u);
	

	@DeleteProvider(type=AnnotationUserProvider.class,method="delWithProvider")
	int delWithProvider(Integer id);
	
	//一对一联查
	@Select("select * from mybatis_student where id=#{id}")
	@Results({
		@Result(column="create_date",property="createDate"),
		@Result(column="create_by",property="createBy"),
		@Result(column="update_date",property="updateDate"),
		@Result(column="update_by",property="updateBy"),
		@Result(column="idcardid" ,property="mybatisIdcard" ,one=@One(
					select="com.syf.study.mapper.MybatisIdcardMapper.queryById",
					fetchType=FetchType.EAGER
				))
	})
	MybatisStudent queryByOneToMore(Integer id);
	
}
