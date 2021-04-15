package com.mindtree.dao

import com.mindtree.entity.CovidData
import groovy.sql.Sql
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

class ConnectDB {
    Map dbConnParams = [
            url: 'jdbc:postgresql://localhost:5432/covid_analysis',
            user: 'postgres',
            password: 'password',
            driver: 'org.postgresql.Driver']
    Sql sql

    @PostConstruct
    void connect(){
        sql = Sql.newInstance(dbConnParams)
    }

    @PreDestroy
    void close(){
        sql.close()
    }

    CovidData mapData(def row){
        CovidData user = new CovidData(id: row.id, date: row.date, state: row.state, district: row.district,
                tested: row.tested, confirmed: row.confirmed, recovered: row.recovered)
    }

    List getAllData() {
        List rowsList = []
        sql.eachRow("SELECT * FROM tcovid_data") {row ->
            rowsList.add(mapData(row))
        }
        return rowsList
    }

    List getAllStates() {
        List rowsList = []
        sql.eachRow("select distinct state from tcovid_data") {row ->
            //println(row.toString())
            rowsList.add(row.state)
        }
        return rowsList
    }
}
