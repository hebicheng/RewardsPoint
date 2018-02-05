
$(document).ready(function () {
	$("#changePWDForm").validate({
		rules: {
			newpwd: {
				required: true,
				minlength: 8,
				maxlength: 20
			},
			repwd: {
				required: true,
				minlength: 8,
				maxlength: 20,
				equalTo:"#newpwd"
			}
		},
		messages: {
			newpwd: {
				required: "Password is required",
				minlength: "Password must be between 8 and 20 characters",
				maxlength: "Password must be between 8 and 20 characters"
			},
			repwd: {
				required: "Comfirm password is required",
				minlength: "Comfirm password must be between 8 and 20 characters",
				maxlength: "Comfirm password must be between 8 and 20 characters",
				equalTo: "The passwords entered did not match"
			}
		},
		errorElement: "em",
		errorPlacement: function (error, element) {
			// Add the `help-block` class to the error element
			error.addClass("help-block");

			// Add `has-feedback` class to the parent div.form-group
			// in order to add icons to inputs
			element.parents(".col-sm-5").addClass("has-feedback");

			if (element.prop("type") === "checkbox") {
				error.insertAfter(element.parent("label"));
			} else {
				error.insertAfter(element);
			}

			// Add the span element, if doesn't exists, and apply the icon classes to it.
			if (!element.next("span")[0]) {
				$("<span class='glyphicon glyphicon-remove form-control-feedback'></span>").insertAfter(element);
			}
		},
		success: function (label, element) {
			// Add the span element, if doesn't exists, and apply the icon classes to it.
			if (!$(element).next("span")[0]) {
				$("<span class='glyphicon glyphicon-ok form-control-feedback'></span>").insertAfter($(element));
			}
		},
		highlight: function (element, errorClass, validClass) {
			$(element).parents(".col-sm-5").addClass("has-error").removeClass("has-success");
			$(element).next("span").addClass("glyphicon-remove").removeClass("glyphicon-ok");
		},
		unhighlight: function (element, errorClass, validClass) {
			$(element).parents(".col-sm-5").addClass("has-success").removeClass("has-error");
			$(element).next("span").addClass("glyphicon-ok").removeClass("glyphicon-remove");
		}
	});
	$("#changeOJForm").validate({
		rules: {
			sicnuoj: {
				required: true,
				minlength: 1,
				maxlength: 20
			},
			codeforces: {
				required: true,
				minlength: 1,
				maxlength: 20,
			},
			atcoder: {
				required: true,
				minlength: 1,
				maxlength: 20,
			}
		},
		messages: {
			sicnuoj: {
				required: "This field is required",
				minlength: "This field must be between 1 and 20 characters",
				maxlength: "This field must be between 1 and 20 characters"
			},
			codeforces: {
				required: "This field is required",
				minlength: "This field must be between 1 and 20 characters",
				maxlength: "This field must be between 1 and 20 characters",
			},
			atcoder: {
				required: "This field is required",
				minlength: "This field must be between 1 and 20 characters",
				maxlength: "This field must be between 1 and 20 characters",
			}
		},
		errorElement: "em",
		errorPlacement: function (error, element) {
			// Add the `help-block` class to the error element
			error.addClass("help-block");

			// Add `has-feedback` class to the parent div.form-group
			// in order to add icons to inputs
			element.parents(".col-sm-5").addClass("has-feedback");

			if (element.prop("type") === "checkbox") {
				error.insertAfter(element.parent("label"));
			} else {
				error.insertAfter(element);
			}

			// Add the span element, if doesn't exists, and apply the icon classes to it.
			if (!element.next("span")[0]) {
				$("<span class='glyphicon glyphicon-remove form-control-feedback'></span>").insertAfter(element);
			}
		},
		success: function (label, element) {
			// Add the span element, if doesn't exists, and apply the icon classes to it.
			if (!$(element).next("span")[0]) {
				$("<span class='glyphicon glyphicon-ok form-control-feedback'></span>").insertAfter($(element));
			}
		},
		highlight: function (element, errorClass, validClass) {
			$(element).parents(".col-sm-5").addClass("has-error").removeClass("has-success");
			$(element).next("span").addClass("glyphicon-remove").removeClass("glyphicon-ok");
		},
		unhighlight: function (element, errorClass, validClass) {
			$(element).parents(".col-sm-5").addClass("has-success").removeClass("has-error");
			$(element).next("span").addClass("glyphicon-ok").removeClass("glyphicon-remove");
		}
	})
	
});

$("#changePWDForm").validate({
	submitHandler: function (form) {
		form.submit();
	}
});

$("#changeOJForm").validate({
	submitHandler: function (form) {
		form.submit();
	}
});

