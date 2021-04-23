package blog

class BootStrap {

    def init = { servletContext ->

        if (UserInfo.count == 0) {
            def adminRole = new RoleInfo(authority: 'ROLE_ADMIN').save(flush: true)

            def testUser = new UserInfo(username: 'admin', password: 'admin123').save(flush: true)
            println "testUser>>>" + testUser

            UserInfoRoleInfo.create testUser, adminRole

            UserInfoRoleInfo.withSession {
                it.flush()
                it.clear()
            }
        }


    }
    def destroy = {
    }
}
