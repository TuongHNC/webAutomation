package utilities;

import java.io.File;

public class FileDirUtils {

    public static void checkIfDirectoryExist(String directoryName) {
//        String directoryName = FrameworkConfig.getInstance().getProperty("report.path").concat(this.getClassName());
        File directory = new File(directoryName);
        if (! directory.exists()){
            directory.mkdir();
        }
    }
}
