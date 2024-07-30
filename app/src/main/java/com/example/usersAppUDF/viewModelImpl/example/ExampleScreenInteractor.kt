package com.example.usersAppUDF.viewModelImpl.example

import com.example.usersAppUDF.viewModel.BaseInteractor
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExampleScreenInteractor @Inject constructor(
    // private val someRepository: SomeRepository
) : BaseInteractor<ExampleScreenAction, ExampleScreenResult> {
    override fun actionToResult(action: ExampleScreenAction): Flow<ExampleScreenResult> {
        TODO("Not yet implemented")
    }

    override fun initResults(): Flow<ExampleScreenResult> = flow {
        //Emitting loading result while waiting to load some data from repo
        emit(ExampleScreenResult.LoadingResult)
        delay(2000)

        //Emitting some data from repo when call was success
        // val exampleGreetingMessage: String = someRepository.getGreeting()
        val exampleGreetingMessage = "Android"
        emit(ExampleScreenResult.SuccessResult(exampleGreetingMessage))
    }
}