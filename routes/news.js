const express = require('express');
const router = express.Router();
const NewsService = require('./service/news-service');

const newsService = new NewsService();

// GET /news
router.get('/', (req, res) => {
    newsService.getList(req.query.lang)
        .then(newsList => res.json(newsList))
        .catch(reason => res.status(500).json(reason));
});

// GET /news/:id
router.get('/:id', (req, res) => {
	newsService.getItem(req.params.id, req.query.lang)
        .then(newsItem => res.json(newsItem))
        .catch(reason => res.status(500).json(reason));
});

// POST /news/
router.post('/', (req, res) => {
    newsService.addItem(req.body, req.query.lang)
        .then(index => res.end(String(index)))
        .catch(reason => res.status(500).json(reason));
});

module.exports = router;
