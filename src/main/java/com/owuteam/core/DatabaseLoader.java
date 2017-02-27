package com.owuteam.core;

import com.owuteam.news.News;
import com.owuteam.news.NewsRepository;
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

    @Autowired
    public DatabaseLoader(NewsRepository newsRepository, UserRepository userRepository) {
        this.newsRepository = newsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user1 = new User("Nick", "Bylnov", "Sergey",
                              "bigboss", "1234", new String[]{"ROLE_USER"});
        News newsItem = new News(
                "a",
                "b",
                "c",
                1,
                2,
                20
        );
        user1.addNews(newsItem);
        userRepository.save(user1);
        newsRepository.save(newsItem);
    }
}
