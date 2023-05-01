package application;
import application.TestClasses.TestableChatroom;
import no.hiof.webframework.application.Chatroom;
import no.hiof.webframework.application.enums.ChatMethod;
import no.hiof.webframework.application.enums.Options;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ChatroomTest {


    @Test
    void testCreateMethodReturnsOnlyOneInstance() {

        // setup
        Chatroom instance1 = Chatroom.create();
        Chatroom instance2 = Chatroom.create();

        // verify
        Assertions.assertNotNull(instance1);
        Assertions.assertNotNull(instance2);
        Assertions.assertEquals(instance1, instance2);
    }


    @Test
    void testAddIconImageToChatThrowsIOException() {
        // Set up
        String absoluteImagePath = "C:/test/image1.jpg";

        // Test
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outContent));
        Chatroom.addIconImageToChat(absoluteImagePath);

        // Verify
        String message = "Image file is already added, remove the addIconImageToChat call.";
        Assertions.assertEquals(message, outContent.toString().trim());
    }


    @Test
    void testAddIconImageToChatThrowsImageOverloadException() {
        // Set up
        String path1 = "src/main/resources/Static/images/default1.jpg";
        String path2 = "src/main/resources/Static/images/default2.jpg";
        String path3 = "src/main/resources/Static/images/default1.jpg";

        // Test
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outContent));
        Chatroom.addIconImageToChat(path1);
        Chatroom.addIconImageToChat(path2);
        Chatroom.addIconImageToChat(path3);

        String ioException = "Image file is already added, remove the addIconImageToChat call.";
        String result = outContent.toString().replace(ioException, "");

        // Verify
        String overloadException = "Can only add max two images, use overrideImage parameter to add more.";
        Assertions.assertEquals(overloadException, result.substring(70).trim());
    }

    @Test
    void testOverrideExistingIconImageThrowsNullPointerException() {

        // Setup
        String path1 = "src/main/resources/Static/images/default1.jpg";
        String exception = "Override image parameter cannot be null!";

        // Test
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outputStream));
        Chatroom.overrideExistingIconImage(path1, null);

        // Verify
        Assertions.assertEquals(exception, outputStream.toString().trim());
    }

    @Test
    void testThatSetChatMethodSetsTheMethod() {

        // Setup
        TestableChatroom testableChatroom = new TestableChatroom();

        // Test
        Chatroom.setChatMethod(ChatMethod.PRIVATE);

        // Verify
        Assertions.assertSame(testableChatroom.getMethod(), ChatMethod.PRIVATE);
        Assertions.assertNotSame(testableChatroom.getMethod(), ChatMethod.GROUP);
    }

    @Test
    void testThatAddMessageTimestampAddsTimestamp() {

        // Setup
        TestableChatroom testableChatroom = new TestableChatroom();

        // Test
        Chatroom.addMessageTimeStamp(true);

        // Verify
        Assertions.assertTrue(testableChatroom.getTimeStamp());
        Assertions.assertNotEquals(false, testableChatroom.getTimeStamp());
    }

    @Test
    void testAddDeleteMessageButtonAddsButton() {

        // Setup
        TestableChatroom testableChatroom = new TestableChatroom();

        // Test
        Chatroom.addDeleteMessagesButton(Options.YES);

        // Verify
        Assertions.assertSame(testableChatroom.getDeleteMessage(), Options.YES);
        Assertions.assertNotSame(testableChatroom.getDeleteMessage(), Options.NO);
    }

    @Test
    void testThatSetTitleSetsTheTitle() {

        // Setup
        TestableChatroom testableChatroom = new TestableChatroom();

        // Test
        Chatroom.setTitle("Hello World!");

        // Verify
        Assertions.assertEquals(testableChatroom.getTitle(), "Hello World!");
    }
}
