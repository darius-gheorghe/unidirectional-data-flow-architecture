package com.example.usersAppUDF.viewModelImpl.contactList

import com.example.usersAppUDF.domain.User
import com.example.usersAppUDF.repository.UsersRepository
import com.example.usersAppUDF.viewModel.BaseInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.random.Random

class ContactListInteractor @Inject constructor(
    private val userListRepository: UsersRepository,
) : BaseInteractor<ContactListScreenAction, ContactListScreenResult> {
    override fun actionToResult(action: ContactListScreenAction): Flow<ContactListScreenResult> {
        TODO("Not yet implemented")
    }

    override fun initResults(): Flow<ContactListScreenResult> {
        return getUsersFromRepository()
    }

    private fun getUsersFromRepository(): Flow<ContactListScreenResult> =
        userListRepository.observeUserList
            .map {
                val activeUsers = it.filter { user -> user.status == "active" }
                val avatarStringsList = getAvatarStringForUsers(activeUsers)

                ContactListScreenResult.Success(activeUsers, avatarStringsList)
            }

    private fun getAvatarStringForUsers(users: List<User>): List<String> = users.map {
        if ((it.id).toInt() % 2 == 0)
            it.name.getInitials()
        else {
            Random.nextInt(from = 0, until = 1084).toString()
        }
    }

    private fun String.getInitials(): String = this.split(" ").let {
        "${it[0][0]}${(it[1][0])}"
    }
}