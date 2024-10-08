package com.quarks.test.pipelinefunctions

def call(String dockerImageLocation = "Dockerfile") {
    if (env.DOCKER_BUILD == 'true') {
        echo "Building Docker image..."
        // env.dockerImage = docker.build(env.DOCKER_IMAGE, ". --build-arg --no-cache -f ${dockerImageLocation}")
    }
}