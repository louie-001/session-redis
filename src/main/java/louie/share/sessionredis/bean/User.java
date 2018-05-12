package louie.share.sessionredis.bean;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 用户实体
 * @author louie
 * @date created in 2018-5-12 17:28
 */
@Entity
@Table(name = "b_id_user")
public class User implements Serializable{
    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @NotBlank(message = "account can not be empty")
    private String account;
    @NotBlank(message = "password can not be empty")
    private String password;
    @NotBlank(message = "name can not be empty")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
