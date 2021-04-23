package blog

class Blog {

    Date createdDate = new Date()
    String title //image.name = blog.tile
    String status
    Image image
    UserInfo userInfo

    static constraints = {
     status type: 'text'
    }
}
