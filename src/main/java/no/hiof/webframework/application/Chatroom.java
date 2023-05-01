package no.hiof.webframework.application;
import no.hiof.webframework.application.enums.ChatMethod;
import no.hiof.webframework.application.enums.ImageType;
import no.hiof.webframework.application.enums.Options;
import no.hiof.webframework.application.tools.ImageUtility;
import no.hiof.webframework.exceptions.ImageOverloadException;
import no.hiof.webframework.SpringBoot.SpringApp;

import java.io.IOException;

/**
 * The Chatroom class represent a chatroom in a web application.
 * It extends the ImageUtility class, which provides utility methods
 * for handling image files. The Chatroom class provides methods for
 * setting chatroom properties such as chat method, message timestamp,
 * delete message option, and chatroom title. It also provides methods
 * for adding an icon image to the chatroom and overriding existing
 * icon images. The Chatroom class is implemented as a Singleton, so
 * only one instance of the class can exist at a time.
 */
public class Chatroom extends ImageUtility {

    private static Chatroom instance = null;

    private static ChatMethod method;

    private static boolean timeStamp;

    private static String title;

    private static Options deleteMessage;

    protected Chatroom() {}

    /**
     * Constructor to get the singleton instance of the class.
     * @return An instance of the Chatroom class.
     */
    public static Chatroom create() {
        if (instance == null) {
            instance = new Chatroom();
        }
        return instance;
    }


    /**
     * Methods used to start the chatroom as a Spring Boot application.
     */
    protected void startChatRoom() {
        SpringApp.run();
    }

    /**
     * Adds an icon image to the chat by copying the image file from the
     * specified absolute file path.
     * @param absoluteImagePath The absolute image file path of the image to be copied.
     */
    public static void addIconImageToChat(String absoluteImagePath) {
        try {
            ImageUtility.copyImageFile(absoluteImagePath);
        }
        catch (ImageOverloadException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Overrides an existing icon image by copying the specified image file to the
     * appropriate directory based on the given image type.
     * @param absoluteImagePath The absolute image file path of the image to be copied-
     * @param overrideImage The enum type of image to be overridden (e.g. DEFAULT_1, DEFAULT_2).
     */
    public static void overrideExistingIconImage(String absoluteImagePath, ImageType overrideImage) {
        try {
            ImageUtility.copyImageFile(absoluteImagePath, overrideImage);
        }
        catch (IOException ex) {
            System.err.println("Error in overriding the " + overrideImage + " image.");
        }
    }

    /**
     * Sets the chat method of the application.
     * @param type The enum method type (e.g. PRIVATE, GROUP).
     */
    public static void setChatMethod(ChatMethod type) {
        method = type;
    }

    /**
     * Adds timestamps to the messages sent in the chatroom application.
     * @param decision A boolean value (e.g. true or false).
     */
    public static void addMessageTimeStamp(boolean decision) {
        timeStamp = decision;
    }

    /**
     * Adds a delete button to sent messages in the chatroom application.
     * The delete button is marked as a 'x' icon on the messages.
     * @param option The enum value for this to be added or not (e.g. YES, NO).
     */
    public static void addDeleteMessagesButton(Options option) {
        deleteMessage = option;
    }

    /**
     * Sets the title of the chatroom application. The rooms have titles
     * by default, so this can be used to add a custom title.
     * @param chatRoomTitle The title represented as a String value.
     */
    public static void setTitle(String chatRoomTitle) {
        title = chatRoomTitle;
    }

    /**
     * Method used to retrieve delete message variable.
     * @return An enum 'Options' type (e.g. YES, NO).
     */
    protected Options getDeleteMessage() {
        return deleteMessage;
    }

    /**
     * Method used to retrieve the chat method variable.
     * @return An enum 'ChatMethod' type (e.g. PRIVATE, GROUP).
     */
    protected ChatMethod getMethod() {
        return method;
    }

    /**
     * Methods used to retrieve the timestamp variable.
     * @return A boolean value for the variable (e.g. true or false).
     */
    protected boolean getTimeStamp() {
        return timeStamp;
    }

    /**
     * Methods used to retrieve the title variable.
     * @return A string value of the title.
     */
    protected String getTitle() { return title; }
}

