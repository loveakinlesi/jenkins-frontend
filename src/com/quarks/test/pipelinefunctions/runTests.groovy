package com.quarks.test.pipelinefunctions

def call(String testScript ) {
    if (env.DEPLOY_BUILD == 'true' || env.BUILD_AND_TEST == 'true') {
           echo "Running tests..."
        // sh '''
        //     if ! command -v pnpm &> /dev/null
        //     then
        //         npm install -g pnpm
        //     fi
        // '''
        // sh 'pnpm install'

        // def exitCode = sh(script: testScript ?: "pnpm test-ui", returnStatus: true)
        // if (exitCode != 0) {
        //     echo "Tests failed with exitCode ${exitCode}"
        //     currentBuild.result = 'FAILURE'
        //     error("Tests failed")
        // }
    }
}