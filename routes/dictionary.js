const express = require('express');
const router = express.Router();

const langService = require('./class/lang');

// GET /dictionary
router.get('/', (req, res, next) => {

	// ?lang=rus
	if (req.query.lang) {
		langService.getDictionary(req.query.lang).then(
			data => res.json(data),
			err => handleErrors(err)
		);

		return;
	}

	langService.getAllDictionaries().then(
		data => res.json(data),
		err => handleErrors(err)
	);
});

function handleErrors(err) {
	throw err;
	return;
}

module.exports = router;
