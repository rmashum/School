// src/components/SchoolsList.js
import React from 'react';
import axios from 'axios';

const SchoolsList = ({ schools, setSelectedSchool, refreshSchools }) => {

    const handleDelete = async (id) => {
        await axios.delete(`http://localhost:8080/schools/${id}`);
        refreshSchools();
    };

    return (
        <ul>
            {schools.map((school) => (
                <li key={school.id}>
                    {school.name} - {school.udiseCode}
                    <button onClick={() => setSelectedSchool(school)}>Edit</button>
                    <button onClick={() => handleDelete(school.id)}>Delete</button>
                </li>
            ))}
        </ul>
    );
};

export default SchoolsList;
