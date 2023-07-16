package asia.daijizai.asia;

import asia.daijizai.hotlist.dao.VideoDao;
import asia.daijizai.hotlist.entity.DiscussPost;
import asia.daijizai.hotlist.fuse.FuseHandler;
import asia.daijizai.hotlist.service.Impl.VideoServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 * @author daijizai
 * @version 1.0
 * @date 2023/2/5 17:11
 * @description
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ContextConfiguration(classes = Application.class)
@RunWith(MockitoJUnitRunner.class)
public class VideoServiceImplTest {
    @Mock
    private VideoDao videoDao;
    @Mock
    private Random random;
    @InjectMocks
    private VideoServiceImpl videoService;

    @Test
    public void test() throws Exception {
        MockitoAnnotations.openMocks(this);
        DiscussPost mock = new DiscussPost();
        mock.setId(1);
        mock.setTitle("你好世界");
        Mockito.when(videoDao.getById(Mockito.anyInt())).thenReturn(mock);

        DiscussPost discussPost = videoService.gitVideoById(100);
        System.out.println(discussPost);
        Assertions.assertEquals("你好世界", discussPost.getTitle());
    }

    @Test
    public void testRandom() {
        for (int i = 0; i < 10; i++) {
            String random = Math.random() + "";
            System.out.println(random.substring(random.length() - 4));

        }
    }
}
