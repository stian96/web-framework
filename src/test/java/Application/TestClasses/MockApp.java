package Application.TestClasses;

import no.hiof.webframework.Application.App;

public class MockApp extends App {
    private boolean isRunMethodCalled = false;

    @Override
    public void run() {
        isRunMethodCalled = true;
    }

    public boolean isRunMethodCalled() {
        return isRunMethodCalled;
    }
}
