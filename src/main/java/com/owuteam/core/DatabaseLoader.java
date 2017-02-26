package com.owuteam.core;

import com.owuteam.admin.Admin;
import com.owuteam.admin.AdminRepository;
import com.owuteam.news.News;
import com.owuteam.news.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final NewsRepository newsRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public DatabaseLoader(NewsRepository newsRepository, AdminRepository adminRepository) {
        this.newsRepository = newsRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        Admin admin1 = new Admin("German", "Volkov", "Aleksandrovich", "1234", 12);

        News newsItem = new News(
                "a",
                "b",
                "c",
                1,
                2,
                20
        );
        admin1.addNews(newsItem);
        adminRepository.save(admin1);
        newsRepository.save(newsItem);

    }
}
