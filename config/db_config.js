module.exports = {
	user: 'zrdlxgkrbwtrfd', //env var: PGUSER
	database: 'd3hknf0t40kep6', //env var: PGDATABASE
	password: 'c7e9e01723bc159c6a6e55dbad6c881b27854eccda62e436a8325ccdc4fc7059', //env var: PGPASSWORD
	host: 'ec2-54-228-189-223.eu-west-1.compute.amazonaws.com', // Server hosting the postgres database
	port: 5432, //env var: PGPORT
	max: 10, // max number of clients in the pool
	idleTimeoutMillis: 30000, // how long a client is allowed to remain idle before being closed
	ssl: true
};