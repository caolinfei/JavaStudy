package com.study.repositories;
import com.study.domian.UserAccount;

public class UserAccountRepository extends Respsitory<UserAccount> {

    public UserAccountRepository() {
        //不可以在父类初始化之前使用当前对象的实例化成员 除非是静态的
      //super(this.getClass());
        super(UserAccountRepository.class);
    }
}
