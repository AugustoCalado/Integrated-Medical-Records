package com.integrated.medical.records.repository.impl

import com.integrated.medical.records.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<User,Int> {
}