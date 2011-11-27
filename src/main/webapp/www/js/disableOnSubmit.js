$.fn.disableOnSubmit = function(disableList) {

	var list;

	if (disableList == null) {
		list = "input[type=submit],input[type=button],input[type=reset],button";
	} else {
		list = disableList;
	}

	$(this).find(list).each(function() {
		$(this).removeAttr("disabled");
		if ($(this).attr("name") != undefined) {
			$(this).click(function() {
				$(this).closest("form").append(
					$("<input type=\"hidden\">")
					.attr("name", ($(this).attr("name")))
					.attr("value", ($(this).attr("value")))
				);
			});
		}
	});

	$(this).submit(function() {
		$(this).find(list).attr("disabled", "disabled");
	});

	return this;
};
