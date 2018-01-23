$(document).ready(function () {
	$("#loginForm").validate({
		rules: {
			userName: {
				required: true,
				minlength: 5,
				maxlength: 10
			},
			pwd: {
				required: true,
				minlength: 8,
				maxlength: 20
			}
		},
		messages: {
			userName: {
				required: "username is required",
				minlength: "username must be between 5 and 10 characters",
				maxlength: "username must be between 5 and 10 characters"
			},
			pwd: {
				required: "password is required",
				minlength: "password must be between 8 and 20 characters",
				maxlength: "password must be between 8 and 20 characters"
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
})
$("#loginForm").validate({
	submitHandler: function (form) {
		form.submit();
	}
});