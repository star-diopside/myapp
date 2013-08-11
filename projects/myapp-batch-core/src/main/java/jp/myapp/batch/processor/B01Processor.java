package jp.myapp.batch.processor;

import jp.myapp.data.entity.management.Users;

import org.springframework.batch.item.ItemProcessor;

public class B01Processor implements ItemProcessor<Users, Users> {

    @Override
    public Users process(Users item) throws Exception {

        if (item != null) {
            item.setVersion(item.getVersion() + 1);
        }

        return item;
    }
}
