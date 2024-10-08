package com.quarks.test.pipelinefunctions

def call(){
    def gitCommitHash = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
    echo "Git Commit Hash: ${gitCommitHash}"

    // Create a JSON payload with the necessary information
    def payload = [
                        event: 'build_complete',
                        job_name: env.JOB_NAME,
                        build_number: env.BUILD_NUMBER,
                        result: currentBuild.result,
                        commit_hash: gitCommitHash,
                    ]
    def jsonOutput = JsonOutput.toJson(payload)
    echo "${jsonOutput}"

}