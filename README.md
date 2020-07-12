## Requisitos de Software

- JDK 1.8 or later
- Maven 3 or later

## Frameworks
 - Java IO  - Trabalhar com tratamento de Arquivos e Diretórios
 - Java NIO - Esculta eventos dos arquivos postados no diretorio de entrada
 - Log4j
 
 
 ## Como executar?

- Construção da aplicação.          
    > mvn clean package

- A seguir, digite o seguinte comando para rodar a aplicação.
   > cd target/
                                                                
   > java -jar salesprocessor-1.0.0-SNAPSHOT.jar
 
 ## Como testar?      

- Os arquivos com extensão '.dat' devem ser colocados no diretorio: 
   > %HOMEPATH%/data/in

- Os arquivos processados serão armazenados em:
   > %HOMEPATH%/data/out            
- Exemplo de Saida:

      Listen to file events...
      Input Path: /home/your_user/data/in
      Output Path: /home/your_user/data/out
      Processed Path: /home/your_user/data/processed
      Listen to file events...
      Processing input file: /home/your_user/data/in/lote1.dat
      Extracting data from: /home/your_user/data/in/lote1.dat
      Line parsed: 001ç1234567891234çDiegoç50000
      Line parsed: 001ç3245678865434çRenatoç40000.99
      Line parsed: 002ç2345675434544345çJose da SilvaçRural
      Line parsed: 002ç2345675433444345çEduardo PereiraçRural
      Line parsed: 003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego
      Line parsed: 003ç08ç[1-34-1000,2-33-1.50,3-40-0.10]çRenato
      writing output: Output{totalOfCustomers=2, totalOfSalesmen=2, mostExpensiveSaleId=8, worstSalesmanName='Diego'}
      New file created: /home/your_user/data/out/lote1.done.dat
      New file created: /home/your_user/data/processed/lote1.dat
      Disposing file: /home/your_user/data/processed/lote1.dat                                                                                                   