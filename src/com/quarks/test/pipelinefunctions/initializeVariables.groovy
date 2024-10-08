
package com.quarks.test.pipelinefunctions

def call(Map pipelineParams) {
    echo "About to initialize variables"
    
    // Jenkins provides the GIT_BRANCH variable which includes refs/heads/
    def branchName = env.GIT_BRANCH.replaceAll('refs/heads/', '')
    echo "GitHub Branch Name: ${branchName}"

    // Determine if this is a pull request using Jenkins CHANGE_ID env variable (for PRs)
    def isPullRequest = env.CHANGE_ID != null

    env.DEPLOY_BUILD = "false"
    env.DOCKER_BUILD = "false"

    def isDeployableBranch = { branch ->
        return pipelineParams.DEPLOYABLE_BRANCHES.any { pattern ->
            def regex = pattern.replace("*", ".*")
            return branch ==~ regex
        }
    }

    if (!isPullRequest && isDeployableBranch(branchName)) {
        // If it's not a pull request and it's a deployable branch
        env.DEPLOY_BUILD = 'true'
        env.DOCKER_IMAGE = "ghcr.io/" + pipelineParams.registry + "/${branchName}:" + env.BUILD_NUMBER
        echo "Deployment allowed for branch: ${branchName}."
    } else if (isPullRequest) {
        // If this is a pull request (CHANGE_ID will be set)
        env.BUILD_AND_TEST = 'true'
        echo "This is a pull request (ID: ${env.CHANGE_ID}). Only build and test will proceed."
    } else {
        echo "No deployment for branch: ${branchName}."
    }
}

