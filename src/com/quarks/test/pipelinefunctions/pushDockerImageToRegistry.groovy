package com.quarks.test.pipelinefunctions

def call() {
    if (env.DOCKER_BUILD == 'true') {
        echo "Pushing to docker registry..."
        // docker.withRegistry('http://registry.gitlab.com', env.registryCredentials) {
        //     dockerImage.push()
        // }
    }
}