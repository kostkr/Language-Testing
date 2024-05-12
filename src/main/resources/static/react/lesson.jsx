import React, { useState } from 'react';

function QuizComponent({ lesson }) {
    const [questions, setQuestions] = useState(lesson.getQuestions());
    const [correctAnswers, setCorrectAnswers] = useState(lesson.getAnswersCorrect());
    const [wrongAnswers, setWrongAnswers] = useState(lesson.getAnswersWrong());

    const splitAnswers = (answers) => {
        return answers.split('; ');
    };

    const shuffleArray = (array) => {
        for (let i = array.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [array[i], array[j]] = [array[j], array[i]];
        }
        return array;
    };

    const displayQuestionsAndAnswers = () => {
        return questions.map((question, index) => {
            const correctAnswersArray = splitAnswers(correctAnswers[index]);
            const wrongAnswersArray = splitAnswers(wrongAnswers[index]);
            let answers = [];

            correctAnswersArray.forEach((answer) =>
                answers.push({ text: answer, isCorrect: true })
            );
            wrongAnswersArray.forEach((answer) =>
                answers.push({ text: answer, isCorrect: false })
            );

            answers = shuffleArray(answers);

            return (
                <div key={index}>
                    <div>{index + 1}) {question}</div>
                    {answers.map((answer, idx) => (
                        <div
                            key={idx}
                            className="answer-box"
                            onClick={() => handleAnswerClick(answer)}
                            style={{ cursor: 'pointer' }}
                        >
                            {answer.text}
                        </div>
                    ))}
                    <div style={{ margin: '30px' }} />
                </div>
            );
        });
    };

    const handleAnswerClick = (answer) => {
        const answerBoxes = document.querySelectorAll('.answer-box');
        answerBoxes.forEach((box) => {
            box.style.backgroundColor = ''; // Reset background color for all boxes
        });

        if (answer.isCorrect) {
            // Change background color to green for correct answer
            document.querySelector(`.answer-box[data-text="${answer.text}"]`).style.backgroundColor = 'green';
        } else {
            // Change background color to red for wrong answer
            document.querySelector(`.answer-box[data-text="${answer.text}"]`).style.backgroundColor = 'red';
        }
    };

    return <div>{displayQuestionsAndAnswers()}</div>;
}

export default QuizComponent;
