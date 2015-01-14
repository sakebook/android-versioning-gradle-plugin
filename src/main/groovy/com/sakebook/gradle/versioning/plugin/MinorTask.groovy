package com.sakebook.gradle.versioning.plugin

import org.gradle.api.tasks.TaskAction

class MinorTask extends VersioningTask {

    @TaskAction
    def minorVersionUp() {
        readPropertyFile(BuildType.MINOR)
    }
}