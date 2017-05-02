import com.owuteam.Application;
import com.owuteam.topic.Topic;
import com.owuteam.topic.TopicRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TopicRepositoryTest {

    @Test
    public void getTopicNameRu() throws Exception {
        Topic one = new Topic("привет", "hello");

        Assert.assertEquals(one.getNameRU(),"привет");
    }

    @Test
    public void getTopicNameEn() throws Exception {
        Topic one = new Topic("привет", "hello");
        Assert.assertEquals(one.getNameEN(),"hello");
    }

    @Test
    public void setTopicNameRU() {
        Topic one = new Topic();
        String nameRU = "супер";
        one.setNameRU(nameRU);
        Assert.assertEquals(one.getNameRU(),nameRU);

    }

    @Test
    public void setTopicNameEN() {
        Topic one = new Topic();
        String nameEN = "super";
        one.setNameEN(nameEN);
        Assert.assertEquals(one.getNameEN(),nameEN);

    }
}
