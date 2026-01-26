package com.msmobile.visitas.util

import kotlinx.coroutines.runBlocking

fun <T> T.runSuspend(block: suspend T.() -> Unit): T {
    runBlocking { block() }
    return this
}