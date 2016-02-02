/**
 * Score functions
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

function getAverageScore(arrScores)
{
    var sum = 0;

    for (var i = 0; i < arrScores.length; i++)
    {
        sum += arrScores[i];
    }

    return sum / arrScores.length;
}

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
 * Employee functions
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
    validateZipCode(form.zipcode.value);

    return false;
}

function validateZipCode(zipCode)
{
    if (zipCode.length != 10 && zipCode.length != 5) {
        return false;
    }

    var arrZipCode = zipCode.split('');

    for (var i in arrZipCode)
    {
        if (isNaN(arrZipCode[i])) {
            return false;
        }
    }

    return true;
}
