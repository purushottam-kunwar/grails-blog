package blog

import grails.plugin.springsecurity.annotation.Secured

import java.awt.image.*
import javax.imageio.*

@Secured(['permitAll'])
class AdminController {

    def springSecurityService

    def index() {
    }


    def adminPage() {
        render(view: "/admin/adminPage")
    }


    def save() {

        UserInfo userInfo = (UserInfo) springSecurityService.getCurrentUser()

        boolean flag = false

        def img = request.getFile('blogImage')
        println "params>>" + params
        println "img = $img"

        BufferedImage imm = ImageIO.read(img.getInputStream())
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
        //use another encoding if JPG is inappropriate for you
        ImageIO.write(imm, "jpg", outputStream)
        outputStream.flush()
        Byte[] encodedImage = outputStream.toByteArray()
        outputStream.close()
        println "encodedImage = $encodedImage"

        def data2 = new Image()
        data2.image = encodedImage
        data2.name = params.title

        if (!data2.validate()) {
            data2.errors.each { error ->
                println error
            }
        }

        if (data2.save(flush: true)) {

            flag = true
            println "after save image!!!"

            def data = new Blog()
            data.title = params.title
            data.status = params.status
            data.image = data2
            data.userInfo = userInfo

            if (!data.validate()) {
                data.errors.each { error ->
                    println error
                }
            }

            if(data.save(flush: true)){
                flag = true
            }else {
                flag = false
            }
        }

        if (flag){
            println "saved sucessfully"
        }else{
            println "error1!!"
        }

        redirect(action: 'adminPage')
    }
}