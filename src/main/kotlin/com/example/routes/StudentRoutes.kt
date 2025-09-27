package com.example.routes

import com.example.model.Student
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.studentRoutes() {
    route("/students") {

        get {
            val students = listOf(
                Student(1, "Alice"),
                Student(2, "Bob"),
                Student(3, "Charlie")
            )
            call.respond(students)
        }

//        post {
//            val student = call.receive<Student>()
//            call.respond(student)
//        }

        get("{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id == null) {
                call.respondText("Invalid ID")
            } else {
                call.respond(Student(id, "Student $id"))
            }
        }
    }
}