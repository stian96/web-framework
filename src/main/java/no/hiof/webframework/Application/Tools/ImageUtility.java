package no.hiof.webframework.Application.Tools;

import no.hiof.webframework.Exceptions.ImageOverloadException;

import java.io.IOException;
import java.nio.file.*;
import java.util.Properties;

public class ImageUtility {
    private static int imageCounter = 0;

    private static final Properties config;

    public enum ImageType {
        DEFAULT_1,
        DEFAULT_2,
        IMAGE_1,
        IMAGE_2
    }

    static  {
        config = new Properties();

        try {
            config.load(ImageUtility.class.getResourceAsStream("/config.properties"));
        }
        catch (Exception ex) {
            System.err.println("Error loading config properties: " + ex.getMessage());
        }
    }

    public static void copyImageFile(String sourcePath) throws IOException, ImageOverloadException {
        Path source = Paths.get(sourcePath);
        String destination = "";

        if (imageCounter == 0)
            destination = config.getProperty("image1.path");
        else if (imageCounter == 1)
            destination = config.getProperty("image2.path");
        else
        {
            String msg = "Can only add max two images, use overrideImage parameter to add more.";
            throw new ImageOverloadException(msg);
        }

        Path destinationPath = Paths.get(destination);
        Files.copy(source, destinationPath);
        imageCounter++;
    }

    public static void copyImageFile(String sourcePath, ImageType overrideImage) throws IOException {
        Path source = Paths.get(sourcePath);
        String dest = "";

        try {
            if (overrideImage.equals(ImageType.DEFAULT_1)) {
                dest = config.getProperty("default1.path");
                Files.copy(source, Paths.get(dest), StandardCopyOption.REPLACE_EXISTING);
            }
            else if (overrideImage.equals(ImageType.DEFAULT_2)) {
                dest = config.getProperty("default2.path");
                Files.copy(source, Paths.get(dest), StandardCopyOption.REPLACE_EXISTING);
            }
            else if (overrideImage.equals(ImageType.IMAGE_1)) {
                dest = config.getProperty("image1.path");
                Files.copy(source, Paths.get(dest), StandardCopyOption.REPLACE_EXISTING);
            }
            else if (overrideImage.equals(ImageType.IMAGE_2)) {
                dest = config.getProperty("image2.path");
                Files.copy(source, Paths.get(dest), StandardCopyOption.REPLACE_EXISTING);
            }
            else {
                throw new IllegalArgumentException("Use enums defined in the ImageType.");
            }
        }
        catch (FileAlreadyExistsException ex) {
            System.err.println("FileAlreadyExistsException: Set overrideImage parameter to override it.");
        }
    }
}
