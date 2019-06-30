val Strava = setOf("SRT", "CVT", "Perkiomen")
val RWGPS = setOf("CVT", "Perkiomen", "Welsh Mountain")
val Komoot = setOf("SRT", "Welsh Mountain", "Oaks to Philly")

fun allRoutes() {
    val allRoutes = mutableListOf<String>()
    for (i in 0..Strava.size + RWGPS.size + Komoot.size) {
        when {
            i < 3 -> {
                allRoutes.add("\"${Strava.elementAt(i)}\"")
            }
            i < 6 -> {
                allRoutes.add("\"${RWGPS.elementAt(i - 3)}\"")
            }
            i < 9 -> {
                allRoutes.add("\"${Komoot.elementAt(i - 6)}\"")
            }
        }
    }
    println(allRoutes.toString())
}

fun uniqueRoutes() {
    val uniqueRoutes = mutableSetOf<String>()
    for (item in Strava) {
        uniqueRoutes.add("\"$item\"")
    }
    for (item in RWGPS) {
        uniqueRoutes.add("\"$item\"")
    }
    for (item in Komoot) {
        uniqueRoutes.add("\"$item\"")
    }
    println(uniqueRoutes.toString())
}

fun allUserRoutes(userId: Int) {
    val allRoutes = mutableListOf<String>()
    for (i in 0..Strava.size + RWGPS.size + Komoot.size) {
        when {
            i < 3 -> {
                allRoutes.add("\"$userId${Strava.elementAt(i)}\"")
            }
            i < 6 -> {
                allRoutes.add("\"${RWGPS.elementAt(i - 3)}$userId\"")
            }
            i < 9 -> {
                allRoutes.add("\"$userId${Komoot.elementAt(i - 6)}$userId\"")
            }
        }
    }
    println(allRoutes.toString())
}

fun userRoutesByService(userId: Int, service: Set<String>) {
    val userRoutes = mutableListOf<String>()
    for (item in service) {
        when (item.toLowerCase()) {
            "strava" -> {
                for (route in Strava) {
                    userRoutes.add("\"$userId$route\"")
                }
            }
            "rwgps" -> {
                for (route in RWGPS) {
                    userRoutes.add("\"$route$userId\"")
                }
            }
            "komoot" -> {
                for (route in Komoot) {
                    userRoutes.add("\"$userId$route$userId\"")
                }
            }
        }
    }
    println(userRoutes.toString())
}

fun main() {
    var init = 1
    while (init != 0) {
        println("Please choose from the following options: All Routes, Unique Routes, All User Routes, User Routes by Service. Or type quit to terminate the program.")
        val userInput = readLine()!!
        when (userInput.toLowerCase()) {
            "quit" -> init = 0
            "all routes" -> allRoutes()
            "unique routes" -> uniqueRoutes()
            "all user routes" -> {
                var userId = ""
                println("Please enter your User ID or type quit to return to the main menu.")
                while (userId == "") {
                    userId = readLine()!!
                    if (userId == "quit") {
                        break
                    }
                    if (userId.toIntOrNull() == null) {
                        println("Error: Not a valid User ID. Please enter a valid User Id.")
                        userId = ""
                        continue
                    } else {
                        allUserRoutes(userId.toInt())
                        break
                    }
                }
            }
            "user routes by service" -> {
                var userId = ""
                println("Please enter your User ID or type quit to return to the main menu.")
                while (userId == "") {
                    userId = readLine()!!
                    if (userId == "quit") {
                        break
                    }
                    if (userId.toIntOrNull() == null) {
                        println("Error: Not a valid User Id. Please enter a valid User Id")
                        userId = ""
                        continue
                    } else {
                        val serviceSet = mutableSetOf<String>()
                        println("Please type the name of the services you wish to retrieve the route data from, separated by enters. Type quit to complete your selection.")
                        var service = readLine()!!
                        while (service.toLowerCase() != "quit") {
                            if (service.toLowerCase() == "strava" || service.toLowerCase() == "rwgps" || service.toLowerCase() == "komoot") {
                                serviceSet.add(service)
                            } else {
                                println("Error: Unknown Route. Please enter a valid route or type quit to complete your selection")
                            }
                            service = readLine()!!
                        }
                        if (serviceSet.isEmpty()) {
                            println("Error: You must add at least one service. Please Try Again.")
                            break
                        } else {
                            userRoutesByService(userId.toInt(), serviceSet)
                            break
                        }
                    }
                }
            }
            else -> {
                println("Invalid request. Please Try Again.")
            }
        }
    }
}
