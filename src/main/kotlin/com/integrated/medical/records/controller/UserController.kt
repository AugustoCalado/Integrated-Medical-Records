package com.integrated.medical.records.controller

import com.integrated.medical.records.domain.dto.UserDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.service.UserService
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RepositoryRestController
@RequestMapping(value = "/user")
class UserController(
        val userService: UserService
) {

    @GetMapping
    fun loginUser(@RequestBody login: UserDTO): ResponseEntity<UserDTO> {
        return ResponseEntity.ok(UserDTO())
    }

    @PostMapping(value = "/save")
    fun saveNewUser(@RequestBody user: UserDTO): ResponseEntity<String> {
        try {
            userService.insertUser(user)
        } catch (ex: Exception) {
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity.ok("User insert complete with success")
    }

    @PutMapping(path = ["update-user"])
    fun updateUser(@RequestBody user: UserDTO): ResponseEntity<String> {
        try {
            userService.update(user)
        } catch (ex: Exception) {
            return when (ex) {
                is ObjectNotFoundException -> {
                    ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
                }
                else -> ResponseEntity(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
        return ResponseEntity.ok("User update complete with success")
    }

    @GetMapping(value = "get-all-test")
    fun getAllUsersFromDB(): ResponseEntity<*> {
        return ResponseEntity(userService.getAllUsersFromDB(), HttpStatus.OK)
    }
}
