package com.example.usersAppUDF.viewModelImpl.contactList

import com.example.usersAppUDF.domain.User
import com.example.usersAppUDF.navigation.NavigationManager
import com.example.usersAppUDF.viewModel.BaseViewModel
import javax.inject.Inject

class ContactListViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    interactor: ContactListInteractor
) : BaseViewModel<ContactListScreenState, ContactListScreenAction, ContactListScreenEffect, ContactListScreenResult>(
    interactor = interactor,
    initialUiState = ContactListScreenState.Loading
) {
    override suspend fun handleResult(
        previous: ContactListScreenState,
        result: ContactListScreenResult
    ): ContactListScreenState {
        return when (result) {
            is ContactListScreenResult.Success -> {
                ContactListScreenState.Success(
                    result.usersList,
                    result.avatarStringsList
                )
            }
        }
    }

}

sealed interface ContactListScreenState {
    data object Loading : ContactListScreenState
    data class Success(
        val usersList: List<User>,
        val avatarStringsList: List<String>
    ) : ContactListScreenState
}
sealed interface ContactListScreenAction
sealed interface ContactListScreenEffect
sealed interface ContactListScreenResult {
    data class Success(
        val usersList: List<User>,
        val avatarStringsList: List<String>
    ) : ContactListScreenResult
}