package asia.daijizai.hotlist.dao;


import asia.daijizai.hotlist.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/2/5 15:29
 * @description
 */
@Mapper
public interface VideoDao {

    @Select("SELECT * from discuss_post ORDER BY score desc LIMIT 20;")
    List<DiscussPost> getHotList();

    @Select("SELECT * from discuss_post where create_time > #{createTime} ORDER BY score desc LIMIT 20;")
    List<DiscussPost> get24HotList(@Param("createTime") Date createTime);

    @Select("SELECT * from discuss_post limit 100;")
    List<DiscussPost> get100();

    @Select("SELECT * from discuss_post;")
    List<DiscussPost> getAll();

    @Select("select * from discuss_post where id = #{id}")
    DiscussPost getById(@Param("id") int id);

    @Update("update discuss_post set status = #{status} where id = #{id}")
    int updateStatus(@Param("id") int id, @Param("status") int status);

}
