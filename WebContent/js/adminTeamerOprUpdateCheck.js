
$(document).ready(function () {
	$("#upDateTeamerForm").validate({
		rules: {
			name: {
				required: true,
				minlength: 1,
				maxlength: 10
			},
			grade: {
				required: true,
				digits:true,
				minlength: 4,
				maxlength: 4,
			},
			sicnuoj: {
				required: true,
				minlength: 1,
				maxlength: 20,
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
			},
			password:{
				minlength: 8,
				maxlength: 20,
			}
			
		},
		messages: {
			name: {
				required: "name is required",
				minlength: "name must be between 1 and 10 characters",
				maxlength: "name must be between 1 and 10 characters"
			},
			grade: {
				required: "grade is required",
				minlength: "grade must be 4 characters",
				maxlength: "grade must be 4 characters"
			},
			sicnuoj: {
				required: "this field is required",
				minlength: "this field must be between 1 and 20 characters",
				maxlength: "this field must be between 1 and 20 characters"
			},
			codeforces: {
				required: "this field is required",
				minlength: "this field must be between 1 and 20 characters",
				maxlength: "this field must be between 1 and 20 characters"
			},
			atcoder: {
				required: "this field is required",
				minlength: "this field must be between 1 and 20 characters",
				maxlength: "this field must be between 1 and 20 characters"
			},
			
			password: {
				minlength: "Password must be between 8 and 20 characters",
				maxlength: "Password must be between 8 and 20 characters"
			}
		}
	});
	$("#addTeamerForm").validate({
		rules: {
			add_name: {
				required: true,
				minlength: 1,
				maxlength: 10
			},
			add_username:{
				required: true,
				digits:true,
				minlength: 10,
				maxlength: 10
				
			},
			add_grade: {
				required: true,
				digits:true,
				minlength: 4,
				maxlength: 4,
			},
			add_sicnuoj: {
				required: true,
				minlength: 1,
				maxlength: 20,
			},
			add_codeforces: {
				required: true,
				minlength: 1,
				maxlength: 20,
			},
			add_atcoder: {
				required: true,
				minlength: 1,
				maxlength: 20,
			},
			add_password:{
				minlength: 8,
				required: true,
				maxlength: 20,
			}
			
		},
		messages: {
			add_name: {
				required: "name is required",
				minlength: "name must be between 1 and 10 characters",
				maxlength: "name must be between 1 and 10 characters"
			},
			add_grade: {
				required: "grade is required",
				minlength: "grade must be 4 characters",
				maxlength: "grade must be 4 characters"
			},
			add_sicnuoj: {
				required: "this field is required",
				minlength: "this field must be between 1 and 20 characters",
				maxlength: "this field must be between 1 and 20 characters"
			},
			add_codeforces: {
				required: "this field is required",
				minlength: "this field must be between 1 and 20 characters",
				maxlength: "this field must be between 1 and 20 characters"
			},
			add_atcoder: {
				required: "this field is required",
				minlength: "this field must be between 1 and 20 characters",
				maxlength: "this field must be between 1 and 20 characters"
			},
			
			add_password: {
				required: "Password is required",
				minlength: "Password must be between 8 and 20 characters",
				maxlength: "Password must be between 8 and 20 characters"
			}
		}
	});
});

$("#upDateTeamerForm").validate({
	submitHandler: function (form) {
		form.submit();
	}
});
$("#addTeamerForm").validate({
	submitHandler: function (form) {
		form.submit();
	}
});


