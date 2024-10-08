package com.quarks.test.pipelinefunctions

def call() {
    if (env.gitlabActionType == 'MERGE') {
        echo "Checking out merged branch..."
        new checkoutMergedBranch().call()
    }
}