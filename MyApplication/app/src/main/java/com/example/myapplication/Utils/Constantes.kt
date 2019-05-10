package com.example.myapplication.Utils

object Constantes {

    val BASE_URL = "https://raw.githubusercontent.com/Rafaelfv/exampleJson/"

    // tags Fragments
    //val TAG_FRAGMENT_MAIN = "FragmentMain"

    enum class TagsFragments(val tag:String){
        TAG_FRAGMENT_MAIN("FragmentMain"),
        TAG_FRAGMENT_PROFILE("FragmentProfile"),
        TAG_FRAGMENT_EXPERIENCE("FragmentExperience")
    }

    enum class Values(val type: Int) {
        HTTP_STATUS_OK(200),
        RESPONSE_CODE_OK(0)
    }

}


