$.fn.disableOnSubmit = function(disableList) {

	var list;

	if (disableList == null) {
		list = "input[type=submit],input[type=button],input[type=reset],button";
	} else {
		list = disableList;
	}

	$(this).find(list).each(function() {
		if ($(this).attr("name") != undefined) {
			$(this).click(function() {
				$("#disable-on-submit-hidden").remove();
				$(this).closest("form").append(
					$("<input type=\"hidden\" id=\"disable-on-submit-hidden\">")
					.attr("name", ($(this).attr("name")))
					.attr("value", ($(this).attr("value")))
				);
			});
		}
	});

	$(this).submit(function() {
		$(this).find(list).each(function() {
			var target = $(this);
			var isDisabled = target.prop("disabled");
			target.attr("disabled", "disabled");
			$(window).unload(function() {
				target.prop("disabled", isDisabled);
			});
		});
	});

	return this;
};

$.fn.resetOnSubmit = function(disableList) {

	var list;

	if (disableList == null) {
		list = "input[type=submit],input[type=button],input[type=reset],button";
	} else {
		list = disableList;
	}

	$(this).find(list).each(function() {
		$(this).removeAttr("disabled");
	});
};
