package blog

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class UserInfo implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    /*String firstName
    String lastName
    String email
    Image image*/
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<RoleInfo> getAuthorities() {
        (UserInfoRoleInfo.findAllByUserInfo(this) as List<UserInfoRoleInfo>)*.roleInfo as Set<RoleInfo>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
    }

    static mapping = {
	    password column: '`password`'
    }

    def onSave(){
        println "new user inserted..."
    }

    def onDelete(){
        println "user was deleted..."
    }
}
