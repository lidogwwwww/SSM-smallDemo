package com.ssm.mapper;

import com.ssm.bean.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dog-king
 * @create 2022/5/17
 */
@Repository
public interface accountMapper {
    /**
     * 查询所有账户信息
     * @return
     */

    List<Account> getAllAccount();

    /**
     * 添加账户信息
     * @param account
     * @return
     */
    void addAccount(@Param("account") Account account);

    /**
     * 删除账户
     * @param id
     */
    void deleteAccount(@Param("id") Integer id);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(@Param("account") Account account);
}
