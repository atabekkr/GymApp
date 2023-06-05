package com.karsoft.gymapp.data.constants


object Constants {

    fun users() : List<UserData> {
        val list = mutableListOf<UserData>()

        list.add(UserData("indira001", "user1991"))
        list.add(UserData("indira123", "user1991"))
        list.add(UserData("100101203", "user1991"))
        list.add(UserData("100101204", "user"))
        list.add(UserData("100101205", "user"))

        return list
    }

}