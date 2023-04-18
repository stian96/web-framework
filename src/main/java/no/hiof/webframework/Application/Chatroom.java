package no.hiof.webframework.Application;


import no.hiof.webframework.Application.Enums.ChatMethod;
import no.hiof.webframework.Application.Enums.ImageType;
import no.hiof.webframework.Application.Tools.ImageUtility;
import no.hiof.webframework.Exceptions.ImageOverloadException;
import no.hiof.webframework.SpringBoot.SpringApp;

import java.io.IOException;

public class Chatroom {

    private static Chatroom instance = null;

    private static ChatMethod method;

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

    public ChatMethod getMethod() {
        return method;
    }
}

