import com.owuteam.Application;
import com.owuteam.news.News;
import com.owuteam.user.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class NewsTest {

    @Test
    public void setCreator() throws Exception {
        News news = new News();
        User user = new User();
        String userName = "sunflower";
        user.setUserName(userName);
        news.setUser(user);
        Assert.assertEquals(news.getUser().getUserName(),user.getUserName());
    }

    @Test
    public void setTitleRU() {
        News news = new News();
        String titleRU = "соревнование";
        news.setTitleRU(titleRU);
        Assert.assertEquals(news.getTitleRU(), titleRU);
    }

    @Test
    public void setTitleEN() {
        News news = new News();
        String titleEN = "competition";
        news.setTitleEN(titleEN);
        Assert.assertEquals(news.getTitleEN(), titleEN);
    }
}
