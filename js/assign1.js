/**
 * Add a new CSS file to change the style of the page.
 */
function addCSS()
{
    // Create a new element dynamically as follows
    var newlink = document.createElement("link")
    newlink.setAttribute("rel", "stylesheet");
    newlink.setAttribute("type", "text/css");
    newlink.setAttribute("href", "../css/assign1.css");

    // Append it to the head tag
    document.getElementsByTagName("head").item(0).appendChild(newlink);
}

/**
 * Prompt the user to input N scores and show him the lowest, the highest
 * and the average number. Also show him all the numbers higher than the
 * average one.
 */
function score()
{
    var nScores = prompt('Enter the # of scores:', 3);
    var arrScores = new Array();
    var message;

    for (var i = 0; i < nScores; i++)
    {
        arrScores[i] = parseInt(prompt('Enter score number ' + (i + 1)));
    }

    message  = 'Lucas Vieira\'s Output\n';
    message += 'Lowest = ' + getLowestScore(arrScores) + '\n';
    message += 'Highest = ' + getHighestScore(arrScores) + '\n';
    message += 'Average = ' + getAverageScore(arrScores) + '\n';
    message += 'Scores > Average:\n';
    message += showHigherThanAverageScores(arrScores);

    alert(message);
}

/**
 * Get the lowest score on the array.
 *
 * @param  Array    arrScores   an array with scores
 *
 * @return int                  the lowest score
 */
function getLowestScore(arrScores)
{
    var lowestScore = arrScores[0];

    for (var i = 1; i < arrScores.length; i++)
    {
        if (arrScores[i] < lowestScore)
            lowestScore = arrScores[i];
    }

    return lowestScore;
}

/**
 * Get the highest score on the array.
 *
 * @param  Array    arrScores   an array with scores
 *
 * @return int                  the highest score
 */
function getHighestScore(arrScores)
{
    var highestScore = arrScores[0];

    for (var i = 1; i < arrScores.length; i++)
    {
        if (arrScores[i] > highestScore)
            highestScore = arrScores[i];
    }

    return highestScore;
}

/**
 * Get the average score on the array.
 *
 * @param  Array    arrScores   an array with scores
 *
 * @return int                  the average score
 */
function getAverageScore(arrScores)
{
    var sum = 0;

    for (var i = 0; i < arrScores.length; i++)
    {
        sum += arrScores[i];
    }

    return sum / arrScores.length;
}

/**
 * Get all the scores higher than the average score.
 *
 * @param  Array    arrScores   an array with scores
 *
 * @return Array                an array with all scores higher than the average
 */
function showHigherThanAverageScores(arrScores)
{
    var average = getAverageScore(arrScores);
    var arrHigher = new Array();

    for (var i = 0; i < arrScores.length; i++)
    {
        if (arrScores[i] > average)
            arrHigher.push(arrScores[i]);
    }

    return arrHigher.join(',');
}

/**
 * Prompt the user for some variables necessary to calculate
 * how much an employee should be paid based on his hours worked
 * and rate of pay.
 */
function employee()
{
    var name = prompt('Insert your name');
    var ssn = prompt('Insert your SSN');
    var rateOfPay = parseFloat(prompt('Insert your rate of pay'));
    var hoursWorked = parseFloat(prompt('Insert hours worked'));

    var message = name + ' - ' + ssn + '\n';
    message += 'Rate of pay: $' + rateOfPay + '/h\n';
    message += 'Hours worked: ' + hoursWorked + 'h\n';
    message += 'Total: ' + getTotalPay(hoursWorked, rateOfPay);

    alert(message);
}

/**
 * Do the math necessary to get the total pay based on hoursWorked
 * and rateOfPay variables.
 *
 * @param  float    hoursWorked     how many hours the employee worked
 * @param  float    rateOfPay       how much employee receive per hour
 *
 * @return float                    total pay employee should receive
 */
function getTotalPay(hoursWorked, rateOfPay)
{
    if (hoursWorked > 40) {
        return 40 * rateOfPay + (hoursWorked - 40) * rateOfPay * 1.5;
    }

    return hoursWorked * rateOfPay;
}

/**
 * Form validations
 */
function validateForm(form)
{
    if (!isValidEmail(form.email.value)) {
        return false;
    }

    if (!isValidZipCode(form.zipcode.value)) {
        return false;
    }

    return true;
}

/**
 * Check if the zipCode variable is a valid zip code.
 *
 * @param  String   zipCode     zip code to be validate
 *
 * @return boolean              true if valid false if not valid
 */
function isValidZipCode(zipCode)
{
    if (zipCode.length != 10 && zipCode.length != 5) {
        alert('Zip code length is incorrect.');
        return false;
    }

    var arrZipCode = zipCode.split('');

    for (var i in arrZipCode)
    {
        if (i == 5 && arrZipCode[i] != '-') {
            alert('Invalid zip code.');
            return false;
        }

        if (i != 5 && isNaN(arrZipCode[i])) {
            alert('Invalid zip code.');
            return false;
        }
    }

    return true;
}

/**
 * Check if the email variable is a valid e-mail.
 *
 * @param  String   email   e-mail to be validate
 *
 * @return boolean          true if valid false if not valid
 */
function isValidEmail(email)
{
    if (email.indexOf('@') == -1) {
        alert("Your e-mail need an '@' to be valid.");
        return false;
    }

    if (numberOfOccurrences(email, '@') > 1) {
        alert("You can't use more than one '@' in an e-mail.");
        return false;
    }

    if (email.indexOf('@') == 0 || email.indexOf('@') == email.length - 1) {
        alert("You can't use '@' in beginning or end of an e-mail.");
        return false;
    }

    if (email.indexOf('.') == 0 || email.indexOf('.') == email.length - 1) {
        alert("You can't use '.' in beginning or end of an e-mail.");
        return false;
    }

    var splitEmail = email.split('@');
    var periodIndex = splitEmail[1].indexOf('.');

    if (periodIndex == -1) {
        alert("You need to add atleast one '.' after '@' in an e-mail.");
        return false;
    }

    if (periodIndex == 0) {
        alert("You can't use '.' directly after '@' in an e-mail.");
        return false;
    }

    return true;
}

/**
 * Return the number of occurrences of a string in a string.
 *
 * @param  String   haystack  the string to look at
 * @param  String   needle    the string to search for
 *
 * @return int                number of occurrences
 */
function numberOfOccurrences(haystack, needle)
{
    return haystack.split(needle).length - 1;
}
