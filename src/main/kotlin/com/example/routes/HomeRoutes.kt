package com.example.routes

import com.example.model.Student
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.homeRoutes() {
    route("/") {
        get("/") {
            call.respondText("Hello, Student API!")
        }
    }
}