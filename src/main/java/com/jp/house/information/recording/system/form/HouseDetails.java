package com.jp.house.information.recording.system.form;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "house_owner")

@SecondaryTables({@SecondaryTable(name="land_details"),
@SecondaryTable(name = "house_details"),
        @SecondaryTable(name = "construction_details"),
        @SecondaryTable(name = "storage_details")
})

//
//@SecondaryTable(name = "land_details")
//@SecondaryTable(name="house_details")
public class HouseDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "owner_id")
    private Long id;


    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;


    @Column(name = "current_address")
    private String currentAddress;


    @Column(name = "citizenship_no")
    private String citizenShipNo;

//enum type
    @Column(name = "citizenship_issued_district")
    private District citizenShipIssuedDistrict;


    @Column(name = "citizenship_issued_date")
    private String citizenShipIssuedDate;

    @Column(name = "contact_number")
    private String contactNumber;


    @Column(name = "citizenship_doc", length = 69)
    private String citizenShipDocuments;

    @CreationTimestamp
    @Column(name = "record_created_on")
    private LocalDateTime recordCreated;

    @UpdateTimestamp
    @Column(name = "record_updated_on")
    private LocalDateTime recordUpdated;


//--------------------------------------->
    @Column(table = "land_details")
    private String kittaNumber;

    @Column(table = "land_details")
    private Double landArea;

    @Column(table = "land_details")
    private String oldVdcMunicipalityName;

    @Column(table = "land_details")
    private Integer oldWardNo;

    @Column(table = "land_details")
    private String newMunicipalityName;

    @Column(table = "land_details")
    private WardNumber newWardNo;

//---------------------------------------------
    @Column(table = "house_details")
    private String houseNumber;

    @Column(table = "house_details")
    private String houseLatitude;

    @Column(table = "house_details")
    private String houseLongitude;

    @Column(table = "house_details")
    private Double plinthArea;

    @Column(table = "house_details")
    private Integer totalStoreyed;

    @Column(table = "house_details")
    private Double totalAreaCoveredByHouse;


    @Column(table = "construction_details")
    private String consultancyFirm;

    @Column(table = "construction_details")
    private String constructionStarted;

    @Column(table = "construction_details")
    private String constructionCompleted;

    @Column(table = "construction_details")
    private String planMap;


    @Column(table = "construction_details")
    private String finalCompletionLetter;


    @Column(table = "storage_details")
    private String bookColor;

    @Column(table = "storage_details")
    private Integer roomNo;

    @Column(table = "storage_details")
    private Integer racko;

    @Column(table = "storage_details")
    private Integer cabinNo;


}
