package com.techprostudio.example.core

import com.techprostudio.example.core.persistence.Identifiable

data class Model(override val id: String, val name: String): Identifiable
