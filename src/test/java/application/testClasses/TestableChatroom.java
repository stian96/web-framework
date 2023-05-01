package application.testClasses;

import no.hiof.webframework.application.Chatroom;
import no.hiof.webframework.application.enums.ChatMethod;
import no.hiof.webframework.application.enums.Options;

public class TestableChatroom extends Chatroom {

    public TestableChatroom() {
        super();
    }

    @Override
    public ChatMethod getMethod() {
        return super.getMethod();
    }

    @Override
    public boolean getTimeStamp() {
        return super.getTimeStamp();
    }

    @Override
    public Options getDeleteMessage() {
        return super.getDeleteMessage();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }
}
