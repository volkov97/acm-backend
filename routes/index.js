const express = require('express');
const router = express.Router();

// GET /dictionary
router.get('/', (req, res, next) => {
    res.end('acm api');
});

module.exports = router;