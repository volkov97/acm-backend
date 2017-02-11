const pool = require('../../config/db');

class LangService {

    getLangs() {
        return new Promise((res, rej) => {
            const sql_lang = "SELECT * FROM d3hknf0t40kep6.INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = N'dictionary'"; 

            pool.connect((err, client, done) => {
                if (err) return console.error('error fetching client from pool', err);
                
                client.query(sql_lang, (err, result) => {
                    done();

                    if (err) return console.error('error running query', err);

                    const service_columns = ['id', 'key', 'context'];
                    const lang_columns = result.rows
                        .map(val => val.column_name)
                        .filter(val => !(service_columns.indexOf(val) + 1));

                    lang_columns.length ? res(lang_columns) : rej();
                });
            });

        });
    }

    langExists(lang) {
        return new Promise((res, rej) => {
            this.getLangs().then(
                (data) => {
                    const lang_exists = data.indexOf(lang) + 1;
                    lang_exists ? res(true) : res(false);
                },
                () => rej()
            );
        });
    }

    getAllDictionaries() {
        return new Promise((res, rej) => {
            pool.connect((err, client, done) => {
                if (err) return rej(err);
                
                client.query('SELECT * FROM dictionary', (err, result) => {
                    done();

                    if (err) return console.error('error running query', err);

                    res(result.rows);
                });
            });
        });
    }

    getDictionary(lang) {
        return new Promise((res, rej) => {
            this.langExists(lang)
                .then(
                    exists => {
                        lang = exists ? lang : 'eng';

                        pool.connect((err, client, done) => {
                            if (err) return console.error('error fetching client from pool', err);
                            
                            client.query(`SELECT key, ${lang} FROM dictionary`, (err, result) => {
                                done();

                                if (err) return console.error('error running query', err);

                                res(result.rows);
                            });
                        });
                    },
                    err => rej(err)
                );
        });
    }

    getExpression(id) {
        return new Promise((res, rej) => {
            pool.connect((err, client, done) => {
                if (err) return rej(err);
                
                client.query(`SELECT * FROM dictionary WHERE id=${id}`, (err, result) => {
                    done();

                    if (err) return console.error('error running query', err);

                    res(result.rows);
                });
            });
        });
    }

}

module.exports = LangService;