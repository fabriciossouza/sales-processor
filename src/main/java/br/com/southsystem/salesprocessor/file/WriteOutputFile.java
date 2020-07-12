package br.com.southsystem.salesprocessor.file;

import br.com.southsystem.salesprocessor.environment.Environment;
import br.com.southsystem.salesprocessor.model.Output;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import static br.com.southsystem.salesprocessor.util.FileUtils.createDoneFile;

public class WriteOutputFile {

    private static final Logger logger = LogManager.getLogger(FileExtractor.class);
    private Path inputFile;

    public WriteOutputFile(Path inputFile){
        this.inputFile = inputFile;
    }

    void writeOutputToNewFile(Output output){
        Path outputPath = Environment.getInstance().getOutputPath();
        if(null != outputPath && null != inputFile && null != output){
            logger.info("writing output: " + output);
            File outputFile = createDoneFile(outputPath, inputFile);
            try(PrintWriter writer = new PrintWriter(outputFile)) {
                writer.println(output.getTotalOfCustomersMessage());
                writer.println(output.getTotalOfSalesmenMessage());
                writer.println(output.getMostExpensiveSaleIdMessage());
                writer.println(output.getWorstSalesmanNameMessage());
            } catch (FileNotFoundException ex) {
                logger.error(ex.getMessage(), ex);
            }
        }
    }



}
