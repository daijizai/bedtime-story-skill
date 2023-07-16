package asia.daijizai.hotlist.service;

import asia.daijizai.hotlist.entity.DiscussPost;

import java.util.List;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/2/5 15:23
 * @description
 */
public interface VideoService {

    DiscussPost gitVideoById(Integer id) throws Exception;

    List<DiscussPost> getHotListFromDB();

    List<DiscussPost> getHotListFromRedis();
    List<DiscussPost> getAll();
}
