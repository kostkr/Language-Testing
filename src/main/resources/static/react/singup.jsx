import React, { Component } from 'react';

class SignUpForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            passwordError: '',
            password2Error: ''
        };
    }

    validatePassword = () => {
        const passwordInput = document.getElementById('password');
        const passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,40}$/;
        if (!passwordPattern.test(passwordInput.value)) {
            this.setState({ passwordError: 'Password must contain at least 8 characters, including at least one number, one lowercase letter, and one uppercase letter.' });
            return false;
        } else {
            this.setState({ passwordError: '' });
            return true;
        }
    };

    checkPassword = () => {
        const passwordInput = document.getElementById('password');
        const passwordInput2 = document.getElementById('password2');
        if (passwordInput.value !== passwordInput2.value) {
            this.setState({ password2Error: 'Passwords do not match.' });
            return false;
        } else {
            this.setState({ password2Error: '' });
            return true;
        }
    };

    handleSubmit = (event) => {
        event.preventDefault();
        const isPasswordValid = this.validatePassword();
        const isPassword2Valid = this.checkPassword();
        if (isPasswordValid && isPassword2Valid) {
            console.log('Form submitted successfully');
        }
    };

    render() {
        return (
            <section className="vh-100 bg-image" style={{ backgroundImage: "url('https://comparic.pl/wp-content/uploads/2021/06/doge-shiba.jpg')" }}>
                <div className="mask d-flex align-items-center h-100 gradient-custom-3">
                    <div className="container h-100">
                        <div className="row d-flex justify-content-center align-items-center h-100">
                            <div className="col-12 col-md-9 col-lg-7 col-xl-6">
                                <div className="card bg" style={{ borderRadius: '15px' }}>
                                    <div className="card-body p-5">
                                        <h2 className="text-uppercase text-center mb-5">Create an account</h2>
                                        <form onSubmit={this.handleSubmit} id="signUpUser">
                                            <div className="form-outline mb-4">
                                                <label htmlFor="name">Name</label>
                                                <input type="text" id="name" name="name" className="form-control form-control-lg" required />
                                            </div>

                                            <div className="form-outline mb-4">
                                                <label htmlFor="email">Email</label>
                                                <input type="email" id="email" name="email" className="form-control form-control-lg" required />
                                            </div>

                                            <div className="form-outline mb-4">
                                                <label htmlFor="password">Password</label>
                                                <input type="password" id="password" name="password" className="form-control form-control-lg" required />
                                                <div id="error-nwl" style={{ color: 'red' }}>{this.state.passwordError}</div>
                                            </div>

                                            <div className="form-outline mb-4">
                                                <label htmlFor="password2">Repeat password</label>
                                                <input type="password" id="password2" className="form-control form-control-lg" required />
                                                <div id="error-nwl2" style={{ color: 'red' }}>{this.state.password2Error}</div>
                                            </div>

                                            <div className="d-flex justify-content-center">
                                                <button type="submit" className="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
                                            </div>
                                        </form>
                                        <p className="text-center text-muted mt-5 mb-0">Have already an account? <a href="/login" className="fw-bold text-body"><u>Login here</u></a></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        );
    }
}

export default SignUpForm;
