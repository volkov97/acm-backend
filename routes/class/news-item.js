class NewsItem {

    constructor(obj) {
        this.date = obj.date;
        this.title = obj.title;
        this.descr = obj.descr;
        this.content = obj.content;
    }

    static checkDate(date) {
        return 1;
    }

    static checkTitle(title) {
        if (title.length == 0) return 0;
        return 1;
    }

    static checkDescr(descr) {
        if (descr.length == 0) return 0;
        return 1;
    }

    static checkContent(content) {
        if (content.length == 0) return 0;
        return 1;
    }

    static isValid(item) {
        return this.checkDate(item.date)
            && this.checkTitle(item.title)
            && this.checkDescr(item.descr)
            && this.checkContent(item.content);
    }

}

module.exports = NewsItem;