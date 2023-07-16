package asia.daijizai.hotlist.controller;


import asia.daijizai.hotlist.entity.DiscussPost;
import asia.daijizai.hotlist.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/2/5 15:16
 * @description
 */

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping(value = "/100")
    public List<DiscussPost> getAll(){

        return videoService.getAll();
    }

    @GetMapping(value = "/hot/db")
    public List<DiscussPost> getHotListFromDB(){

        return videoService.getHotListFromDB();
    }

    @GetMapping(value = "/hot/redis")
    public List<DiscussPost> getHotListFromRedis(){

        return videoService.getHotListFromRedis();
    }
}
