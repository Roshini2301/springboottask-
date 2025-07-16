import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const AddEmployee = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const navigate = useNavigate();

  const handleAdd = (e) => {
    e.preventDefault();
    const existing = JSON.parse(localStorage.getItem('employees')) || [];
    const newEmp = { name, email };
    localStorage.setItem('employees', JSON.stringify([...existing, newEmp]));
    alert('Employee added');
    navigate('/employees');
  };

  return (
    <form onSubmit={handleAdd}>
      <h2>Add Employee</h2>
      <label>Name</label>
      <input type="text" required onChange={(e) => setName(e.target.value)} />
      <label>Email</label>
      <input type="email" required onChange={(e) => setEmail(e.target.value)} />
      <button type="submit">Add</button>
    </form>
  );
};

export default AddEmployee;