package blog

import grails.plugin.springsecurity.annotation.Secured

@Secured(["permitAll"])
class UserProfileController {
    def index() {


    }


    def profileUser(){
        render(view: "/userProfile/profileUser")
    }


}
