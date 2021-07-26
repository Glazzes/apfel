package com.apfel.repository

import com.apfel.entities.Box
import com.apfel.entities.User
import com.apfel.shared.enums.BoxStatus
import org.springframework.data.jpa.repository.JpaRepository

interface BoxRepository : JpaRepository<Box, Long>{
    fun findAllByBoxStatusAndUser(boxStatus: BoxStatus, user: User): MutableSet<Box>
}