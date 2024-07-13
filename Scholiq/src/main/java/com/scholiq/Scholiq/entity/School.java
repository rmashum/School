package com.scholiq.Scholiq.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String udiseCode;
    private String name;
    private String state;
    private String district;
    private String block;
    private String ruralUrban;
    private String cluster;
    private String ward;
    private String mohalla;
    private String pincode;
    private String panchayat;
    private String city;
    private String municipality;
    private String assemblyConstituency;
    private String parliamentaryConstituency;
    private String schoolCategory;
    private String schoolManagement;
    private String schoolType;
    private String lowestClass;
    private String highestClass;
    private String affiliationBoardSec;
    private String affiliationBoardHSec;
    private String isShiftSchool;
    private String buildingStatus;
    private String boundaryWall;
    private int noOfBuildingBlocks;
    private String specialSchoolForCWSN;
    private String residentialSchool;
    private String residentialType;
    private String minoritySchool;
    private String approachableByRoad;
    private boolean drinkingWaterAvailable;
    private boolean electricityAvailable;
    private boolean playgroundAvailable;
    private boolean libraryAvailable;
    private boolean internetAvailable;

    // Getters and Setters
}
