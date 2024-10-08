package com.quarks.test.pipelinefunctions

def call() {
    if (env.DOCKER_BUILD == 'true') {
        // sh "docker rmi \$DOCKER_IMAGE"
           echo "Removing docker image..."
    }
}