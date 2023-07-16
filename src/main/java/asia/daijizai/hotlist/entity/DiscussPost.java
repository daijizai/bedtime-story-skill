package asia.daijizai.hotlist.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;


import java.util.Date;

/**
 * @author daijizai
 * @version 1.0
 * @date 2022/6/5 19:30
 * @description 帖子
 */


@Data
public class DiscussPost {
    private int id;

    private int userId;

    private String title;

    private String content;

    private int type;

    private int status;

    private Date createTime;

    private int commentCount;

    private double score;
}
