package paquete;

import java.io.File;
import javax.swing.filechooser.FileSystemView;

public class SingleRootFileSystemView extends FileSystemView {

    File root;
    File[] roots = new File[1];

    public SingleRootFileSystemView(File root) {
        super();
        this.root = root;
        roots[0] = root;
    }

    public File getParentDirectory(File dir) {
        return getDefaultDirectory();
    }

    public File createNewFolder(File containingDir) {
        File folder = new File(containingDir, "New Folder");
        folder.mkdir();
        return folder;
    }

    public File getDefaultDirectory() {
        return root;
    }

    public File getHomeDirectory() {
        return root;
    }

    public File[] getRoots() {
        return roots;
    }
}