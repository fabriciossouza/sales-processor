package br.com.southsystem.salesprocessor.file;

import br.com.southsystem.salesprocessor.model.Output;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.file.Path;

public class FileProcessor {

    private static final Logger logger = LogManager.getLogger(FileProcessor.class);

    public void process(Path inputFile) {
        logger.info("Processing input file: %s\n", inputFile);

        Output output = new FileExtractor().extract(inputFile);
        new WriteOutputFile(inputFile).writeOutputToNewFile(output);
        new FileInput(inputFile).moveToProcessed();
    }
}
