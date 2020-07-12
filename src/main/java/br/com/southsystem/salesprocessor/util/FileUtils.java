package br.com.southsystem.salesprocessor.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileUtils {

    private static final Logger logger = LogManager.getLogger(FileUtils.class);
    private static final String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();
    private static final String DAT_EXTENSION = ".dat";
    private static final String DONE_DAT_EXTENSION = ".done.dat";
    private static final int FIRST_INDEX = 0;

    public static File createDoneFile(Path outputPath, Path inputFile) {
        String outputFileName = inputFile.getFileName().toString();
        int lastIndex = outputFileName.lastIndexOf(DAT_EXTENSION);

        StringBuilder fileName =
                new StringBuilder(outputFileName.substring(FIRST_INDEX, lastIndex))
                        .append(DONE_DAT_EXTENSION);
        return createFile(outputPath, fileName.toString());
    }

    public static File createFile(Path destinationPath, String fileName){
        StringBuilder fullFileName =
                new StringBuilder(destinationPath.toAbsolutePath().toString())
                        .append(FILE_SEPARATOR)
                        .append(fileName);
        logger.info("New file created: " + fullFileName);
        return new File(fullFileName.toString());
    }
}
