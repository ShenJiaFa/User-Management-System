package com.shenjiafa.mapper;

import com.shenjiafa.model.UserLogin;
import org.apache.ibatis.annotations.Param;

public interface UserLoginMapper {
    UserLogin queryUserLogin(@Param("userName") String userName, @Param("password") String password);
}
