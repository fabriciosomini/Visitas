package com.msmobile.visitas.util

import kotlinx.coroutines.CancellableContinuation
import kotlin.coroutines.resume

fun <T> CancellableContinuation<T>.resumeIfActive(value: T) {
    if (!isActive) return
    resume(value)
}