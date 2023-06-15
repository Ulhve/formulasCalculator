package com.example.calculator.service.utils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.*;

public class ReflectionUtils {

    public static final char FILE_EXTENSION_DIVIDER = '.';

    public static void compileSourceFiles(Path path) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable compilationUnits = fileManager.getJavaFileObjects(path);
        fileManager.setLocation(StandardLocation.CLASS_PATH, Arrays.asList(path.toFile()));
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, compilationUnits);
        task.call();
    }

    public static Class getCompiledClass(Path path) throws ClassNotFoundException, MalformedURLException {
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{path.getParent().toUri().toURL()},null);
        String fileName = path.getFileName().toString();
        return urlClassLoader.loadClass(fileName.substring(0,fileName.lastIndexOf(FILE_EXTENSION_DIVIDER)));
    }

}
