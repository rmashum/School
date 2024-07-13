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
            <input
                type="text"
                name="state"
                value={school.state}
                onChange={handleChange}
                placeholder="State"
            />
            <input
                type="text"
                name="district"
                value={school.district}
                onChange={handleChange}
                placeholder="District"
            />
            <input
                type="text"
                name="block"
                value={school.block}
                onChange={handleChange}
                placeholder="Block"
            />
            <input
                type="text"
                name="ruralUrban"
                value={school.ruralUrban}
                onChange={handleChange}
                placeholder="Rural/Urban"
            />
            <input
                type="text"
                name="cluster"
                value={school.cluster}
                onChange={handleChange}
                placeholder="Cluster"
            />
            <input
                type="text"
                name="ward"
                value={school.ward}
                onChange={handleChange}
                placeholder="Ward"
            />
            <input
                type="text"
                name="mohalla"
                value={school.mohalla}
                onChange={handleChange}
                placeholder="Mohalla"
            />
            <input
                type="text"
                name="pincode"
                value={school.pincode}
                onChange={handleChange}
                placeholder="Pincode"
            />
            <input
                type="text"
                name="panchayat"
                value={school.panchayat}
                onChange={handleChange}
                placeholder="Panchayat"
            />
            <input
                type="text"
                name="city"
                value={school.city}
                onChange={handleChange}
                placeholder="City"
            />
            <input
                type="text"
                name="municipality"
                value={school.municipality}
                onChange={handleChange}
                placeholder="Municipality"
            />
            <input
                type="text"
                name="assemblyConstituency"
                value={school.assemblyConstituency}
                onChange={handleChange}
                placeholder="Assembly Constituency"
            />
            <input
                type="text"
                name="parliamentaryConstituency"
                value={school.parliamentaryConstituency}
                onChange={handleChange}
                placeholder="Parliamentary Constituency"
            />
            <input
                type="text"
                name="schoolCategory"
                value={school.schoolCategory}
                onChange={handleChange}
                placeholder="School Category"
            />
            <input
                type="text"
                name="schoolManagement"
                value={school.schoolManagement}
                onChange={handleChange}
                placeholder="School Management"
            />
            <input
                type="text"
                name="schoolType"
                value={school.schoolType}
                onChange={handleChange}
                placeholder="School Type"
            />
            <input
                type="text"
                name="lowestClass"
                value={school.lowestClass}
                onChange={handleChange}
                placeholder="Lowest Class"
            />
            <input
                type="text"
                name="highestClass"
                value={school.highestClass}
                onChange={handleChange}
                placeholder="Highest Class"
            />
            <input
                type="text"
                name="affiliationBoardSec"
                value={school.affiliationBoardSec}
                onChange={handleChange}
                placeholder="Affiliation Board (Secondary)"
            />
            <input
                type="text"
                name="affiliationBoardHSec"
                value={school.affiliationBoardHSec}
                onChange={handleChange}
                placeholder="Affiliation Board (Higher Secondary)"
            />
            <input
                type="text"
                name="isShiftSchool"
                value={school.isShiftSchool}
                onChange={handleChange}
                placeholder="Is Shift School"
            />
            <input
                type="text"
                name="buildingStatus"
                value={school.buildingStatus}
                onChange={handleChange}
                placeholder="Building Status"
            />
            <input
                type="text"
                name="boundaryWall"
                value={school.boundaryWall}
                onChange={handleChange}
                placeholder="Boundary Wall"
            />
            <input
                type="text"
                name="noOfBuildingBlocks"
                value={school.noOfBuildingBlocks}
                onChange={handleChange}
                placeholder="No. of Building Blocks"
            />
            <input
                type="text"
                name="specialSchoolForCWSN"
                value={school.specialSchoolForCWSN}
                onChange={handleChange}
                placeholder="Special School for CWSN"
            />
            <input
                type="text"
                name="residentialSchool"
                value={school.residentialSchool}
                onChange={handleChange}
                placeholder="Residential School"
            />
            <input
                type="text"
                name="residentialType"
                value={school.residentialType}
                onChange={handleChange}
                placeholder="Residential Type"
            />
            <input
                type="text"
                name="minoritySchool"
                value={school.minoritySchool}
                onChange={handleChange}
                placeholder="Minority School"
            />
            <input
                type="text"
                name="approachableByRoad"
                value={school.approachableByRoad}
                onChange={handleChange}
                placeholder="Approachable by Road"
            />
            <label>
                Drinking Water Available
                <input
                    type="checkbox"
                    name="drinkingWaterAvailable"
                    checked={school.drinkingWaterAvailable}
                    onChange={handleChange}
                />
            </label>
            <label>
                Electricity Available
                <input
                    type="checkbox"
                    name="electricityAvailable"
                    checked={school.electricityAvailable}
                    onChange={handleChange}
                />
            </label>
            <label>
                Playground Available
                <input
                    type="checkbox"
                    name="playgroundAvailable"
                    checked={school.playgroundAvailable}
                    onChange={handleChange}
                />
            </label>
            <label>
                Library Available
                <input
                    type="checkbox"
                    name="libraryAvailable"
                    checked={school.libraryAvailable}
                    onChange={handleChange}
                />
            </label>
            <label>
                Internet Available
                <input
                    type="checkbox"
                    name="internetAvailable"
                    checked={school.internetAvailable}
                    onChange={handleChange}
                />
            </label>
            <button type="submit">{selectedSchool ? 'Update' : 'Add'} School</button>
            <button type="button" onClick={resetForm}>Clear</button>
        </form>
    );
};

export default SchoolForm;
