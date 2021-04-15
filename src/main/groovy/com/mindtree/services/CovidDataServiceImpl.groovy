package com.mindtree.services

import com.mindtree.dao.ConnectDB
import groovy.sql.GroovyRowResult
import org.springframework.beans.factory.annotation.Autowired

class CovidDataServiceImpl implements CovidDataService {

    final def conn

    /*beans = {

        // Pass constructor arguments: ref('languageService') and '^Gr.*'
        // to LanguageProvider.
        conn(ConnectDB, ref('conn'), '^Gr.*')

    }*/

    @Override
    List getAllStates(ConnectDB conn1) {
        //ConnectDB conn = new ConnectDB()
        conn.connect()
        List<GroovyRowResult> allDataList = conn.getAllData()
        List stateList = []
        allDataList.sort().each {
            stateList.add(it.state)
            stateList.unique()
        }
    }
}
