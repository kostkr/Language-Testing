import React, { useState } from 'react';

function FormCreator() {
    const [formCounter, setFormCounter] = useState(0);

    function addForm() {
        setFormCounter(prevCounter => prevCounter + 1);
    }

    function addAnswer(container, placeholder, questionNumber, isCorrect) {
        const inputCount = container.querySelectorAll('input').length / 2;

        const answerDiv = (
            <div className="answer-input">
                <input
                    type="text"
                    className="form-control mt-2"
                    name={isCorrect ? 'answersCorrect[]' : 'answersWrong[]'}
                    placeholder={`${placeholder} ${inputCount + 1}`}
                />
                <input
                    type="hidden"
                    name={isCorrect ? 'questionNumberCorrect[]' : 'questionNumberWrong[]'}
                    value={questionNumber}
                />
            </div>
        );

        container.appendChild(answerDiv);
    }

    function addAnswerContainer(container, formCounter, isCorrect) {
        const newContainer = (
            <div id={isCorrect ? `correctAnswers${formCounter}` : `wrongAnswers${formCounter}`}>
                {/* Render initial correct/wrong answer input */}
                {addAnswer(container, isCorrect ? 'Correct Answer' : 'Wrong Answer', formCounter, isCorrect)}
            </div>
        );

        container.appendChild(newContainer);
    }

    return (
        <div>
            <button onClick={addForm}>Add Form</button>
            <div>
                {[...Array(formCounter)].map((_, index) => (
                    <div key={index} className="form-group">
                        {/* Render question input */}
                        <input
                            type="text"
                            className="form-control mt-2"
                            name="questions[]"
                            placeholder="Question"
                        />

                        {/* Render correct and wrong answer divs */}
                        <div id={`correctAnswers${index}`} />
                        <div id={`wrongAnswers${index}`} />

                        {/* Render buttons to add more answers */}
                        <button
                            type="button"
                            className="btn btn-secondary mt-2"
                            onClick={() => addAnswerContainer(document.getElementById(`correctAnswers${index}`), index, true)}
                        >
                            Add Correct Answer
                        </button>
                        <button
                            type="button"
                            className="btn btn-secondary mt-2 ms-2"
                            onClick={() => addAnswerContainer(document.getElementById(`wrongAnswers${index}`), index, false)}
                        >
                            Add Wrong Answer
                        </button>
                    </div>
                ))}
            </div>
        </div>
    );
}


export default DynamicForm;
