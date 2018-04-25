package com.zhan.app.nearby.mapper;

import com.zhan.app.nearby.entity.User;
import com.zhan.app.nearby.enums.UserGender;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zah on 2017/12/20.
 */
public interface UserDao {
    @Select("SELECT * FROM t_user")
    @Results({@Result(property = "gender", column = "gender", javaType = UserGender.class)})
    List<User> getAll();

    @Select("SELECT * FROM t_user WHERE id = #{id}")
    User getOne(Long id);

    @Insert("INSERT INTO t_user(name,password,nickname,gender) VALUES(#{name}, #{password}, #{nickname},#{gender})")
    void insert(User user);

    @Update("UPDATE t_user SET name=#{name},nickname=#{nickname} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM t_user WHERE id =#{id}")
    void delete(Long id);
}