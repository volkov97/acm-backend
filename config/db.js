const pg = require('pg');
const config = require('./db_config');
const pool = new pg.Pool(config);

pool.on('error', function (err, client) {
  console.error('idle client error', err.message, err.stack)
});

module.exports = pool;
