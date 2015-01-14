package com.sakebook.gradle.versioning.plugin

import org.gradle.api.DefaultTask

class VersioningTask extends DefaultTask {

    enum BuildType{
        MAJOR, MINOR, PATCH
    }

    protected void readPropertyFile(BuildType type) {
        readFile(project.rootDir.path+"/gradle.properties", type)
    }

    private void readFile(String filePath, BuildType type) {
        File propFile = new File(filePath)

        StringBuffer buff = new StringBuffer();
        propFile.eachLine('UTF-8') {
            println "line: " + it
            if (it.matches("VERSION_NAME=.*")) {
                it = versionUp(type, it)
            }

            if (it.matches("VERSION_CODE=.*")) {
                it = versionUpCode(it)
            }
            buff.append(it+"\n")
            it
        }
        propFile.write(buff.toString(), 'UTF-8')
    }

    def versionUp(BuildType type, String versionNames) {
        switch (type) {
            case BuildType.MAJOR:
                return majorUp(versionNames)
                break;
            case BuildType.MINOR:
                return minorUp(versionNames)
                break;
            case BuildType.PATCH:
                return patchUp(versionNames)
                break;
        }
    }

    def majorUp(String versionName) {
        String after = versionName.replaceAll(/([0-9]+)\.([0-9]+)\.([0-9]+)/){
            int i = Integer.parseInt(it[1]);
            i++;
            String.valueOf(i+".0.0");
        };
        return after
    }

    def minorUp(String versionName) {
        String after = versionName.replaceAll(/([0-9]+)\.([0-9]+)\.([0-9]+)/){
            int i = Integer.parseInt(it[2]);
            i++;
            String.valueOf(it[1]+"."+i+".0");
        };
        return after
    }

    def patchUp(String versionName) {
        String after = versionName.replaceAll(/([0-9]+)$/){
            int i = Integer.parseInt(it[0]);
            i++;
            String.valueOf(i);
        };
        return after
    }

    def versionUpCode(String versionCode) {
        String after = versionCode.replaceAll(/([0-9]+)$/){
            int i = Integer.parseInt(it[0]);
            i++;
            String.valueOf(i);
        };
        return after
    }
}
