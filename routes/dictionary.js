const express = require('express');
const router = express.Router();

const dictionaryService = require('./service/dictionary-service');

// GET /dictionary
router.get('/', (req, res, next) => {

	// ?lang=rus
	if (req.query.lang) {
		dictionaryService.getDictionary(req.query.lang).then(
			data => res.json(data)
		);

		return;
	}

	dictionaryService.getAllDictionaries().then(
		data => res.json(data)
	);
});

// GET /dictionary/:id
router.get('/:id', (req, res) => {
	dictionaryService.getExpression(req.params.id);
});

module.exports = router;
