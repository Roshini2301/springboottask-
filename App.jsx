import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Link, Navigate } from 'react-router-dom';
import Home from './pages/Home';
import Login from './pages/Login';
import Dashboard from './pages/Dashboard';

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  return (
    <Router>
      <div>
        {/* Navbar */}
        <nav style={styles.navbar}>
          <Link to="/" style={styles.navLink}>Home</Link>
          {!isAuthenticated && (
            <Link to="/login" style={styles.loginButton}>Login</Link>
          )}
        </nav>

        {/* Page Routes */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={
            isAuthenticated ? <Navigate to="/dashboard" /> :
              <div style={styles.centeredPage}>
                <Login onLogin={() => setIsAuthenticated(true)} />
              </div>
          } />
          <Route path="/dashboard" element={
            isAuthenticated ? (
              <Dashboard onLogout={() => setIsAuthenticated(false)} />
            ) : (
              <Navigate to="/login" />
            )
          } />
        </Routes>
      </div>
    </Router>
  );
}

const styles = {
  navbar: {
    display: 'flex',
    justifyContent: 'space-between',
    padding: '10px 30px',
    backgroundColor: '#333',
    color: '#fff',
    alignItems: 'center'
  },
  navLink: {
    color: '#fff',
    textDecoration: 'none',
    fontSize: '18px'
  },
  loginButton: {
    backgroundColor: '#4CAF50',
    padding: '8px 14px',
    borderRadius: '5px',
    color: '#fff',
    textDecoration: 'none'
  },
  centeredPage: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    height: '100vh',
    backgroundColor: '#f0f2f5'
  }
};

export default App;
