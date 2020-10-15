@file:JvmName("RoleConverter")

package com.hardcore.accounting.converterV2

import com.hardcore.accounting.model.common.Role

fun convertFrom(role: com.hardcore.accounting.model.persistence.Role?): Role? {
    return if (role != null)
        Role().apply {
            id = role.id
            code = role.code
            name = role.name
        }
    else null
}

fun convertToVo(role: Role?): com.hardcore.accounting.model.service.Role? {
    return if (role == null) null else
        com.hardcore.accounting.model.service.Role().apply {
            id = role.id
            code = role.code
            name = role.name
        }
}