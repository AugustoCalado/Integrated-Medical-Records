package com.integrated.medical.records.service.Impl

import com.integrated.medical.records.domain.User
import com.integrated.medical.records.domain.dto.UserDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.repository.UserRepository
import com.integrated.medical.records.service.UserService
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userRepository: UserRepository, val modelMapper: ModelMapper) : UserService {
    override fun getUser(idUser: Int): UserDTO {
        val user = userRepository.findById(idUser).orElseThrow {
            ObjectNotFoundException("Usuario ${idUser} not found")
        }
        return modelMapper.map(user, UserDTO::class.java)
    }

    override fun insertUser(userDTO: UserDTO) {
        val user = modelMapper.map(userDTO, User::class)
        userRepository.save(user as User)

    }

    @Throws(ObjectNotFoundException::class)
    override fun update(userUpdated: UserDTO) {
        userRepository.findById(userUpdated.idUser).orElseThrow {
            ObjectNotFoundException("Usuario ${userUpdated.nameLogin} not found")
        }
        userRepository.save(modelMapper.map(userUpdated, User::class.java))

    }

}