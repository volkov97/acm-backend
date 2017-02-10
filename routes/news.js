const express = require('express');
const router = express.Router();

const handleErrors = require('./handlers/error').handleErrors;
const newsService = require('./service/news-service');

// GET /news
router.get('/', (req, res, next) => {
    newsService.getList().then(
        data => res.json(data),
        err => handleErrors(err)
    );
});

// GET /news/:id
router.get('/:id', (req, res, next) => {
	newsService.getItem(req.params.id).then(
        data => res.json(data),
        err => handleErrors(err)
    );
});

// POST /news/
router.post('/', (req, res, next) => {
    console.log('a');
    if (!newsService.checkItem(req.body)) res.sendStatus(400);
console.log('b');
    newsService.addItem(req.body).then(
        data => res.json(data),
        err => handleErrors(err)
    );
});

module.exports = router;
