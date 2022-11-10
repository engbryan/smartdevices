package org.acme;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import org.acme.annotation.ProtoService;

public class ServiceConverter {

    private static final String ROOT_DIR = "target/classes/";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        var packageName = ServiceConverter.class.getPackageName();

        var path = Paths.get(ROOT_DIR + packageName.replaceAll("\\.", "/"));

        readPath(path);
    }

    private static void readPath(Path path) throws IOException, ClassNotFoundException {

        var files = Files.list(path)
                .collect(Collectors.toList());

        for (var item : files) {

            if (item.toFile().isDirectory()) {

                readPath(item);

                continue;
            }

            readFile(item);
        }
    }

    private static void readFile(Path path) throws ClassNotFoundException {

        var file = path.toFile();

        var packageName = file.getParent()
                .replace(ROOT_DIR, "")
                .replaceAll("/", ".");

        var className = file.getName();

        className = className.substring(0, className.lastIndexOf('.'));

        var iClass = Class.forName(packageName + "." + className);

        var service = iClass.getAnnotation(ProtoService.class);

        if (service == null) {
            return;
        }

        var javaPackage = iClass.getPackageName();

        var protoPath = ROOT_DIR + "/proto";

        var protoFile = Paths.get(protoPath + "/service/" + iClass.getSimpleName().toLowerCase() + ".proto");

        protoFile.getParent().toFile().mkdirs();

        try ( var proto = Files.newOutputStream(protoFile)) {

            var content = new StringBuilder();

            content.append("syntax = \"proto2\";\n\n");

            content.append("option java_multiple_files = true;\n");

            content.append("option java_package = \"")
                    .append(javaPackage)
                    .append("\";\n\n");

            content.append("import public \"dto.proto\";\n\n");

            content.append("package grpc;\n\n");

            content.append("service ")
                    .append(iClass.getSimpleName())
                    .append(" {\n\n");

            proto.write(content.toString().getBytes());

            readSuperClass(iClass, proto);

            printMethods(iClass, proto);

            proto.write("}".getBytes());

            proto.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void readSuperClass(Class<?> iClass, OutputStream proto) throws IOException {

        var superClass = iClass.getSuperclass();

        while (superClass != null) {

            printMethods(superClass, proto);

            superClass = superClass.getSuperclass();
        }
    }

    private static void printMethods(Class<?> iClass, OutputStream proto) throws IOException {

        if (iClass.equals(Object.class)) {
            return;
        }

        var methods = iClass.getDeclaredMethods();

        for (var method : methods) {

            var params = method.getParameters();

            if (params.length == 0) {
                continue;
            }

            var paramType = params[0].getType();

            if (paramType.isPrimitive()) {
                continue;
            }

            var returnType = method.getReturnType();

            if (returnType.isPrimitive()) {
                continue;
            }

            if (returnType.equals(Object.class)) {
                continue;
            }

            var content = "\trpc " + method.getName() + "(dto." + paramType.getSimpleName() + ") returns (dto." + returnType.getSimpleName() + ");\n\n";

            proto.write(content.getBytes());
        }
    }
}
