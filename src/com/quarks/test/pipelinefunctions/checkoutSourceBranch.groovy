package com.quarks.test.pipelinefunctions

def call() {
    if (env.gitlabActionType != 'MERGE') {
        echo "Checking out Git Branch ${env.gitlabSourceBranch}"
        checkout scm
    }
    echo 'Done with SCM Checkout'
}