package com.sakebook.gradle.versioning.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by sakemotoshinya on 15/01/11.
 */
class VersioningPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        def extention = project.extensions.create("versioning", VersioningExtention.class)

        project.task('info') << {
            println "versionName: ${extention.versionName}"
            println "tagName: ${extention.tagName}"
            println "versionCode: ${extention.versionCode}"
        }

        project.task("major", type: MajorTask)
        project.task("minor", type: MinorTask)
        project.task("patch", type: PatchTask)
    }
}
