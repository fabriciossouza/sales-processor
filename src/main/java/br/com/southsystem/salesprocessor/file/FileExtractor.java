package br.com.southsystem.salesprocessor.file;

import br.com.southsystem.salesprocessor.model.Output;
import br.com.southsystem.salesprocessor.parser.EntityParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileExtractor {

   private static final Logger logger = LogManager.getLogger(FileExtractor.class);

   public Output extract(Path inputFile){
      Output output = null;
      try {
         if (isValidFile(inputFile)) {
            logger.info("Extracting data from: " + inputFile);
            List<String> lines = Files.readAllLines(inputFile);
            EntityParser entityParser = new EntityParser();
            for (String line: lines) {
               entityParser.parse(line);
            }
            output = entityParser.buildOutput();
         } else {
            logger.error(String.format("Aborting extraction: '%s' is not a .DAT file\n",  inputFile));
         }
      } catch (IOException exception) {
         logger.error(exception.getMessage(), exception);
      }
      return output;
   }

   private boolean isValidFile(Path inputFile){
      return inputFile != null  && inputFile.toString().endsWith(".dat");
   }
}
