package org.taruts.gradleUtils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.taruts.processUtils.ProcessRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GradleBuilder {

    public static void buildGradleProject(File directory) {

        List<String> commandsList = new ArrayList<>();

        String fileName;
        if (SystemUtils.IS_OS_WINDOWS) {
            fileName = "gradlew.bat";
        } else {
            commandsList.add("sh");
            fileName = "gradlew";
        }

        File gradleWrapperFile = FileUtils.getFile(directory, fileName);
        commandsList.add(gradleWrapperFile.getAbsolutePath());

        commandsList.add("classes");

        String[] commandsArray = commandsList.toArray(String[]::new);

        ProcessRunner.runProcess(directory, commandsArray);
    }
}
