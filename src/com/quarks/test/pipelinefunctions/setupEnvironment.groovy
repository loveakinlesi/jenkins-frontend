package com.quarks.test.pipelinefunctions

def call(Map pipelineParams) {
    environment {
        repository = "${pipelineParams.repository}"
        registry = "${pipelineParams.registry}"
        registryCredentials = "${pipelineParams.registryCredentials}"
        namespace = "${pipelineParams.namespace}"
        devBranch = "${pipelineParams.devBranch}" ?: "review-dev"
        k8sCredentialsId = "${pipelineParams.k8sCredentialsId}"
        k8sServerUrl = "${pipelineParams.k8sServerUrl}"
        k8sClusterName = "${pipelineParams.k8sClusterName}"
        DEPLOYABLE_BRANCHES = pipelineParams.deployableBranches ?: ["review-dev", "hotfix", "master", "main"]
        GCLOUD_PROJECT = "${pipelineParams.gcloudProjectName}"
        dockerImage =''
    }
}