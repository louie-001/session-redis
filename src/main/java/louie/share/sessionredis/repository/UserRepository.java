package louie.share.sessionredis.repository;

import louie.share.sessionredis.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author louie
 * @date created in 2018-5-12 17:58
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * find user by account
     * @param account
     * @return
     */
    User findByAccount(String account);
}
