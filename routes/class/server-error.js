class ServerError {

    constructor(note = '', err = {}) {
        this.error = true;
        this.message = err.message || '';
        this.note = note;

        console.log(this);

        return this.toResponse();
    }

    toResponse() {
        return {
            error: this.error
        }
    }

}

module.exports = ServerError;