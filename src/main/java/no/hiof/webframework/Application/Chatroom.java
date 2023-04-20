package no.hiof.webframework.Application;
import no.hiof.webframework.Application.Enums.ChatMethod;
import no.hiof.webframework.Application.Enums.ImageType;
import no.hiof.webframework.Application.Enums.Options;
import no.hiof.webframework.Application.Tools.ImageUtility;
import no.hiof.webframework.Exceptions.ImageOverloadException;
import no.hiof.webframework.SpringBoot.SpringApp;

import java.io.IOException;

public class Chatroom extends ImageUtility {

    private static Chatroom instance = null;

    private static ChatMethod method;

    private static boolean timeStamp;

    private static String title;

    private static Options deleteMessage;

    private Chatroom() {}

    public static Chatroom create() {
        if (instance == null) {
            instance = new Chatroom();
        }
        return instance;
    }

    protected void startChatRoom() {
        SpringApp.run();
    }

    public static void addIconImageToChat(String absoluteImagePath) {
        try {
            ImageUtility.copyImageFile(absoluteImagePath);
        }
        catch (ImageOverloadException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void overrideExistingIconImage(String absoluteImagePath, ImageType overrideImage) {
        try {
            ImageUtility.copyImageFile(absoluteImagePath, overrideImage);
        }
        catch (IOException ex) {
            System.err.println("Error in overriding the " + overrideImage + " image.");
        }
    }

    public static void setChatMethod(ChatMethod type) {
        method = type;
    }

    public static void addMessageTimeStamp(boolean decision) {
        timeStamp = decision;
    }

    public static void addDeleteMessagesButton(Options option) {
        deleteMessage = option;
    }

    public static void setTitle(String chatRoomTitle) {
        title = chatRoomTitle;
    }

    protected Options getDeleteMessage() {
        return deleteMessage;
    }

    protected ChatMethod getMethod() {
        return method;
    }

    protected boolean getTimeStamp() {
        return timeStamp;
    }

    protected String getTitle() { return title; }
}

