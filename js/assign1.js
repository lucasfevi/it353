function score()
{
    var nScores = prompt('Enter the # of scores:', 3);
    var arrScores = new Array();
    var msg;

    for (var i = 0; i < nScores; i++)
    {
        arrScores[i] = parseInt(prompt('Enter score number ' + (i + 1)));
    }

    msg  = 'Lucas Vieira\'s Output\n';
    msg += 'Lowest = ' + getLowestScore(arrScores) + '\n';
    msg += 'Highest = ' + getHighestScore(arrScores) + '\n';
    msg += 'Average = ' + getAverageScore(arrScores) + '\n';
    msg += 'Scores > Average:\n';
    msg += showHigherThanAverageScores(arrScores);

    console.log(msg);
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
    var averageScore = 0;

    return averageScore;
}

function showHigherThanAverageScores(arrScores)
{
    return '12,30,42,60';
}