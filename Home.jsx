import React from 'react';

const Home = () => {
  return (
    <div style={styles.container}>
      <h1>Welcome to the Employee Management System</h1>
      <p>Click on "Login" to access the dashboard.</p>
    </div>
  );
};

const styles = {
  container: {
    padding: '40px',
    textAlign: 'center',
    fontFamily: 'Arial, sans-serif'
  }
};

export default Home;
