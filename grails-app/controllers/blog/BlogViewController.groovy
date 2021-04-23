package blog

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class BlogViewController {

    def index() {

    }

    def blogView(){
        render(view: "/blogView/blogView")

    }
}
