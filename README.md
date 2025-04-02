# Download and Zip Files

Este projeto contém um código Java que realiza o download de dois arquivos PDF a partir de URLs fornecidas e os compacta em um único arquivo ZIP. Ele utiliza as bibliotecas `java.io`, `java.net` e `java.nio` para o gerenciamento de arquivos, além da classe `ZipOutputStream` para a compressão dos arquivos.

## Funcionalidade

1. **Download de Arquivos PDF**: O código faz o download de dois arquivos PDF a partir de URLs fornecidas.
2. **Compactação**: Após o download, os arquivos são compactados em um arquivo ZIP chamado `Anexos.zip`.
3. **Gerenciamento de Erros**: Caso haja qualquer falha no processo de download ou compactação, o erro será impresso no console.

## Como Usar

### Requisitos
- Java 8 ou superior.
- Conexão com a internet para download dos arquivos.

### Passos

1. Clone este repositório ou faça o download dos arquivos.
2. Compile e execute o código Java.

Para compilar e rodar o programa, basta seguir os seguintes comandos (caso tenha o `javac` instalado):

```bash
# Para compilar o código
javac DownloadAndZip.java

# Para executar o código
java DownloadAndZip
