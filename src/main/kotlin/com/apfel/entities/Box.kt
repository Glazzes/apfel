package com.apfel.entities

import com.apfel.shared.enums.BoxStatus
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "Box")
@Table(name = "Boxes")
class Box(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "boxId", nullable = false)
    var boxId: String? = null,

    @Column(name = "last_modified", nullable = false)
    var lastModified: LocalDateTime = LocalDateTime.now(),

    @Column(name = "box_status", nullable = false)
    var boxStatus: BoxStatus = BoxStatus.REQUESTED,

    @ManyToOne
    @JsonIgnore
    var user: User? = null
)