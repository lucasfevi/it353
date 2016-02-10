// A - I
document.image1.onmouseover = function() {
	this.src = '../images/button-14-on.gif';
}

document.image1.onmouseout = function() {
	this.src = '../images/button-14-off.gif';
}

// A - II
document.form1.onsubmit = function() {
	return submitMe(this);
}

document.form2.onsubmit = function() {
	submitMe(this);
}

function submitMe(form)
{
	if (parseInt(form.box.value) % 2 == 0) {
		return true;
	}

	alert("Not an even number");
	return false;
}
