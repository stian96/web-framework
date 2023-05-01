package no.hiof.webframework.application.Tools;

import no.hiof.webframework.application.enums.ImageType;
import no.hiof.webframework.Exceptions.ImageOverloadException;

import java.io.IOException;
import java.nio.file.*;
import java.util.Properties;

/**
 * The ImageUtility class provides utility methods for handling image files in a web application.
 * It contains methods for copying image files to designated paths, with support
 * for max two images and overriding default images with new ones.
 * It also reads from a config.properties to get the image paths
 * fot the designated locations.
 */

public class ImageUtility {
    private static int imageCounter = 0;

    private static final Properties config;

    static  {
        config = new Properties();

        try {
            config.load(ImageUtility.class.getResourceAsStream("/config.properties"));
        }
        catch (Exception ex) {
            System.err.println("Error loading config properties: " + ex.getMessage());
        }
    }

    /**
     * Copies an image file from the given source path to a designated destination path,
     * based on the current imageCounter. The imageCounter is incremented by 1 after a
     * successful copy.
     * @param sourcePath The path of the source image file to be copied.
     * @throws ImageOverloadException Throws an ImageOverloadException if the imageCounter
     * is 2 or greater, indicating that only two images are allowed to be added.
     */
    protected static void copyImageFile(String sourcePath) throws ImageOverloadException {
        Path source = Paths.get(sourcePath);
        String destination = "";

        if (imageCounter == 0)
            destination = config.getProperty("image1.path");
        else if (imageCounter == 1)
            destination = config.getProperty("image2.path");
        else {
            String msg = "Can only add max two images, use overrideImage parameter to add more.";
            throw new ImageOverloadException(msg);
        }

        Path destinationPath = Paths.get(destination);
        copyFile(source, destinationPath);
        imageCounter++;
    }

    /**
     * Copies an image file from the given source path to a designated destination path,
     * based on the ImageType enum parameter The destination path is read from the
     * config.properties file based on the ImageType enum parameter. The file is copied
     * with the REPLACE_EXISTING option, which overwrites any existing file with the same name.
     * @param sourcePath The path of the source image file to be copied
     * @param overrideImage The ImageType enum indicating which image to override with the copied file
     * @throws IllegalArgumentException If the ImageType enum parameter is not one of the defined enums in the ImageType class
     * @throws IOException If an I/O error occurs while copying the file
     */
    protected static void copyImageFile(String sourcePath, ImageType overrideImage) throws IOException {
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
        catch (NullPointerException ex) {
            System.err.println("Override image parameter cannot be null!");
        }
    }

    private static void copyFile(Path source, Path destination) {
        try {
            Files.copy(source, destination);
        }
        catch (IOException ex) {
            System.err.println("Image file is already added, remove the addIconImageToChat call.");
        }

    }
}
