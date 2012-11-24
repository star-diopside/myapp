package jp.myapp.test;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestTrace extends TestWatcher {

    @Override
    protected void starting(Description description) {
        System.out.println("[" + description.getDisplayName() + "] start");
    }

    @Override
    protected void finished(Description description) {
        System.out.println("[" + description.getDisplayName() + "] end");
    }
}
