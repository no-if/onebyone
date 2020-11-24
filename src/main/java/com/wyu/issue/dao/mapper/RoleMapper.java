package com.wyu.issue.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wyu.issue.pojo.Role;
import com.wyu.issue.pojo.User;

@Mapper
public interface RoleMapper {

	@Select("select ROLE_NAME FROM role WHERE LOGIN_ID=#{LOGIN_ID}")
	public Role getRole(String loginId);

	// 插入角色信息
	@Insert("insert into role (LOGIN_ID,ROLE_NAME,ROLE_DESCRIPTION,CREATED_TIME) VALUES (#{loginId},'普通用户','一般货色',NOW())")
	void saveRole(String loginId);

	// 在角色表，更新用户角色信息
	@Update("update role set ROLE_NAME='经理',ROLE_DESCRIPTION='高级货',UPDATED_TIME=now() WHERE LOGIN_ID=#{loginId} ")
	void updateRoleName(User user);
}
