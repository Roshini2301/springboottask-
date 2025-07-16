import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Register = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [role, setRole] = useState('User');
  const navigate = useNavigate();

  const handleRegister = (e) => {
    e.preventDefault();
    const userData = { name, email, password, role };
    localStorage.setItem('user', JSON.stringify(userData));
    alert('Registration successful!');
    navigate('/login');
  };

  return (
    <form onSubmit={handleRegister}>
      <h2>Register</h2>
      <label>Name</label>
      <input type="text" required onChange={(e) => setName(e.target.value)} />
      <label>Email</label>
      <input type="email" required onChange={(e) => setEmail(e.target.value)} />
      <label>Password</label>
      <input type="password" required onChange={(e) => setPassword(e.target.value)} />
      <label>Role</label>
      <select onChange={(e) => setRole(e.target.value)}>
        <option value="User">User</option>
        <option value="Admin">Admin</option>
      </select>
      <button type="submit">Register</button>
    </form>
  );
};

export default Register;