package com.owuteam.news;

import com.owuteam.topic.Topic;
import com.owuteam.user.User;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface NewsService {
   Long addTopic(@PathVariable("id") Long id, @Param("nameRU") String nameRU, @Param("nameEN") String nameEN);
}
