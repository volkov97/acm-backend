const pool = require('../../config/db');
const NewsItem = require('../class/news-item');

class NewsService {

    checkItem(item) {
        return new NewsItem(item).check(); 
    }

    getList() {
        return new Promise((res, rej) => {
            // fix nt.news_id and nd.news_id
            const sql_getList = `
                SELECT n.id, n.date, nt.en as title, nd.en as descr
                FROM news n
                INNER JOIN news_title nt ON n.id = nt.id
                INNER JOIN news_descr nd ON n.id = nd.id
            `;

            pool.connect((err, client, done) => {
                if (err) return console.error('error fetching client from pool', err);
                
                client.query(sql_getList, (err, result) => {
                    done();

                    if (err) return console.error('error running query', err);

                    res(result.rows);
                });
            });

        });
    }

    getItem(id) {
        return new Promise((res, rej) => {
            // fix nt.news_id and nd.news_id
            const sql_getList = `
                SELECT n.id, n.date, nt.en as title, nc.en as content
                FROM news n
                INNER JOIN news_title nt ON n.id = nt.id
                INNER JOIN news_content nc ON n.id = nc.id
                WHERE n.id = ${id}
            `;

            pool.connect((err, client, done) => {
                if (err) return console.error('error fetching client from pool', err);
                
                client.query(sql_getList, (err, result) => {
                    done();

                    if (err) return console.error('error running query', err);

                    res(result.rows);
                });
            });

        });
    }
    /*
    addItem(item, lang) {
        lang = lang ? lang : 'en';

        return new Promise((res, rej) => {
            const sql_addToNews = `
                INSERT INTO news (date)
                VALUES (${item.date})
            `;

            const sql_addToNewsTitle = `
                INSERT INTO news_title (${lang})
                VALUES (${item.title})
            `;

            const sql_addToNewsDescr = `
                INSERT INTO news_descr (${lang})
                VALUES (${item.descr})
            `;

            const sql_addToNewsContent = `
                INSERT INTO news_content (${lang})
                VALUES (${item.content})
            `;

            pool.connect((err, client, done) => {
                if (err) return console.error('error fetching client from pool', err);
                
                client.query(sql_addToNews, (err, result) => {
                    if (err) return console.error('error running query', err);
                    queryDone();
                });

                client.query(sql_addToNewsTitle, (err, result) => {
                    if (err) return console.error('error running query', err);
                    queryDone();
                });

                client.query(sql_addToNewsDescr, (err, result) => {
                    if (err) return console.error('error running query', err);
                    queryDone();
                });

                client.query(sql_addToNewsContent, (err, result) => {
                    if (err) return console.error('error running query', err);
                    queryDone();
                });

                function queryDone() {
                    queryDone.queries--;

                    if (queryDone.queries == 0) done();
                }
                queryDone.queries = 4;
            });

        });
    }
    */

}

module.exports = new NewsService();