class NewsItem {

    constructor(obj) {
        this.date = obj.date;
        this.title = obj.title;
        this.descr = obj.descr;
        this.content = obj.content;
    }

    checkDate() {
        return 1;
    }

    checkTitle() {
        if (this.title.length == 0) return 0;
        return 1;
    }

    checkDescr() {
        if (this.descr.length == 0) return 0;
        return 1;
    }

    checkContent() {
        if (this.content.length == 0) return 0;
        return 1;
    }

    check() {
        return this.checkDate()
            && this.checkTitle()
            && this.checkDescr()
            && this.checkContent();
    }

}

module.exports = NewsItem;