package jp.myapp.batch;

import jp.myapp.bean.UserInfo;
import jp.myapp.data.entity.Users;

import org.springframework.batch.item.ItemProcessor;

public class B03S010Processor implements ItemProcessor<Users, Users> {

    @Override
    public Users process(Users item) throws Exception {

        // 無効ユーザの場合に処理対象とする。
        if ((new UserInfo(item)).isValid()) {
            return null;
        }

        return item;
    }
}
