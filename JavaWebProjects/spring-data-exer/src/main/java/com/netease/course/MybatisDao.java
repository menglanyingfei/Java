package com.netease.course;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author menglanyingfei
 * @date 2017-8-27
 */

public interface MybatisDao {
	@Update("UPDATE UserBalance SET balance=balance+#{param2} WHERE userId=#{param1} ")
    public void addMoney(Long userId,double count);

    @Update("UPDATE UserBalance SET balance=balance-#{param2} WHERE userId=#{param1} ")
    public void subMoney(Long userId,double count);

    @Select("SELECT * FROM UserBalance")
    public List<UserBalance> findAll();
}
