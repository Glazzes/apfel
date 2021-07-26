package com.apfel.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "User")
@Table(
    name = "users",
    uniqueConstraints = [
        UniqueConstraint(name = "uq_username", columnNames = ["username"]),
        UniqueConstraint(name = "uq_real_name", columnNames = ["real_name"])
    ]
)
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "real_name", nullable = false)
    val realName: String = "",

    @Column(name = "username", nullable = false, updatable = false)
    val username: String = "",

    @Column(name = "password", nullable = false)
    var password: String = "",

    val isLoggedIn: Boolean = false,

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    val boxes: MutableSet<Box> = HashSet()
)