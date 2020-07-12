package br.com.southsystem.salesprocessor.file;

import br.com.southsystem.salesprocessor.environment.Environment;
import br.com.southsystem.salesprocessor.util.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInput {

    private static final Logger logger = LogManager.getLogger(FileExtractor.class);
    private Path inputFile;

    public FileInput(Path inputFile){
        this.inputFile = inputFile;
    }


    public void moveToProcessed(){
        try {
            Path processedPath = Environment.getInstance().getProcessedPath();
            if(inputFile != null) {
                File oldInputFile = inputFile.toFile();
                File newFile = FileUtils.createFile(
                        processedPath, inputFile.getFileName().toString());
                inputFile.toFile().renameTo(newFile);
                Files.deleteIfExists(oldInputFile.toPath());
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }


}
