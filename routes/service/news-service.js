const pool = require('../../config/db');
const langDefault = require('../../config/lang').lang_default;
const db_name = require('../../config/db_config').database;

const NewsItem = require('../class/news-item');

class NewsService {

    constructor() {
        this.db_table = 'news';
    }

    _setLanguage(lang, lang_array) {
        lang = lang || langDefault;

        const lang_columns = lang_array.filter(_ => (_.indexOf(`_${lang}`) + 1)).length;
        if (lang_columns !== 3) lang = langDefault;
        
        return lang;
    }

    getList(lang) {
        return new Promise((resolve, reject) => {
            pool.connect((err, client, done) => {
                if (err) reject('Pool connection failed.');

                const sql_lang = `
                    SELECT *
                    FROM ${db_name}.INFORMATION_SCHEMA.COLUMNS
                    WHERE TABLE_NAME = N'${this.db_table}'
                `;

                client.query(sql_lang, (err, result) => {
                    if (err) reject('Query failed: language check');

                    lang = this._setLanguage(lang, result.rows.map(_ => _.column_name));

                    const sql_getList = `
                        SELECT id, date, title_${lang}, descr_${lang}  
                        FROM ${this.db_table}
                    `;

                    client.query(sql_getList, (err, result) => {
                        if (err) reject('Query failed: list select');
                        done();

                        resolve(result.rows);
                    });
                });
            });
        });
    }

    getItem(id, lang) {
        return new Promise((resolve, reject) => {
            pool.connect((err, client, done) => {
                if (err) reject('Pool connection failed.');

                const sql_lang = `
                    SELECT *
                    FROM ${db_name}.INFORMATION_SCHEMA.COLUMNS
                    WHERE TABLE_NAME = N'${this.db_table}'
                `;

                client.query(sql_lang, (err, result) => {
                    if (err) reject('Query failed: language check');

                    lang = this._setLanguage(lang, result.rows.map(_ => _.column_name));

                    const sql_getItem = `
                        SELECT id, date, title_${lang}, content_${lang}  
                        FROM ${this.db_table}
                        WHERE id = ${id}
                    `;

                    client.query(sql_getItem, (err, result) => {
                        if (err) reject('Query failed: item select');
                        done();

                        resolve(result.rows);
                    });
                });
            });
        });
    }

    addItem(item, lang) {
        return new Promise((resolve, reject) => {
            if (!lang) reject('language is required');
            if (!NewsItem.isValid(item)) reject('item has incorrect fields');
            
            pool.connect((err, client, done) => {
                if (err) reject('Pool connection failed.');

                const sql_insert = `
                    INSERT INTO ${this.db_table} (date, title_${lang}, descr_${lang}, content_${lang})
                    VALUES ('${item.date}', '${item.title}', '${item.descr}', '${item.content}')
                    RETURNING id;
                `;

                client.query(sql_insert, (err, result) => {
                    if (err) reject('Query failed: insert query');
                    done();

                    resolve(result.rows[0].id);
                });
            });
        });
    }
}

module.exports = NewsService;