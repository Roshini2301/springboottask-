import { useState, useEffect } from 'react';

const EmployeeList = () => {
  const [employees, setEmployees] = useState([]);
  const user = JSON.parse(localStorage.getItem('user'));

  useEffect(() => {
    const stored = JSON.parse(localStorage.getItem('employees')) || [];
    setEmployees(stored);
  }, []);

  const handleDelete = (index) => {
    const updated = employees.filter((_, i) => i !== index);
    localStorage.setItem('employees', JSON.stringify(updated));
    setEmployees(updated);
  };

  return (
    <div>
      <h2>Employee List</h2>
      <ul>
        {employees.map((emp, index) => (
          <li key={index}>
            {emp.name} - {emp.email}
            {user.role === 'Admin' && (
              <button onClick={() => handleDelete(index)}>Delete</button>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default EmployeeList;
