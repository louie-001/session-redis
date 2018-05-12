package louie.share.sessionredis.web;

import louie.share.sessionredis.bean.BaseResponse;
import louie.share.sessionredis.bean.User;
import louie.share.sessionredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;
import java.time.Duration;

/**
 * 用户管理相关控制器
 * @author louie
 * @date created in 2018-5-12 17:26
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * save user
     * @param user
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public User save(User user){
        return userService.saveUser(user);
    }

    /**
     * find user by account
     * @param account
     * @return
     */
    @RequestMapping(value = "/find/{account}",method = RequestMethod.GET)
    public User find(@PathVariable String account){
        return userService.findByAccount(account);
    }

    /**
     * user login
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResponse login(String account, String password,HttpSession session){
        BaseResponse response = userService.login(account,password);
        if (response.isOk()){
            session.setAttribute(session.getId(),response.getData());
        }
        return response;
    }

    /**
     * user logout
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.removeAttribute(session.getId());
        return "user logout success";
    }
}
