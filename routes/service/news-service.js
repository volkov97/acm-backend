const pool = require('../../config/db');

const ServerError = require('../class/server-error');
const NewsItem = require('../class/news-item');

class NewsService {

    constructor() {
        this.db_table = 'news';
    }

    getList(lang) {
        return new Promise((resolve, reject) => {
            if (!lang) {
                reject(new ServerError('You need to specify language.'));
                return;
            }

            pool.connect((err, client, done) => {
                if (err) {
                    reject(new ServerError('Pool connection failed.', err));
                    return;
                }

                const sql_getList = `
                    SELECT id, date, title_${lang}, descr_${lang}  
                    FROM ${this.db_table}
                `;

                client.query(sql_getList, (err, result) => {
                    done();
                    if (err) {
                        reject(new ServerError('SQL query failed.', err));
                        return;
                    }

                    resolve(result.rows);
                });
            });
        });
    }

    getItem(id, lang) {
        return new Promise((resolve, reject) => {
            if (!lang) {
                reject(new ServerError('You need to specify language.'));
                return;
            }

            pool.connect((err, client, done) => {
                if (err) {
                    reject(new ServerError('Pool connection failed.', err));
                    return;
                }

                const sql_getItem = `
                    SELECT id, date, title_${lang}, content_${lang}  
                    FROM ${this.db_table}
                    WHERE id = ${id}
                `;

                client.query(sql_getItem, (err, result) => {
                    done();
                    if (err) {
                        reject(new ServerError('SQL query failed.', err));
                        return;
                    }

                    if (!result.rows[0]) reject(new ServerError('This id is not exists.'));

                    resolve(result.rows[0]);
                });
            });
        });
    }

    addItem(item, lang) {
        return new Promise((resolve, reject) => {
            if (!lang) {
                reject(new ServerError('You need to specify language.'));
                return;
            }
            if (!NewsItem.isValid(item)) {
                reject(new ServerError('Item has incorrect fields.'));
                return;
            }
            
            pool.connect((err, client, done) => {
                if (err) reject(new ServerError('Pool connection failed.', err));

                const sql_insert = `
                    INSERT INTO ${this.db_table} (date, title_${lang}, descr_${lang}, content_${lang})
                    VALUES ('${item.date}', '${item.title}', '${item.descr}', '${item.content}')
                    RETURNING id;
                `;

                client.query(sql_insert, (err, result) => {
                    if (err) reject(new ServerError('SQL query failed.', err));
                    done();

                    resolve(result.rows[0].id);
                });
            });
        });
    }

    updateItem(id, item, lang) {
        return new Promise((resolve, reject) => {
            if (!lang) {
                reject(new ServerError('You need to specify language.'));
                return;
            }
            if (!NewsItem.isValid(item)) {
                reject(new ServerError('Item has incorrect fields.'));
                return;
            }
            
            pool.connect((err, client, done) => {
                if (err) {
                    reject(new ServerError('Pool connection failed.', err));
                    return;
                }

                const sql_update = `
                    UPDATE ${this.db_table}
                    SET
                        date = '${item.date}',
                        title_${lang} = '${item.title}',
                        descr_${lang} = '${item.descr}',
                        content_${lang} = '${item.content}'
                    WHERE id=${id}
                    RETURNING id, date, title_${lang}, descr_${lang}, content_${lang}  
                `;

                client.query(sql_update, (err, result) => {
                    done();
                    if (err) {
                        reject(new ServerError('SQL query failed.', err));
                        return;
                    }

                    if (!result.rows[0]) reject(new ServerError('This id is not exists.'));
                    
                    resolve(result.rows[0]);
                });
            });
        });
    }

    deleteItem(id) {
        return new Promise((resolve, reject) => {
            pool.connect((err, client, done) => {
                if (err) reject(new ServerError('Pool connection failed.', err));

                const sql_update = `
                    DELETE FROM ${this.db_table}
                    WHERE id=${id}
                `;

                client.query(sql_update, (err, result) => {
                    done();
                    if (err) {
                        reject(new ServerError('SQL query failed.', err));
                        return;
                    }

                    resolve(id);
                });
            });
        });
    }
}

module.exports = NewsService;