package jp.myapp.batch;

import java.util.List;

import jp.myapp.data.entity.management.Users;
import jp.myapp.data.exception.ExclusiveException;
import jp.myapp.data.mapper.management.AuthoritiesMapper;
import jp.myapp.data.mapper.management.UsersMapper;
import jp.myapp.data.support.OptimisticLockControl;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class B03S010Writer implements ItemWriter<Users> {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private AuthoritiesMapper authoritiesMapper;

    @Override
    public void write(List<? extends Users> items) throws Exception {

        OptimisticLockControl<Users, String> usersLockCtrl = new OptimisticLockControl<>(this.usersMapper);

        for (Users users : items) {
            try {
                usersLockCtrl.lock(users);
                this.authoritiesMapper.deleteByUserId(users.getUserId());
                this.usersMapper.delete(users.getPK());
            } catch (ExclusiveException e) {
                // 楽観排他エラーが発生した場合、何も処理しない。
            }
        }
    }
}
