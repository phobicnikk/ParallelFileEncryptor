import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import java.io.IOException;


public class PdfEncryption {
    public static void main(String[] args) throws IOException {
        // Load the PDF file
        File file = new File("C:\\Users\\Nikhil Nishane\\Downloads\\megha.pdf");
        PDDocument document = PDDocument.load(file);

        // Create AccessPermission instance
        AccessPermission accessPermission = new AccessPermission();

        // Create StandardProtectionPolicy instance
        StandardProtectionPolicy protectionPolicy = new StandardProtectionPolicy("abcd", "abcd", accessPermission);

        // Set encryption key length
        protectionPolicy.setEncryptionKeyLength(128);

        // Set permissions
        protectionPolicy.setPermissions(accessPermission);

        // Protect the PDF file
        document.protect(protectionPolicy);

        // Save and close the document
        document.save("C:\\Users\\Nikhil Nishane\\Downloads\\megha.pdf");
        document.close();

        System.out.println("PDF Encrypted successfully...");
    }
}
