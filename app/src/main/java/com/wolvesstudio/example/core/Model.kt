package com.wolvesstudio.example.core

import com.wolvesstudio.example.core.persistence.Identifiable

data class Model(override val id: String, val name: String): Identifiable
