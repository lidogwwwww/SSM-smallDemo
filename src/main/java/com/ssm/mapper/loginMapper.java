package com.ssm.mapper;

import com.ssm.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author dog-king
 * @create 2022/5/18
 */
@Repository
public interface loginMapper {
    /**
     * 登录信息验证
     * @param user
     * @return
     */
    public int Login(@Param("user") User user);
}
