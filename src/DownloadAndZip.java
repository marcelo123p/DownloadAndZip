import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DownloadAndZip {
    public static void main(String[] args) {
        try {
            String urlAnexo1 = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos/Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf";
            String urlAnexo2 = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos/Anexo_II_DUT_2021_RN_465.2021_RN628.2025_RN629.2025.pdf ";

            Path file1 = Path.of("Anexo_I.pdf");
            Path file2 = Path.of("Anexo_II.pdf");

            downloadFile(urlAnexo1, file1);
            downloadFile(urlAnexo2, file2);

            Path zipPath = Path.of("Anexos.zip");
            try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipPath.toFile()))) {
                zipFile(file1, zipOut);
                zipFile(file2, zipOut);
            }

            System.out.println("✅ Download e compactação concluídos com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void downloadFile(String urlString, Path destino) throws IOException {
        URL url = new URL(urlString);
        Files.copy(url.openStream(), destino, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("📂 Arquivo salvo em: " + destino.toAbsolutePath());
    }

    private static void zipFile(Path file, ZipOutputStream zipOut) throws IOException {
        try (FileInputStream fis = new FileInputStream(file.toFile())) {
            ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
            zipOut.putNextEntry(zipEntry);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zipOut.write(buffer, 0, length);
            }
            zipOut.closeEntry();
        }
    }
}
