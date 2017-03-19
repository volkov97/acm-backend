package com.owuteam.core;

import com.owuteam.lang.LanguageRepository;
import com.owuteam.news.News;
import com.owuteam.news.NewsRepository;
import com.owuteam.tags.Tag;
import com.owuteam.tags.TagRepository;
import com.owuteam.topic.Topic;
import com.owuteam.topic.TopicRepository;
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
    private final TopicRepository topicRepository;
    private final LanguageRepository languageRepository;

    @Autowired
    public DatabaseLoader(NewsRepository newsRepository, UserRepository userRepository, TagRepository tagRepository, TopicRepository topicRepository, LanguageRepository languageRepository) {
        this.newsRepository = newsRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
        this.topicRepository = topicRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User("Nick", "Bylnov", "Sergey",
                              "bigboss", "123456", new String[]{"ROLE_USER"});
        News newsItem1 = new News(
               "Джава",
                "Java",
                "8",
                "джава коре",
                "java se",
                "лямбда выражения",
                "lambda",
                1,
                0,
                2,
                3
        );
        News newsItem2 = new News(
                "Пайтон",
                "python",
                "8",
                "джава коре",
                "java se",
                "лямбда выражения",
                "lambda",
                1,
                0,
                2,
                3
        );
        Tag tag1 = new Tag("popular");
        Tag tag2 = new Tag("super");
        Topic topic1 = new Topic("bsuir");
        Topic topic2 = new Topic("ksis");


        newsItem1.addTag(tag1);
        newsItem1.addTopic(topic1);
        newsItem1.addTag(tag2);
        newsItem2.addTopic(topic2);
        user1.addNews(newsItem1);


        userRepository.save(user1);
        newsRepository.save(newsItem1);
        tagRepository.save(tag1);
        topicRepository.save(topic1);
    }
}
