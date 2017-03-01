package com.owuteam.core;

import com.owuteam.news.News;
import com.owuteam.news.NewsRepository;
import com.owuteam.tags.Tag;
import com.owuteam.tags.TagRepository;
import com.owuteam.user.User;
import com.owuteam.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final NewsRepository newsRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;

    @Autowired
    public DatabaseLoader(NewsRepository newsRepository, UserRepository userRepository, TagRepository tagRepository) {
        this.newsRepository = newsRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User("Nick", "Bylnov", "Sergey",
                              "bigboss", "1234", new String[]{"ROLE_USER"});
        News newsItem1 = new News(
                "olympic",
                "java",
                "se,ee",
                1,
                2,
                20
        );
        Tag tag1 = new Tag("popular");

        user1.addNews(newsItem1);
        newsItem1.addTag(tag1);

        userRepository.save(user1);
        newsRepository.save(newsItem1);
        tagRepository.save(tag1);
    }
}
