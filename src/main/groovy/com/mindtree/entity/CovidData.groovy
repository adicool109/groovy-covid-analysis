package com.mindtree.entity

import groovy.transform.Canonical
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
//import java.util.Date
//import java.sql.Date
import java.sql.Timestamp

@Canonical
@Entity
@Table(name="tcovid_data")
class CovidData {
    Timestamp date
    String state
    String district
    String tested
    String confirmed
    String recovered
    @Id
    int id
}
