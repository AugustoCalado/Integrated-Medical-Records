package com.integrated.medical.records.domain.resource.assembler

import com.integrated.medical.records.controller.UserController
import com.integrated.medical.records.domain.User
import com.integrated.medical.records.domain.resource.UserResource
import org.springframework.hateoas.mvc.ResourceAssemblerSupport

class UserResourceAssembler : ResourceAssemblerSupport<User, UserResource> {

    constructor() : super(UserController::class.java, UserResource::class.java)

    override fun instantiateResource(user: User): UserResource {
        return UserResource(user)
    }

    override fun toResource(user: User): UserResource {
        return createResourceWithId(user.idUser, user)
    }
}