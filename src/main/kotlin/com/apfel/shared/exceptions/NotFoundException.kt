package com.apfel.shared.exceptions

class NotFoundException : RuntimeException{
    constructor(message: String): super(message)
    constructor(message: String, cause: Throwable): super(message, cause)
}