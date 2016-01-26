$(document).ready(function()
{
	// Define default value for pContent if it doesn't exist
	if (localStorage.getItem('pContent') == null || localStorage.getItem('pContent') == '') {
		localStorage.setItem('pContent', 'Click on me to change my content!');
	}

	// Get value of pContent and show it
	$('#pContent').html(localStorage.getItem('pContent'));

	// Add event listener to update the value on the local storage
	$('#pContent').on('input', updateItem);
});

// Function triggered to updated the pContent value
function updateItem(e) {
	localStorage.setItem('pContent', e.currentTarget.innerHTML);
}