package com.sakebook.gradle.versioning.plugin

import org.gradle.api.tasks.TaskAction

class PatchTask extends VersioningTask {

    @TaskAction
    def patchVersionUp() {
        readPropertyFile(BuildType.PATCH)
    }
}