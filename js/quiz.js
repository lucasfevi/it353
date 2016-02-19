$('.tab-pane .next').on('click', function() {
	var targetID = $(this).data('target');

	$('a[href="' + targetID + '"]').click();
});

var results = [null, null, null, null, null, null, null, null, null];

$('#questionOne .submit').on('click', answerOne);
$('#questionTwo .submit').on('click', answerTwo);
$('#questionThree .submit').on('click', answerThree);
$('#questionFour .submit').on('click', answerFour);
$('#questionFive .submit').on('click', answerFive);
$('#questionSix .submit').on('click', answerSix);
$('#questionSeven .submit').on('click', answerSeven);
$('#questionEight .submit').on('click', answerEight);
$('#questionNine .submit').on('click', answerNine);

function showError(targetID) {
	$(targetID).find('.alert-danger').removeClass('hide').show();
	$('a[href="' + targetID + '"]').append('&nbsp;<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>');
}

function showSuccess(targetID) {
	$(targetID).find('.alert-success').removeClass('hide').show();
	$('a[href="' + targetID + '"]').append('&nbsp;<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>');
}

function updateTotal() {
	var count = 0;

	for (var i in results) {
		if (results[i] == true) {
			count++;
		}
	}

	$('#corrects').html(count);
}

function answerOne() {
	if (results[0] !== null) {
		return false;
	}

	var correctAnswer = 'c';
	var userAnswer = $('[name="questionOne"]:checked').val();

	if (userAnswer == correctAnswer) {
		results[0] = true;
		showSuccess('#questionOne');
		$('#answer0').html('<p class="text-success">Correct</p>');
	} else {
		results[0] = false;
		showError('#questionOne');
		$('#answer0').html('<p class="text-danger">Wrong!</p>');
	}

	updateTotal();
	$(this).hide();
}

function answerTwo() {
	if (results[1] !== null) {
		return false;
	}

	var correctAnswer = 'a';
	var userAnswer = $('[name="questionTwo"]:checked').val();

	if (userAnswer == correctAnswer) {
		results[1] = true;
		showSuccess('#questionTwo');
		$('#answer1').html('<p class="text-success">Correct</p>');
	} else {
		results[1] = false;
		showError('#questionTwo');
		$('#answer1').html('<p class="text-danger">Wrong!</p>');
	}

	updateTotal();
	$(this).hide();
}

function answerThree() {
	if (results[2] !== null) {
		return false;
	}

	var correctAnswer = 'b';
	var userAnswer = $('[name="questionThree"]:checked').val();

	if (userAnswer == correctAnswer) {
		results[2] = true;
		showSuccess('#questionThree');
		$('#answer2').html('<p class="text-success">Correct</p>');
	} else {
		results[2] = false;
		showError('#questionThree');
		$('#answer2').html('<p class="text-danger">Wrong!</p>');
	}

	updateTotal();
	$(this).hide();
}

function answerFour() {
	if (results[3] !== null) {
		return false;
	}

	var correctAnswer = 'true';
	var userAnswer = $('[name="questionFour"]').val();

	if (userAnswer == correctAnswer) {
		results[3] = true;
		showSuccess('#questionFour');
		$('#answer3').html('<p class="text-success">Correct</p>');
	} else {
		results[3] = false;
		showError('#questionFour');
		$('#answer3').html('<p class="text-danger">Wrong!</p>');
	}

	updateTotal();
	$(this).hide();
}

function answerFive() {
	if (results[4] !== null) {
		return false;
	}

	var correctAnswer = 'false';
	var userAnswer = $('[name="questionFive"]').val();

	if (userAnswer == correctAnswer) {
		results[4] = true;
		showSuccess('#questionFive');
		$('#answer4').html('<p class="text-success">Correct</p>');
	} else {
		results[4] = false;
		showError('#questionFive');
		$('#answer4').html('<p class="text-danger">Wrong!</p>');
	}

	updateTotal();
	$(this).hide();
}

function answerSix() {
	if (results[5] !== null) {
		return false;
	}

	var correctAnswer = 'false';
	var userAnswer = $('[name="questionSix"]').val();

	if (userAnswer == correctAnswer) {
		results[5] = true;
		showSuccess('#questionSix');
		$('#answer5').html('<p class="text-success">Correct</p>');
	} else {
		results[5] = false;
		showError('#questionSix');
		$('#answer5').html('<p class="text-danger">Wrong!</p>');
	}

	updateTotal();
	$(this).hide();
}

function answerSeven() {
	if (results[6] !== null) {
		return false;
	}

	var correctAnswer = 'controller';
	var userAnswer = $('[name="questionSeven"]').val();

	if (userAnswer.toLowerCase() == correctAnswer) {
		results[6] = true;
		showSuccess('#questionSeven');
		$('#answer6').html('<p class="text-success">Correct</p>');
	} else {
		results[6] = false;
		showError('#questionSeven');
		$('#answer6').html('<p class="text-danger">Wrong!</p>');
	}

	updateTotal();
	$(this).hide();
}

function answerEight() {
	if (results[7] !== null) {
		return false;
	}

	var correctAnswer = '404';
	var userAnswer = $('[name="questionEight"]').val();

	if (userAnswer.toLowerCase() == correctAnswer) {
		results[7] = true;
		showSuccess('#questionEight');
		$('#answer7').html('<p class="text-success">Correct</p>');
	} else {
		results[7] = false;
		showError('#questionEight');
		$('#answer7').html('<p class="text-danger">Wrong!</p>');
	}

	updateTotal();
	$(this).hide();
}

function answerNine() {
	if (results[8] !== null) {
		return false;
	}

	var correctAnswer = 'breakpoint';
	var userAnswer = $('[name="questionNine"]').val();

	if (userAnswer.toLowerCase() == correctAnswer) {
		results[8] = true;
		showSuccess('#questionNine');
		$('#answer8').html('<p class="text-success">Correct</p>');
	} else {
		results[8] = false;
		showError('#questionNine');
		$('#answer8').html('<p class="text-danger">Wrong!</p>');
	}

	updateTotal();
	$(this).hide();
}
