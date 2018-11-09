package managerArchives;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UploadArchives {
	public File returnArchive() {
		JFileChooser fileOpen = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("Certificados PFX", "pfx");
		fileOpen.addChoosableFileFilter(filter);
		fileOpen.showDialog(null, "Upload Arquivo");
		File selectedFile = fileOpen.getSelectedFile();

		return selectedFile;
	}
}