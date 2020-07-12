package br.com.southsystem.salesprocessor.listener;

import br.com.southsystem.salesprocessor.environment.Environment;
import br.com.southsystem.salesprocessor.file.FileProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

public class InputDirectoryListener {

   private static final Logger logger = LogManager.getLogger(InputDirectoryListener.class);
   private WatchService watchService;

   public InputDirectoryListener() throws IOException{
      this.watchService = FileSystems.getDefault().newWatchService();
      Environment.getInstance().getInputPath().register(watchService, ENTRY_CREATE);
   }

   /**
    * Esculta eventos dos arquivos postados na diretorio de entrada
    */
   public void listenToEvents() {
      for (;;) {
         WatchKey key = getWatchKey();

         for (WatchEvent<?> event: key.pollEvents()) {
            if (OVERFLOW == event.kind()) {
               continue;
            }
            Path inputFile = getInputFile((WatchEvent<Path>) event);
            new FileProcessor().process(inputFile);
         }

         // Reset the key -- this step is critical if you want to
         // receive further watch events.  If the key is no longer valid,
         // the directory is inaccessible so exit the loop.
         if (!key.reset()) {
            break;
         }
      }
   }

   private WatchKey getWatchKey(){
      WatchKey key = null;
      try {
         logger.info("Listen to file events...");
         key = watchService.take();
         Thread.sleep(1000);
      } catch (InterruptedException ie) {
         // ignored
      }
      return key;
   }

   private Path getInputFile(WatchEvent<Path> event){
      Path inputFileName = event.context();
      return Environment.getInstance().getInputPath().resolve(inputFileName);
   }
}
