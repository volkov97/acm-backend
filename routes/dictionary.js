const express = require('express');
const router = express.Router();

const pool = require('../config/db.js');

// GET /dictionary
router.get('/', (req, res, next) => {

	pool.connect((err, client, done) => {
		if (err) return console.error('error fetching client from pool', err);
		
		client.query('SELECT id, key, context, eng FROM dictionary', (err, result) => {
			done();

			if (err) return console.error('error running query', err);

			res.json(result.rows);
		});
	});

});

module.exports = router;