// src/components/SchoolForm.jsx
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const SchoolForm = ({ selectedSchool, refreshSchools, clearSelection }) => {
    const [school, setSchool] = useState({
        udiseCode: '',
        name: '',
        state: '',
        district: '',
        block: '',
        ruralUrban: '',
        cluster: '',
        ward: '',
        mohalla: '',
        pincode: '',
        panchayat: '',
        city: '',
        municipality: '',
        assemblyConstituency: '',
        parliamentaryConstituency: '',
        schoolCategory: '',
        schoolManagement: '',
        schoolType: '',
        lowestClass: '',
        highestClass: '',
        affiliationBoardSec: '',
        affiliationBoardHSec: '',
        isShiftSchool: '',
        buildingStatus: '',
        boundaryWall: '',
        noOfBuildingBlocks: '',
        specialSchoolForCWSN: '',
        residentialSchool: '',
        residentialType: '',
        minoritySchool: '',
        approachableByRoad: '',
        drinkingWaterAvailable: false,
        electricityAvailable: false,
        playgroundAvailable: false,
        libraryAvailable: false,
        internetAvailable: false
    });

    useEffect(() => {
        if (selectedSchool) {
            setSchool(selectedSchool);
        } else {
            resetForm();
        }
    }, [selectedSchool]);

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setSchool((prevSchool) => ({
            ...prevSchool,
            [name]: type === 'checkbox' ? checked : value,
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (selectedSchool) {
            await axios.put(`http://localhost:8888/schools/${selectedSchool.id}`, school);
        } else {
            await axios.post('http://localhost:8888/schools', school);
        }
        refreshSchools();
        clearSelection();
    };

    const resetForm = () => {
        setSchool({
            udiseCode: '',
            name: '',
            state: '',
            district: '',
            block: '',
            ruralUrban: '',
            cluster: '',
            ward: '',
            mohalla: '',
            pincode: '',
            panchayat: '',
            city: '',
            municipality: '',
            assemblyConstituency: '',
            parliamentaryConstituency: '',
            schoolCategory: '',
            schoolManagement: '',
            schoolType: '',
            lowestClass: '',
            highestClass: '',
            affiliationBoardSec: '',
            affiliationBoardHSec: '',
            isShiftSchool: '',
            buildingStatus: '',
            boundaryWall: '',
            noOfBuildingBlocks: '',
            specialSchoolForCWSN: '',
            residentialSchool: '',
            residentialType: '',
            minoritySchool: '',
            approachableByRoad: '',
            drinkingWaterAvailable: false,
            electricityAvailable: false,
            playgroundAvailable: false,
            libraryAvailable: false,
            internetAvailable: false
        });
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                name="udiseCode"
                value={school.udiseCode}
                onChange={handleChange}
                placeholder="UDISE Code"
            />
            <input
                type="text"
                name="name"
                value={school.name}
                onChange={handleChange}
                placeholder="School Name"
            />
            {/* Add other input fields similarly */}
            <button type="submit">{selectedSchool ? 'Update' : 'Add'} School</button>
            <button type="button" onClick={resetForm}>Clear</button>
        </form>
    );
};

export default SchoolForm;
