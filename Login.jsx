import React, { useState } from 'react';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  const handleLogin = (e) => {
    e.preventDefault();
    if (!email || !password) {
      setError('Please enter both email and password');
    } else {
      setError('');
      alert('Login Successful!');
    }
  };

  return (
    <div style={styles.fullScreenWrapper}>
      <div style={styles.loginBox}>
        <h2 style={styles.title}>Login</h2>
        <form onSubmit={handleLogin} style={styles.form}>
          <input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            style={styles.input}
          />
          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            style={styles.input}
          />
          {error && <p style={styles.error}>{error}</p>}
          <button type="submit" style={styles.button}>Login</button>
        </form>
      </div>
    </div>
  );
};

const styles = {
  fullScreenWrapper: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    height: '100vh',
    width: '100vw',
    backgroundColor: '#f0f2f5',
  },
  loginBox: {
    width: '100%',
    maxWidth: 400,
    padding: 30,
    borderRadius: 10,
    backgroundColor: '#fff',
    boxShadow: '0 0 10px rgba(0,0,0,0.1)',
    fontFamily: 'Arial, sans-serif'
  },
  title: {
    textAlign: 'center',
    marginBottom: 20
  },
  form: {
    display: 'flex',
    flexDirection: 'column'
  },
  input: {
    padding: 10,
    marginBottom: 15,
    borderRadius: 5,
    border: '1px solid #ccc'
  },
  button: {
    padding: 10,
    backgroundColor: '#4CAF50',
    color: '#fff',
    border: 'none',
    borderRadius: 5,
    cursor: 'pointer'
  },
  error: {
    color: 'red',
    marginBottom: 10,
    textAlign: 'center'
  }
};

export default Login;
