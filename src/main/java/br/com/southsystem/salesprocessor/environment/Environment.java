package br.com.southsystem.salesprocessor.environment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Environment {

   private static final Logger logger = LogManager.getLogger(Environment.class);
   private static final String HOMEPATH = "user.home";
   private static final String DATA_IN = "/data/in";
   private static final String DATA_OUT = "/data/out";
   private static final String DATA_PROCESSED = "/data/processed";

   private static Environment myInstance;
   
   private String base;
   private Path inputPath;
   private Path outputPath;
   private Path processedPath;

   private Environment(){
      this.init();
   }

   public static Environment getInstance() {
      if( myInstance == null ) {
         myInstance = new Environment();
      }
      return myInstance;
   }


   public Path getInputPath() {
      return inputPath;
   }

   public Path getOutputPath() {
      return outputPath;
   }

   public Path getProcessedPath() {
      return processedPath;
   }

   private void init(){
      try {
         this.initInputPath();
         this.initOutputPath();
         this.initProcessedPath();
      } catch (Exception e) {
         exit(e.getMessage());
      }
   }
   

   private void initInputPath(){
      this.base = System.getProperty(HOMEPATH);
      if (null == this.base) {
         exit("Undefined environment variable 'user.home'");
      }
      String in = this.base + DATA_IN;
      this.inputPath = Paths.get(in);
   
      if (!this.inputPath.toFile().exists()) {
         exit("Does not exist: " + in);
      } else if (!this.inputPath.toFile().isDirectory()) {
         exit("Not a directory: " + in);
      } else if (!this.inputPath.toFile().canRead()) {
         exit("Could not read: " + in);
      }
      logger.info("Input Path: " + this.inputPath);
   }

   private void initOutputPath(){
      String out = this.base + DATA_OUT;
      this.outputPath = createDirectory(out);
      logger.info("Output Path: " + this.outputPath);
   }

   private void initProcessedPath(){
      String processed = this.base + DATA_PROCESSED;
      this.processedPath = createDirectory(processed);
      logger.info("Processed Path: " + this.processedPath);
   }

   private Path createDirectory(String path) {
      Path directory = Paths.get(path);
      if (!directory.toFile().exists()) {
         if (!directory.toFile().mkdirs()) {
            throw new RuntimeException("Could not create: " + path);
         }
      } else if (!directory.toFile().isDirectory()) {
         throw new RuntimeException("Not a directory: " + path);
      }
      return directory;
   }

   private void exit(String message) {
      logger.error(message);
      System.exit(1);
   }
}
