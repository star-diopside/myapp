$.fn.disableOnSubmit = function(disableList) {

	var list;

	if (disableList == null) {
		list = 'input[type=submit],input[type=button],input[type=reset],button';
	} else {
		list = disableList;
	}

	$(this).find(list).removeAttr('disabled');

	$(this).submit(function() {
		$(this).find(list).attr('disabled', 'disabled');
	});

	return this;
};
