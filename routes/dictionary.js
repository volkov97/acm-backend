const express = require('express');
const router = express.Router();

const handleErrors = require('./handlers/error').handleErrors;
const dictionaryService = require('./service/dictionary-service');

// GET /dictionary
router.get('/', (req, res, next) => {

	// ?lang=rus
	if (req.query.lang) {
		dictionaryService.getDictionary(req.query.lang).then(
			data => res.json(data),
			err => handleErrors(err)
		);

		return;
	}

	dictionaryService.getAllDictionaries().then(
		data => res.json(data),
		err => handleErrors(err)
	);
});

// GET /dictionary/:id
router.get('/:id', (req, res, next) => {
	dictionaryService.getExpression(req.params.id);
});

module.exports = router;
