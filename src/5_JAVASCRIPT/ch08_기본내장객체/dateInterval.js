Date.prototype.getInterval = function (that) {
	if (this > that) {
		var intervalMili = this.getTime() - that.getTime();
	} else {
		var intervalMili = that.getTime() - this.getTime();
	}

	var intervalDay = intervalMili / (1000 * 60 * 60 * 24);

	return Math.trunc(intervalDay);
};