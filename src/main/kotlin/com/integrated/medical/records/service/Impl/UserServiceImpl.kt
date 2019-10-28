package com.integrated.medical.records.service.Impl

import com.integrated.medical.records.domain.EmergencyCard
import com.integrated.medical.records.domain.User
import com.integrated.medical.records.domain.dto.UserDTO
import com.integrated.medical.records.domain.dto.toEntity
import com.integrated.medical.records.domain.toDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.repository.UserRepository
import com.integrated.medical.records.service.UserService
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userRepository: UserRepository, val modelMapper: ModelMapper) : UserService {

    @Throws(ObjectNotFoundException::class)
    override fun getUser(idUser: Int): UserDTO {

        val user = userRepository.findById(idUser).orElseThrow {
            ObjectNotFoundException("Usuario ${idUser} not found")
        }
        return modelMapper.map(user, UserDTO::class.java)
    }

    override fun insertUser(userDTO: UserDTO): UserDTO {

        val user = userDTO.toEntity()
        return userRepository.save(user).toDTO()

    }

    @Throws(ObjectNotFoundException::class)
    override fun update(userUpdated: UserDTO): UserDTO {

        userRepository.findById(userUpdated.idUser).orElseThrow {
            ObjectNotFoundException("Usuario ${userUpdated.nameLogin} not found")
        }
        return userRepository.save(userUpdated.toEntity()).toDTO()
    }

    override fun getAllUsersFromDB(): List<UserDTO> {
        return userRepository.findAll().toList().toDTO()
    }
}