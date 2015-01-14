package com.sakebook.gradle.versioning.plugin

import org.gradle.api.tasks.TaskAction

class MajorTask extends VersioningTask {

    @TaskAction
    def majorVersionUp() {
        readPropertyFile(BuildType.MAJOR)
    }
}