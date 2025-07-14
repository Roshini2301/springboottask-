import React, { useState } from 'react';

const Dashboard = ({ onLogout }) => {
  const [employees, setEmployees] = useState([
    { id: 1, name: 'Alice', role: 'Developer' },
    { id: 2, name: 'Bob', role: 'Manager' }
  ]);

  const [formData, setFormData] = useState({ name: '', role: '', id: null });
  const [isEditing, setIsEditing] = useState(false);

  const handleAddOrUpdate = (e) => {
    e.preventDefault();
    if (!formData.name || !formData.role) return;

    if (isEditing) {
      // Update
      setEmployees(employees.map(emp =>
        emp.id === formData.id ? { ...formData } : emp
      ));
      setIsEditing(false);
    } else {
      // Add
      const newEmployee = {
        id: Date.now(),
        name: formData.name,
        role: formData.role
      };
      setEmployees([...employees, newEmployee]);
    }

    setFormData({ name: '', role: '', id: null });
  };

  const handleEdit = (emp) => {
    setFormData(emp);
    setIsEditing(true);
  };

  const handleDelete = (id) => {
    setEmployees(employees.filter(emp => emp.id !== id));
    if (isEditing && formData.id === id) {
      setIsEditing(false);
      setFormData({ name: '', role: '', id: null });
    }
  };

  return (
    <div style={styles.container}>
      <h1>Employee Dashboard</h1>

      <form onSubmit={handleAddOrUpdate} style={styles.form}>
        <input
          type="text"
          placeholder="Employee Name"
          value={formData.name}
          onChange={(e) => setFormData({ ...formData, name: e.target.value })}
          style={styles.input}
        />
        <input
          type="text"
          placeholder="Role"
          value={formData.role}
          onChange={(e) => setFormData({ ...formData, role: e.target.value })}
          style={styles.input}
        />
        <button type="submit" style={styles.button}>
          {isEditing ? 'Update Employee' : 'Add Employee'}
        </button>
      </form>

      <ul style={styles.list}>
        {employees.map(emp => (
          <li key={emp.id} style={styles.listItem}>
            <span>{emp.name} - {emp.role}</span>
            <div>
              <button onClick={() => handleEdit(emp)} style={styles.edit}>Edit</button>
              <button onClick={() => handleDelete(emp.id)} style={styles.delete}>Delete</button>
            </div>
          </li>
        ))}
      </ul>

      <button onClick={onLogout} style={styles.logout}>Logout</button>
    </div>
  );
};

const styles = {
  container: {
    padding: '40px',
    fontFamily: 'Arial, sans-serif'
  },
  form: {
    marginBottom: '20px',
    display: 'flex',
    gap: '10px',
    flexWrap: 'wrap'
  },
  input: {
    padding: '10px',
    flex: '1 1 200px',
    border: '1px solid #ccc',
    borderRadius: '5px'
  },
  button: {
    padding: '10px 16px',
    backgroundColor: '#4CAF50',
    color: 'white',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer'
  },
  list: {
    listStyle: 'none',
    padding: 0
  },
  listItem: {
    display: 'flex',
    justifyContent: 'space-between',
    padding: '10px 0',
    borderBottom: '1px solid #ccc'
  },
  edit: {
    marginRight: '10px',
    backgroundColor: '#2196F3',
    color: 'white',
    border: 'none',
    padding: '5px 10px',
    borderRadius: '4px',
    cursor: 'pointer'
  },
  delete: {
    backgroundColor: '#f44336',
    color: 'white',
    border: 'none',
    padding: '5px 10px',
    borderRadius: '4px',
    cursor: 'pointer'
  },
  logout: {
    marginTop: '30px',
    backgroundColor: '#333',
    color: 'white',
    padding: '10px 20px',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer'
  }
};

export default Dashboard;
