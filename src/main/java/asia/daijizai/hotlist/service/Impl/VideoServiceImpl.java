package asia.daijizai.hotlist.service.Impl;


import asia.daijizai.hotlist.dao.VideoDao;
import asia.daijizai.hotlist.entity.DiscussPost;
import asia.daijizai.hotlist.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/2/5 15:28
 * @description
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public DiscussPost gitVideoById(Integer id) throws Exception {
        if(id==null){
            throw new Exception();
        }

        return videoDao.getById(id);
    }

    @Override
    public List<DiscussPost> getHotListFromDB() {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2022-07-01 15:11:11");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<DiscussPost> hotList = videoDao.get24HotList(date);
        return hotList;

        //return videoDao.getHotList();
    }

    @Override
    public List<DiscussPost> getHotListFromRedis() {
        String key="hotList";
        Set<DiscussPost> set = redisTemplate.opsForSet().members(key);

        return new ArrayList<>(set);
    }

    @Override
    public List<DiscussPost> getAll(){
        return videoDao.get100();
    }
}
