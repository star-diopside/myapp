package jp.myapp.batch;

import java.util.List;

import jp.myapp.dao.entity.Users;
import jp.myapp.dao.mapper.UsersMapper;

import org.springframework.batch.core.ExitStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class B02 {

    @Autowired
    private UsersMapper usersMapper;

    @Transactional(rollbackFor = Throwable.class)
    public ExitStatus exec(String key, String value) {

        List<Users> list = this.usersMapper.selectAll();

        System.out.println(key + " = " + value);

        for (Users info : list) {
            System.out.println(info.getUserId());
        }

        return ExitStatus.COMPLETED;
    }
}
