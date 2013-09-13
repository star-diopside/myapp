package jp.myapp.batch;

import jp.myapp.data.entity.management.Users;
import jp.myapp.service.bean.UserInfoUtil;

import org.springframework.batch.item.ItemProcessor;

public class B03S010Processor implements ItemProcessor<Users, Users> {

    @Override
    public Users process(Users item) throws Exception {

        // 無効ユーザの場合に処理対象とする。
        if (UserInfoUtil.isValid(item)) {
            return null;
        }

        return item;
    }
}
