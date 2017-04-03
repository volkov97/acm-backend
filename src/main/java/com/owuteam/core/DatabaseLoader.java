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

//        User user1 = new User("Nick", "Bylnov", "Sergey",
//                              "bigboss", "12345", new String[]{"ROLE_USER"});
//        News newsItem1 = new News(
//               "Джава",
//                "Java",
//                "8",
//                "джава коре",
//                "java se",
//                "лямбда выражения",
//                "lambda",
//                8,
//                1,
//                1
//        );
//        News newsItem2 = new News(
//                "Пайтон",
//                "python",
//                "8",
//                "джава коре",
//                "java se",
//                "лямбда выражения",
//                "lambda",
//                10,
//                1,
//                1
//        );
//        Tag tag1 = new Tag("популярное", "popular");
//        Tag tag2 = new Tag("супе","super");
//        Topic topic1 = new Topic("бгуир","bsuir");
//        Topic topic2 = new Topic("ксис","ksis");
//
//
//        newsItem1.addTag(tag1);
//        newsItem1.setTopic(topic1);
//        newsItem1.addTag(tag2);
//        newsItem2.setTopic(topic2);
//        user1.addNews(newsItem1);
//        user1.addNews(newsItem2);
//        userRepository.save(user1);
//        newsRepository.save(newsItem1);
//        tagRepository.save(tag1);
//        topicRepository.save(topic1);
//        newsRepository.save(newsItem2);
    }
}
