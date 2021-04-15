package com.mindtree.services

import com.mindtree.dao.ConnectDB
import groovy.sql.GroovyRowResult
import org.springframework.beans.factory.annotation.Autowired

trait CovidDataService {
    /*@Autowired
    ConnectDB conn*/

    List getAllStates(ConnectDB conn) {
        // List<GroovyRowResult> resultList
        conn.connect()
        List<GroovyRowResult> allDataList = conn.getAllData()
        List stateList = []
        allDataList.sort().each {
            stateList.add(it.state)
            stateList.unique()
        }
    }
}
