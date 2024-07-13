// src/App.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import SchoolForm from './components/SchoolForm';
import SchoolsList from './components/SchoolsList';

const School = () => {
    const [schools, setSchools] = useState([]);
    const [selectedSchool, setSelectedSchool] = useState(null);

    const fetchSchools = async () => {
        const response = await axios.get('http://localhost:8888/schools');
        setSchools(response.data);
    };

    useEffect(() => {
        fetchSchools();
    }, []);

    const clearSelection = () => {
        setSelectedSchool(null);
    };

    return (
        <div>
            <h1>School Management</h1>
            <SchoolForm
                selectedSchool={selectedSchool}
                refreshSchools={fetchSchools}
                clearSelection={clearSelection}
            />
            <SchoolsList
                schools={schools}
                setSelectedSchool={setSelectedSchool}
                refreshSchools={fetchSchools}
            />
        </div>
    );
};

export default School;
