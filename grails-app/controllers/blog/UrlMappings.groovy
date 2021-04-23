package blog

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "blog", action: "homePage")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
