package com.owuteam.news;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface NewsService {
   Long addByTopic(Long id, String nameRU, String nameEN);
}
