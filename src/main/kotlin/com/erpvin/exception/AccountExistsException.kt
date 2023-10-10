package com.erpvin.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(code = HttpStatus.CONFLICT, reason = "User account existing")
class AccountExistsException : Exception()

