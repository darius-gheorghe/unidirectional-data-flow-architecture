package com.example.udfArchitecture.viewModel

import kotlinx.coroutines.flow.Flow

interface BaseInteractor<ACTION, RESULT> {

    fun actionToResult(action: ACTION): Flow<RESULT>
    fun initResults(): Flow<RESULT>
}