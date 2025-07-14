import React, { useState } from 'react';

const Login = ({ onLogin }) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  const handleLogin = (e) => {
    e.preventDefault();
    if (email === 'admin@gmail.com' && password === 'admin') {
      onLogin();
    } else {
      setError('Invalid email or password');
    }
  };

  return (
    <div style={styles.card}>
      <h2 style={styles.title}>Login</h2>
      <form onSubmit={handleLogin} style={styles.form}>
        <input
          type="email"
          placeholder="Email"
          style={styles.input}
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          style={styles.input}
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        {error && <p style={styles.error}>{error}</p>}
        <button type="submit" style={styles.button}>Login</button>
      </form>
    </div>
  );
};

const styles = {
  card: {
    width: '100%',
    maxWidth: '350px',
    padding: '30px',
    background: '#fff',
    borderRadius: '10px',
    boxShadow: '0 4px 10px rgba(0, 0, 0, 0.1)'
  },
  title: {
    marginBottom: '20px',
    textAlign: 'center'
  },
  form: {
    display: 'flex',
    flexDirection: 'column'
  },
  input: {
    padding: '10px',
    marginBottom: '15px',
    borderRadius: '5px',
    border: '1px solid #ccc'
  },
  button: {
    padding: '10px',
    backgroundColor: '#4CAF50',
    color: 'white',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer'
  },
  error: {
    color: 'red',
    textAlign: 'center'
  }
};

export default Login;
