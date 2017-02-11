const express = require('express');
const router = express.Router();
const WordsService = require('./service/words-service');

const wordsService = new WordsService();

// GET /words/all
router.get('/all', (req, res) => {
	wordsService.getDictionary()
		.then(data => res.json(data))
		.catch(err => res.status(500).json(err));
});

// GET /words
router.get('/', (req, res) => {
	wordsService.getLang(req.query.lang)
		.then(data => res.json(data))
		.catch(err => res.status(500).json(err));
});
/*
// GET /words/:id
router.get('/:id', (req, res) => {
	wordsService.getItem(req.params.id)
		.then(data => res.json(data))
		.catch(err => res.status(500).json(err));
});

// POST /words/:id
router.get('/:id', (req, res) => {
	wordsService.addItem(req.body)
		.then(index => res.end(index))
		.catch(err => res.status(500).json(err));
});
*/
module.exports = router;
