package com.mindtree.dao

import com.mindtree.services.CovidDataServiceImpl
import groovy.sql.GroovyRowResult
import groovy.sql.Sql

import java.text.SimpleDateFormat

String url = "jdbc:postgresql://localhost:5432/covid_analysis"
String username = "postgres"
String pwd = "password"
def dbDriver   = "org.postgresql.Driver"

def sql = Sql.newInstance(url, username, pwd, dbDriver)
println("DB connected")
List<GroovyRowResult> resultList = sql.rows("select * from tcovid_data")
println(resultList[0])
println("\t")

ConnectDB db = new ConnectDB()
db.connect()

/*print "1. Get States Names \n" +
        "\n Please select Option : "
def name = System.in.newReader().readLine()
List stateList = db.getAllStates()
stateList.sort().each {
    println("\t $it")
}*/

/*print "2. Get District name for given states \n" +
        "\n Please enter State code : "
def stateCode = System.in.newReader().readLine()
List allData = db.getAllData()
allData.each {
    if(it.state == stateCode){
        println("\t$it.district")GroovyRowResult
    }
}*/

/*print "3. Display data by state within state range \n" +
        "\n Please enter start Date : "
def startDt = System.in.newReader().readLine()
print "\n Please enter end Date : "
def endDt = System.in.newReader().readLine()
List allData = db.getAllData()
int count = 0
allData.each {
    //Date orgDt = it.date
    String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(it.date);
    if(formattedDate >= startDt && formattedDate <= endDt) {
        if(count == 0){
            println("DATE         |   STATE     |   CONFIRMED TOTAL")
            count++
        }
        println(formattedDate + "   |   "+ it.state + "        |   " + it.confirmed)
    }
}*/

/*print "4. Display Confirmed cases by comparing two states for a given date range \n" +
        "\n Please enter start Date : "
def startDt = System.in.newReader().readLine()
print "\n Please enter end Date : "
def endDt = System.in.newReader().readLine()
print "\n Please enter first state code : "
def firstState = System.in.newReader().readLine()
print "\n Please enter second state code : "
def secondState = System.in.newReader().readLine()*/

CovidDataServiceImpl impl = new CovidDataServiceImpl()
println(impl.getAllStates())

sql.close()