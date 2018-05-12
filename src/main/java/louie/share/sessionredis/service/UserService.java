package louie.share.sessionredis.service;

import louie.share.sessionredis.bean.BaseResponse;
import louie.share.sessionredis.bean.User;

/**
 * 用户服务接口
 * @author louie
 * @date created in 2018-5-12 17:40
 */
public interface UserService {
    /**
     * save user
     * @param user
     * @return 保存后的用户信息
     */
    User saveUser(User user);

    /**
     * find user by account
     * @param account
     * @return
     */
    User findByAccount(String account);

    /**
     * user login
     * @param account
     * @param password
     * @return
     */
    BaseResponse login(String account,String password);
}
