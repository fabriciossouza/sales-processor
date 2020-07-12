package br.com.southsystem.salesprocessor;

import br.com.southsystem.salesprocessor.listener.InputDirectoryListener;

import java.io.IOException;

public class Application {


   public static void main(String[] args) throws IOException {
      new InputDirectoryListener().listenToEvents();
   }
}
