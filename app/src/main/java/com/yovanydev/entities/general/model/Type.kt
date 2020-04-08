package com.yovanydev.entities.general.model

enum class Type (val code: Int, val typeName: String) {
    ETCHED(1, "Vidrio Grabado"),
    SMOOTH(2, "Vidrio Liso"),
    FROSTED(3, "Vidrio Mate"),
    MIRROR(4, "Vidrio Espejo"),;

    companion object {
        const val EMPTY_VALUE: String = "EMPTY"

        fun valueOf(code: Int): String {
            for (type in values()) {
                if (code == type.code) return type.typeName
            }
            return EMPTY_VALUE
        }
    }
}