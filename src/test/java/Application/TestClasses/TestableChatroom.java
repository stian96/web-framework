package Application.TestClasses;

import no.hiof.webframework.Application.Chatroom;
import no.hiof.webframework.Application.Enums.ChatMethod;
import no.hiof.webframework.Application.Enums.Options;

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