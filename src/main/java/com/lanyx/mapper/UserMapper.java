package com.lanyx.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanyx.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 86186
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-11-21 20:14:02
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




