package com.owuteam.config;

import com.owuteam.event.Event;
import com.owuteam.lang.Language;
import com.owuteam.news.News;
import com.owuteam.tags.Tag;
import com.owuteam.topic.Topic;
import com.owuteam.user.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(
                Language.class,
                News.class,
                Tag.class,
                Topic.class,
                User.class,
                Event.class
        );
    }
}
