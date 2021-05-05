package cn.itcast.dao;

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ShiWei
 * @date 2021/4/26 - 19:59
 *
 * 账户dao接口
 */
@Repository
public interface AccountDao {

    /**
     * 查询所有账户
     * @return
     */
    @Select("select * from account")
    public List<Account> findAll();

    /**
     * 保存账户信息
     * @param account
     */
    @Insert("insert into account (name, money) values (#{name}, #{money})")
    //#{}表示从acount(对象)中取值
    public void saveAccount(Account account);
}
